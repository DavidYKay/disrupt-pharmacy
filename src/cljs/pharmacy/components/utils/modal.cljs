(ns pharmacy.components.utils.modal)

(defn make-modal [modal-shown on-dismiss title content button]
  [:div {:class (if modal-shown
                  "modal is-active"
                  "modal")}
   [:div.modal-background {:on-click on-dismiss}]
   [:div.modal-card
    [:header.modal-card-head
     [:p.modal-card-title title]]
    [:section.modal-card-body content]
    [:footer.modal-card-foot
     [:a.button.is-primary {:href (:href button)
                            :on-click (:on-click button)} (:text button)]]]])
