(ns pharmacy.components.join-button
  (:require
   [re-frame.core :as re-frame :refer [dispatch]]))

(defn join-button [logged-in]
  (fn []
    [:div.is-pulled-right
     (if logged-in
       [:span.tag.is-medium
        "Hi Mark!"]
       [:a.button.is-warning {:on-click #(dispatch [:set-active-panel :join-panel])}
        "Join / Sign In"])]))
