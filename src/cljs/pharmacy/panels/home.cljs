(ns pharmacy.panels.home
  (:require 
            [pharmacy.components.searchbox :refer [searchbox]]
            [pharmacy.components.top-bar :refer [top-bar]]
            [re-frame.core :as re-frame :refer [subscribe]]))

(def items [
            {:title "Drug Bible"
             :img "http://placehold.it/350x200"
             :text "Placeholder text about the Drug Bible"}
            {:title "Alternatives"
             :img "http://placehold.it/350x200"
             :text "Placeholder text about alternatives"}
            {:title "Consult"
             :img "http://placehold.it/350x200"
             :text "Placeholder text about consultation"}
            {:title "Fill Prescription"
             :img "http://placehold.it/350x200"
             :text "Placeholder text about filling Rx"}])

(defn component []
  (let [name (subscribe [:name])]
    (fn []
      [:div

       [top-bar]
       
       [:section.section
        [:div.container
         [:h1.title "DisPharm"]
         [:h2.subtitle "How effective are your drugs?"]

         [searchbox {:placeholder "Enter your drug"
                     :on-search #(println "Searched with term: " %)}]]]

       [:section.section
        [:div.container
         [:h4.subtitle.is-4 "Learn about the drugs you are taking"]
         [:h4.subtitle.is-4 "See alternatives"]
         [:h4.subtitle.is-4 "Consult a pharmacist"]
         [:h4.subtitle.is-4 "Get Prescriptions Filled"]]]

       (for [{:keys [title text img]} items]
         [:section.section
          [:div.container.columns
           [:div.column
            [:img {:src img}]]
           [:div.column
            [:h1.title title]
            [:p text]]]])])))
