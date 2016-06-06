(ns pharmacy.components.consult-pharmacist-button
  (:require
   [re-frame.core :as re-frame :refer [dispatch]]))

(defn consult-pharmacist-button []
  [:a.button.consult-pharmacist-button
   {:on-click #(dispatch [:consult-pharmacist true])}
   "Consult Pharmacist"])
