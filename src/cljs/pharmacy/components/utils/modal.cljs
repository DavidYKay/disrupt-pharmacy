(ns pharmacy.components.utils.modal)
  
(defn make-modal [modal-shown on-dismiss content]
  [:div {:class (if modal-shown
                  "modal is-active"
                  "modal")}
   [:div.modal-background {:on-click on-dismiss}]
   [:div.modal-container
    [:div.modal-content
     ;;[:div.box
     content]]
   [:button.modal-close {:on-click on-dismiss}]])
