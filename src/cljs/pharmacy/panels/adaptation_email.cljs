(ns pharmacy.panels.adaptation-email
  (:require
   [re-frame.core :as re-frame :refer [dispatch subscribe]]))


(defn component []
  (fn []
    [:div.box.container
     [:h1.title "Your doctor is on board!"]

     [:br]
     [:p "Your prescription for lovastatin has been changed to atorvastatin. "]

     [:br]

     [:p "Please click here to login and fill your prescription:"]

     [:div [:a.button.is-primary {:href "/#/follow-up-email"} "Fill Prescription"]]

     [:br]
     
     [:p "Sincerely,"]
     [:p "DrugIQ"]
     ]))
