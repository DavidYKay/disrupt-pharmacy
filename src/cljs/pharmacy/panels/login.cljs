(ns pharmacy.panels.login
  (:require
   [pharmacy.components.top-bar :refer [top-bar]]
   [re-frame.core :as re-frame :refer [dispatch subscribe]]))

(defn component []
  [:div
   
   [:h1.title "Login"]

   [:input.input {:placeholder "email" :type "text"}]
   [:input.input {:placeholder "password" :type "text"}]

   [:a.button
    {:on-click #(dispatch [:sign-in])}
    "Sign In"]
   ])
  
