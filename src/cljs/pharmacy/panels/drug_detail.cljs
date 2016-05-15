(ns pharmacy.panels.drug-detail
  (:require [pharmacy.components.zestimate-badge :refer [zestimate-badge]])

(defn component []
  (fn []
    [:div
     
     [:h1.title.drug-title "A-Spaz"]
     
     [zestimate-badge 90]
     [:div "Generic Name: hyoscyamine (HYE-oh-SYE-ameen)"]
     [:div "Brand Name: Examples include A-spaz and Levsin/SL"]

     [:p.drug-description "A-Spaz is an anticholingergic agent. It works by decreasing the motion of muscles in the stomach, intestines, and bladder. It also decreases the production of stomach acid."]
     
     [:button "Consult a Pharmacist"]
     [:button "Add to Cart"]

     [:div.sections
      [:button "Uses"]
      [:button "Side effects"]
      [:button "Alternative medications"]
      [:button "Efficacy and Interactions"]]
      

     ]))
