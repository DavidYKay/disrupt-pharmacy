(ns pharmacy.panels.follow-up-email
  (:require
   [re-frame.core :as re-frame :refer [dispatch subscribe]]))


(defn component []
  (fn []
    [:div.box.container
     [:h1.title "DrugIQ Check-up"]

     [:p "Hi Mark!"]
     [:br]
     [:p "You’ve been taking atorvastatin for a month and we want to know how it’s been going."]
     [:br]
     
     [:p "Let us know the good or the bad with atorvastatin. What you share will help us learn what will work for you now and in the future, and also help the rest of the DrugIQ community."]
     [:br]
     [:p "Please fill out the box below with anything you’ve discovered after taking atorvastatin:"]

     [:input.input.is-large
      {:placeholder "It's been great! / I've experienced some side effects..."
       :type "text"}]
     [:br]

     [:a.button "Submit"]
 

     [:p "Thank you!"]

     [:p "Sincerely,"]
     [:p "DrugIQ"]]))

