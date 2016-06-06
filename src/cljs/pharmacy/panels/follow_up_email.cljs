(ns pharmacy.panels.follow-up-email
  (:require
   [re-frame.core :as re-frame :refer [dispatch subscribe]]))


(defn component []
  (fn []
    [:div.box.container
     [:h1.title "Follow-up Email"]

     [:p "Hi Mark!"]
     [:p "This is your drugiQ check up."]
     [:p "You’ve been taking atorvastatin for a month and we want to know how it’s been going."]
     [:p "Let us know the good or the bad with atorvastatin. What you share will help us learn what will work for you now and in the future, and also help the rest of the drugiQ community."]
     [:p "Please fill out the box below with anything you’ve discovered after taking atorvastatin:"]

     [:input.input.is-large
      {:placeholder "It's been great! / I've experienced some side effects..."
       :type "text"
       ;:on-key-down (on-enter save)
       ;;:on-change (fn [ev]
       ;;             (reset! val (-> ev .-target .-value)))
       }]

     [:a.button "Submit"]
 

     [:p "Thank you!"]

     [:p "Sincerely,"]
     [:p "DrugIQ"]]))

