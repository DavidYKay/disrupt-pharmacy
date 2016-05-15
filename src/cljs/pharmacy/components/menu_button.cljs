(ns pharmacy.components.menu-button
  (:require
   [re-frame.core :as re-frame :refer [dispatch]]))

(defn menu-button []
  (fn []
    [:div.menu-button.hoverable
     [:span.icon.is-large
      [:i.fa.fa-bars {:aria-hidden true
                      :on-click #(dispatch [:set-active-panel :menu-panel])}]]]))
