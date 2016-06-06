(ns pharmacy.components.appointment-modal
  (:require
   [pharmacy.components.utils.modal :refer [make-modal]]
   [re-frame.core :as re-frame :refer [dispatch]]))

(defn appointment-modal [modal-shown]
  (make-modal modal-shown
              #(dispatch [:consult-pharmacist false])
              [:div.box
               [:h1.title "Consultation Appointment Booked"]
               [:div "Please expect a phone call from pharmacist Dr. Nguyen at 3:00 pm on Wednesday June 8th, 2016.  If you need to update your contact phone number or change the appointment, please do so via the Patient Dashboard."]

               [:a.button.is-primary {:href "/#/adaptation-email"}
                "Fast Forward"]]))
