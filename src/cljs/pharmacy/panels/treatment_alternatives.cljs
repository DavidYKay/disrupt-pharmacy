(ns pharmacy.panels.treatment-alternatives
  (:require
   [clojure.string :refer [lower-case]]
   [pharmacy.components.drug-rating :refer [drug-rating]]
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
  (let [alternatives [{:name "Atorvastatin" :brand-name "Lipitor" :rating {:current 1 :max 5} :description "hello world" :cost 1 :tie true }
                      {:name "Rosuvastatin" :brand-name "Crestor" :rating {:current 1 :max 5} :description "hello world" :cost 1 :tie true }
                      {:name "Simvastatin"  :brand-name "Zocor" :rating {:current 3 :max 5} :description "hello world" :cost 1 }
                      {:name "Pravastatin"  :brand-name "Pravachol" :rating {:current 4 :max 5} :description "hello world" :cost 1 }
                      {:name "Lovastatin"   :brand-name "Mevacor" :rating {:current 5 :max 5} :description "hello world" :cost 1 :tie true }
                      {:name "Fluvastatin"  :brand-name "Crestor" :rating {:current 5 :max 5} :description "hello world" :cost 1 :tie true }]]

    (fn []
      [:div
       [top-bar]
       
       [:h1.title "Compare Therapy Options"]
       [:h2.subtitle "Cholesterol-lowering medications as ranked by pharmacists " [:a {:href "/#/survey/cholesterol"} "(*)"]]

       (for [{:keys [rating name brand-name cost tie description]} alternatives]
         ^{:key name}
         [:div.box
          [:a {:href (str "/#/drug/" (lower-case name))}
           [:span.rating (:current rating) ". "]
           [:span.drug-name name]
           [:span.brand-name " (" brand-name ")"]
           [:span.tie (if tie "(tie)" "")]
           [dollar-rating cost 4]
           
           [:div description]]])

       [:div "Note: For best results, any of the above therapies should be accompanied by a healthy diet and exercise"]
       [:div "(*) - View the raw pharmacist " [:a {:href ""} "poll results"]]

       ])))
