(ns pharmacy.panels.consult
  (:require
   [pharmacy.components.top-bar :refer [top-bar]]))

(defn component []
  [:div
   [top-bar]
   [:h1.title "Consult"]])
