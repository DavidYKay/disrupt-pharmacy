(ns pharmacy.components.join-button
  (:require
   [re-frame.core :as re-frame :refer [dispatch]]))

(defn join-button []
  (let [val (atom "")]
    (fn []
      [:div
       [:a.button {:on-click #(dispatch [:set-active-panel :join-panel])}
        "Join"]])))
