(ns pharmacy.panels.follow-up-email
  (:require
   [re-frame.core :as re-frame :refer [dispatch subscribe]]))


(defn component []
  (fn []
    [:div.box.container
     [:h1.title "Follow-up Email"]

     [:p "You have been taking Atorvastatin for 1 month!  How has it been?  Let us know how your treatment is going by logging into your DrugIQ account and completing a short follow-up questionnaire, and provide any additional feedback you may have about your experience with the medication, as well as our service overall.  This will help us to improve our research, and ultimately provide you and the rest of our patients with the most optimal care."]

     [:p "Thank you!"]

     [:p "Sincerely,"]
     [:p "DrugIQ"]]))

