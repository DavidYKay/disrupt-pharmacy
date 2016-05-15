(ns pharmacy.components.menu-button
  (:require
   [re-frame.core :as re-frame :refer [dispatch]]))

(defn menu-button []
  (let [val (atom "")]
    (fn []
      [:div
       [:button {:on-click #(dispatch [:set-active-panel :menu-panel])}
        "Menu"]])))
