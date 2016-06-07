(ns pharmacy.components.drug-scores-modal
  (:require
   [pharmacy.components.utils.modal :refer [make-modal]]
   [re-frame.core :as re-frame :refer [dispatch]]))

(defn drug-scores-modal [modal-shown]
  (let [dismiss #(dispatch [:drug-scores-modal false])]
    (make-modal modal-shown
                dismiss
                "Drug Scores"
                [:div
                 [:p "Drug scores are collected from over 9000 pharmacists"]]
                {:on-click dismiss
                 :text "OK"})))
