(ns pharmacy.components.join-button
  (:require
   [re-frame.core :as re-frame :refer [dispatch]]))

(defn join-button [logged-in]
  (fn []
    [:div.is-pulled-right
     (if logged-in
       [:a.button.is-warning {:on-click #(dispatch [:set-active-panel :join-panel])}
        "View Profile"]
       [:a.button.is-warning {:on-click #(dispatch [:set-active-panel :join-panel])}
        "Join / Sign In"])]))
