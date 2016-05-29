(ns pharmacy.panels.adaptation-email
  (:require
   [re-frame.core :as re-frame :refer [dispatch subscribe]]))


(defn component []
  (fn []
    [:div.box.container
     [:h1.title "Adaptation Email"]
     [:div "Your medication was successfully changed."]
     [:div
      [:a.button.is-primary {:on-click #(dispatch [:consult-pharmacist false])} "Fill Prescription"]]]))
