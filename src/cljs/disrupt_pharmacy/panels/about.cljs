(ns disrupt-pharmacy.panels.about
  (:require [disrupt-pharmacy.routes :refer [url-for]]))

(defn component []
  (fn []
    [:div "This is the About Page."
     [:div [:a {:href (url-for :home)} "go to Home Page"]]]))
