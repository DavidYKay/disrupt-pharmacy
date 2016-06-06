(ns pharmacy.components.personalization-modal
  (:require
   [pharmacy.components.utils.modal :refer [make-modal]]
   [re-frame.core :as re-frame :refer [dispatch]]))

(defn personalization-modal [modal-shown]
  (make-modal modal-shown
              #(dispatch [:personalization-modal false])
              [:div.box
               [:h1.title "Warning"]
               [:p "This drug score has not yet been tailored to you."]
               [:p "Please answer a few questions so that we can personalize your scores."]

               [:a.button.is-primary
                {:on-click #(dispatch [:personalization-modal false])}
                
                "I Understand"]]))
