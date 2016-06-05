(ns pharmacy.components.menu-button
  (:require
   [re-frame.core :as re-frame :refer [dispatch]]))

(defn menu-button []
  (fn []
    [:div.menu-button
     [:span.icon.is-medium.hoverable {:aria-hidden true
                     :on-click #(dispatch [:set-menu-open true])}
      [:i.fa.fa-bars ]]]))
