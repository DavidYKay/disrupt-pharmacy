(ns pharmacy.components.personalization-question
  (:require
   [re-frame.core :as re-frame :refer [dispatch subscribe]]))

(defn personalization-question [kind k prompt]
  (let [v (subscribe [:questions kind k])]
    (fn []
      [:div
       [:div prompt]
       [:a {
            :class (if @v
                     "button is-primary"
                     "button")
            :on-click #(dispatch [:question kind k true])} "Yes"]
       [:a.button {
                   :class (if (or @v (nil? @v))
                            "button"
                            "button is-primary")
                   :on-click #(dispatch [:question kind k false])} "No"]])))
