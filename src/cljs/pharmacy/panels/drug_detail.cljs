(ns pharmacy.panels.drug-detail
  (:require
   [pharmacy.components.zestimate-badge :refer [zestimate-badge]]
   [pharmacy.components.top-bar :refer [top-bar]]
   ))

(defn component []
  (fn []
    [:div

     [top-bar]
     
     [:section.section
      [:div.container.columns
       [:div.column
        [:h1.title.drug-title "A-Spaz"]]
       [:div.column
        [zestimate-badge 90]]]]
     
     [:section.section
      [:div.container
       [:div "Generic Name: hyoscyamine (HYE-oh-SYE-ameen)"]
       [:div "Brand Name: Examples include A-spaz and Levsin/SL"]]]

     [:section.section
      [:div.container
       
       [:p.drug-description "A-Spaz is an anticholingergic agent. It works by decreasing the motion of muscles in the stomach, intestines, and bladder. It also decreases the production of stomach acid."]
       ]]
     
     [:section.section
      [:div.container
       [:a.button "Consult a Pharmacist"]
       [:a.button "Add to Cart"]

       [:a.button "Uses"]
       [:a.button "Side effects"]
       [:a.button "Alternative medications"]
       [:a.button "Efficacy and Interactions"]]]

     ]))
