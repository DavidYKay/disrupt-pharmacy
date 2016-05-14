(ns pharmacy.panels.home
  (:require 
            [pharmacy.components.nav :as nav]
            [re-frame.core :as re-frame :refer [subscribe]]))

(defn component []
  (let [name (subscribe [:name])]
    (fn []
      [:div (str "Hello from " @name ". This is the Home Page. Woot")
       ;[:div [:a {:href "#/about"} "About"]]
       [nav/component]
       ])))
