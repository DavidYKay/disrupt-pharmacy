(ns pharmacy.components.appointment-modal
  (:require
   [pharmacy.components.utils.modal :refer [make-modal]]
   [re-frame.core :as re-frame :refer [dispatch]]))

(defn appointment-modal [modal-shown]
  (make-modal modal-shown
              #(dispatch [:consult-pharmacist false])
               "Consultation Appointment Booked"
               [:div
                [:p "With pharmacist Dr. Nguyen at 3:00 pm on Wednesday June 8th, 2016."]
                [:p "If you need to update your contact phone number or change the appointment, please reply to this email."]]

               {:href "/#/adaptation-email"
                :text "Fast Forward"}))
