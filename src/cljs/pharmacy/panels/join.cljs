(ns pharmacy.panels.join
  (:require
   [re-frame.core :as re-frame :refer [dispatch subscribe]]
   [pharmacy.components.x-button :refer [x-button]]))


(defn component []
  (fn []
    [:div.container
     [:div.box.columns
      [:div.column
       [x-button]
       
       [:h1.title "Join DisPharm"]
       [:h2.subtitle "for more personalized medication evaluations, ordering medication, or consulting our pharmacists."]

       [:input.input {:placeholder "Enter your email" :type "text"}]
       [:input.input {:placeholder "Set a password" :type "text"}]

       [:a.button
        {:on-click #(dispatch [:set-active-panel :input-phn-panel])}
        "Continue"]
       [:div "OR"]
       [:a.button
        {:on-click #(dispatch [:set-active-panel :login-panel])}
        "Sign In"]]]]))
