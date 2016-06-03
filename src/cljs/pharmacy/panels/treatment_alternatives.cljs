(ns pharmacy.panels.treatment-alternatives
  (:require
   [clojure.string :refer [lower-case]]
   [pharmacy.components.drug-rating :refer [drug-rating]]
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
  (let [alternatives [{:name "Atorvastatin" :rating {:current 1 :max 5} :description "hello world" }
                      {:name "Rosuvastatin" :rating {:current 1 :max 5} :description "hello world" }
                      {:name "Simvastatin" :rating {:current 3 :max 5} :description "hello world" }
                      {:name "Pravastatin" :rating {:current 4 :max 5} :description "hello world" }
                      {:name "Lovastatin" :rating {:current 5 :max 5} :description "hello world" }
                      {:name "Fluvastatin" :rating {:current 5 :max 5} :description "hello world" }]]

    ;; Atorvastatin -> Rasuvastatin
    ;; Consult Rasuvastatin
    ;; Adaptation conversation with dr.

    (fn []
      [:div
       [top-bar]

       [:h1.title "Alternatives to Lovastatin"]

       (for [{:keys [rating name description]} alternatives]
         ^{:key name}
         [:div.box
          [:a {:href (str "/#/drug/" (lower-case name))}
           ;; [drug-rating (:current rating)]
           [:div (:current rating) "/" (:max rating)]
           [:h2.subtitle name]
           [:div description]]])

       [:div "Note: drug therapy should always be accompanied by a healthy diet and exercise."]
       ])))
