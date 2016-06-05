(ns pharmacy.panels.adaptation-email
  (:require
   [re-frame.core :as re-frame :refer [dispatch subscribe]]))


(defn component []
  (fn []
    [:div.box.container
     [:h1.title "Drug Adaptation Email"]
     [:p "This e-mail is to confirm that your pharmacist, Dr. Nguyen, has spoken to your prescribing doctor, and has successfully changed your prescription from Lovastatin to Atorvastatin."]

     [:p "Please click this button to fill your prescription:"]
     
     [:div [:a.button.is-primary {:href "/#/follow-up-email"} "Fill Prescription"]]
     
     [:p "Sincerely,"]
     [:p "DrugIQ"]]))
