(ns pharmacy.panels.home
  (:require 
            [pharmacy.components.nav :as nav]
            [pharmacy.components.searchbox :refer [searchbox]]
            [re-frame.core :as re-frame :refer [subscribe]]))

(defn component []
  (let [name (subscribe [:name])]
    (fn []
      [:div
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
        [nav/component]
        ]])))
