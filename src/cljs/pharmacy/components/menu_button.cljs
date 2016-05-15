(ns pharmacy.components.menu-button
  (:require
   [re-frame.core :as re-frame :refer [dispatch]]))

(defn menu-button []
  (let [val (atom "")]
    (fn []
      [:div.menu-button
       [:i.fa.fa-bars {:aria-hidden true
                       :on-click #(dispatch [:set-active-panel :menu-panel])}]])))
