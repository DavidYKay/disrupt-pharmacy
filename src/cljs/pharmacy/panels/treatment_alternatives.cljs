(ns pharmacy.panels.treatment-alternatives
  (:require
   [clojure.string :refer [lower-case]]
   [pharmacy.components.alternative-therapy-rating :refer [alternative-therapy-rating]]
   [pharmacy.components.dollar-rating :refer [dollar-rating]]
   [pharmacy.components.top-bar :refer [top-bar]]))

;; Hipster Therapy
;; Ranking:
;; Atorvastatin 1 (tie)
;; Rosuvastatin 1 (tie)
;; Simvastatin 3
;; Pravastatin 4
;; Lovastatin 5 (tie)
;; Fluvastatin 5 (tie)
;;
;; Comment: drug therapy should always be accompanied by a healthy diet and exercise

(defn component []
  (let [alternatives [{:name "Atorvastatin" :brand-name "Lipitor" :rating {:current 1 :max 5} :description "a blurb about this drug" :cost 1 :tie true :recommend-score 8 :risk "B"}
                      {:name "Rosuvastatin" :brand-name "Crestor" :rating {:current 1 :max 5} :description "a blurb about this drug" :cost 1 :tie true :recommend-score 8 :risk "B" }
                      {:name "Simvastatin"  :brand-name "Zocor" :rating {:current 3 :max 5} :description "a blurb about this drug" :cost 1 :recommend-score 6 :risk "B" }
                      {:name "Pravastatin"  :brand-name "Pravachol" :rating {:current 4 :max 5} :description "a blurb about this drug" :cost 1 :recommend-score 5 :risk "B" }
                      {:name "Lovastatin"   :brand-name "Mevacor" :rating {:current 5 :max 5} :description "a blurb about this drug" :cost 1 :tie true :recommend-score 1 :risk "B" }
                      {:name "Fluvastatin"  :brand-name "Crestor" :rating {:current 5 :max 5} :description "a blurb about this drug" :cost 1 :tie true :recommend-score 1 :risk "B" }]]

    (fn []
      [:div
       [top-bar]

       [:section.section.head-title.has-text-centered
       [:h1.title "Compare Therapy Options"]
       [:h2.subtitle.is-5 "Cholesterol-lowering medications as ranked by pharmacists " [:a {:href "/#/survey/cholesterol"} " *"]]]

       (for [{:keys [rating name brand-name cost tie description recommend-score risk]} alternatives]
         ^{:key name}
         [:section.section.alternatives-page-drug-box
          [:a {:href (str "/#/drug/" (lower-case name))}
           [:div.columns.is-mobile
            [:div.column.alt-page-score.is-one-third
             [alternative-therapy-rating recommend-score]]
            [:div.column.content
             [:h4.drug-name name]
             [:div.ranking "Rank:" (:current rating) [:span.tie (if tie " (tie)" "")]]
             [:div.brand-name "Also known as " brand-name ]
             [dollar-rating cost 5]]]]])

      [:section.section.alternatives-foot
       [:p "Note: For best results, any of the above therapies should be accompanied by a healthy diet and exercise"]
       [:p "* View the raw pharmacist " [:a {:href ""} "poll results"]]]

       ])))
