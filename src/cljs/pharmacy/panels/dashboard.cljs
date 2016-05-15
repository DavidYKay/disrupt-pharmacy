(ns pharmacy.panels.dashboard
  (:require
   [pharmacy.components.top-bar :refer [top-bar]]))

(defn component []
  (fn []
    [:div
     
     [top-bar]
     
     [:h1.title "Dashboard"]

     ]))
