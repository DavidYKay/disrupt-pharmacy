(ns disrupt-pharmacy.panels.home
  (:require [disrupt-pharmacy.routes :refer [url-for]]))

(defn component []
  (let [name (subscribe [:name])]
    (fn []
      [:div (str "Hello from " @name ". This is the Home Page. Woot")
       [:div [:a {:href (url-for :about)} "go to About Page"]]])))
