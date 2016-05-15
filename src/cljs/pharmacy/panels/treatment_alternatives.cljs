(ns pharmacy.panels.treatment-alternatives
  (:require [pharmacy.components.top-bar :refer [top-bar]])

(defn component []
  (fn []
    [:div
     [top-bar]
     [:div "Alternatives to Atorvastatin"]]
    ))
