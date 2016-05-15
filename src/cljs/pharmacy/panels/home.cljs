(ns pharmacy.panels.home
  (:require 
            [pharmacy.components.nav :as nav]
            [pharmacy.components.join-button :refer [join-button]]
            [pharmacy.components.menu-button :refer [menu-button]]
            [pharmacy.components.searchbox :refer [searchbox]]
            [re-frame.core :as re-frame :refer [subscribe]]))

(defn component []
  (let [name (subscribe [:name])]
    (fn []
      [:div
       
       [:div.top-bar
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

       [:div
        [:img {:src "http://placehold.it/150x150"}]
        [:H3 "Drug Bible"]
        [:p "Some body text about the drug bible"]]

       [:div
        [:img {:src "http://placehold.it/150x150"}]
        [:h3 "Alternatives"]
        [:p "Some body text about hipster therapy"]]

       [:div
        [:img {:src "http://placehold.it/150x150"}]
        [:h3 "Consult"]
        [:p "Some body text about consultation"]]
       
       [:div
        [:img {:src "http://placehold.it/150x150"}]
        [:h3 "Fill Prescription"]
        [:p "Some body text about filling a prescription"]]

       ])))
