(ns pharmacy.panels.about
  (:require 
            [pharmacy.components.nav :as nav]
            [re-frame.core :as re-frame :refer [subscribe]]))

(defn component []
  (fn []
    [:div "This is the About Page."

     [:h1 "About"]
     [:h2 "Team"]
     [:div "We are a great team of peoples"]
     
     ;; [nav/component]
     ]))
