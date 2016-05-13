(ns disrupt-pharmacy.panels.about
  (:require [disrupt-pharmacy.routes :refer [url-for]]
            [disrupt-pharmacy.components.nav :as nav]
            [re-frame.core :as re-frame :refer [subscribe]]))

(defn component []
  (fn []
    [:div "This is the About Page."
     [nav/component]]))
