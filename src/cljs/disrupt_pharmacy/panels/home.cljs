(ns disrupt-pharmacy.panels.home
  (:require [disrupt-pharmacy.routes :refer [url-for]]
            [disrupt-pharmacy.components.nav :as nav]
            [re-frame.core :as re-frame :refer [subscribe]]))

(defn component []
  (let [name (subscribe [:name])]
    (fn []
      [:div (str "Hello from " @name ". This is the Home Page. Woot")
       [nav/component]
       ])))
