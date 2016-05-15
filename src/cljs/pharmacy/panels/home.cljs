(ns pharmacy.panels.home
  (:require 
            [pharmacy.components.nav :as nav]
            [pharmacy.components.join-button :refer [join-button]]
            [pharmacy.components.menu-button :refer [menu-button]]
            [pharmacy.components.searchbox :refer [searchbox]]
            [re-frame.core :as re-frame :refer [subscribe]]))

(def items [
            {:title "Drug Bible"
             :img "http://placehold.it/150x150"
             :text "Placeholder text about the Drug Bible"}
            {:title "Alternatives"
             :img "http://placehold.it/150x150"
             :text "Placeholder text about alternatives"}
            {:title "Consult"
             :img "http://placehold.it/150x150"
             :text "Placeholder text about consultation"}
            {:title "Fill Prescription"
             :img "http://placehold.it/150x150"
             :text "Placeholder text about filling Rx"}])

(defn component []
  (let [name (subscribe [:name])]
    (fn []
      [:div.content
       
       [:div.top-bar.box
        [menu-button]
        [join-button]]

       
       [:h1 "DisPharm"]
       [:div "How effective are your drugs?"]

       [searchbox {:placeholder "Enter your drug"
                   :on-search #(println "Searched with term: " %)}]
       [:ul
        [:li "Learn abot the drugs you are taking"]
        [:li "See alternatives"]
        [:li "Consult a pharmacist"]
        [:li "Get Prescriptions Filled"]]


       (for [{:keys [title text img]} items]
         [:div.columns
          [:div.column
           [:img {:src img}]]
          [:div.column
           [:h1 title]
           [:p text]]])

       ])))
