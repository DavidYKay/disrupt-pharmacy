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
                 [:p "The " [:strong " percent score "] " indicates how many pharmacists would take this drug, given a risk score of A, B, C, or D."]

                 [:br]
                 [:p "The " [:strong " risk score "] " indicates the risk of experiencing a cardiovascular event (stroke, heart attack, death), where A is a low risk and D is a high risk."]]
                {:on-click dismiss
                 :text "OK"})))
