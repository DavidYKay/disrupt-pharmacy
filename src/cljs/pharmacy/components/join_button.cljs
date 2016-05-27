(ns pharmacy.components.join-button
  (:require
   [re-frame.core :as re-frame :refer [dispatch]]))

(defn join-button [phn]
  (fn []
    [:div.is-pulled-right
     (if (nil? @phn)
       [:a.button.is-warning {:on-click #(dispatch [:set-active-panel :join-panel])}
        "Join / Sign In"]
       [:a.button.is-warning {:on-click #(dispatch [:set-active-panel :join-panel])}
        "View Profile"])]))
