(ns pharmacy.panels.follow-up-email
  (:require
   [re-frame.core :as re-frame :refer [dispatch subscribe]]))


(defn component []
  (fn []
    [:div.box.container
     [:h1.title "Follow-up Email"]

     [:div "This is your follow-up."]
     [:div "Have you seen any adverse events in the last 3 months?"]

     [:div
      [:a.button.is-primary "Yes"]
      [:a.button.is-primary "No"]]
      
     ]))
