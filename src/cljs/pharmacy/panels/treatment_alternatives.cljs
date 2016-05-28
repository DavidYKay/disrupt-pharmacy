(ns pharmacy.panels.treatment-alternatives
  (:require
   [pharmacy.components.drug-rating :refer [drug-rating]]
   [pharmacy.components.top-bar :refer [top-bar]]))

(defn component []
  (let [alternatives [{:name "Exercise" :rating {:current 1 :max 8} :description "hello world" }
                      {:name "Diet" :rating {:current 2 :max 8} :description "hello world" }
                      {:name "Atorvastatin" :rating {:current 3 :max 8} :description "hello world" }
                      {:name "Rosuvastatin" :rating {:current 3 :max 8} :description "hello world" }
                      {:name "Simvastatin" :rating {:current 4 :max 5} :description "hello world" }
                      {:name "Lovastatin" :rating {:current 6 :max 8} :description "hello world" }
                      {:name "Fluvastatin" :rating {:current 6 :max 8} :description "hello world" }]]

    ;; Atorvastatin -> Rasuvastatin
    ;; Consult Rasuvastatin
    ;; Adaptation conversation with dr.
    ;; Followup email
    ;; Survey email

    (fn []
      [:div
       [top-bar]

       [:h1.title "Alternatives to Atorvastatin"]

       (for [{:keys [rating name description]} alternatives]
         ^{:key name}
         [:div.box
          [drug-rating (:current rating)]
          [:h2.subtitle name]
          [:div description]])])))
