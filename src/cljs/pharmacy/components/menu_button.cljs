(ns pharmacy.components.menu-button
  (:require
   [re-frame.core :as re-frame :refer [dispatch]]))

(defn menu-button []
  (fn []
    [:div.menu-button.hoverable
     [:span.icon.is-medium
      [:i.fa.fa-bars {:aria-hidden true
                      :on-click #(dispatch [:set-menu-open true])}]]]))
