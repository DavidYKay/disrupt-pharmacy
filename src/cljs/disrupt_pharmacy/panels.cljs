(ns disrupt-pharmacy.panels
  (:require [re-frame.core :as re-frame :refer [subscribe]]
            [disrupt-pharmacy.routes :refer [url-for]]))

;; -------------------------
;; Mapping to Panels
;; -------------------------

(defn home-panel []
  (let [name (subscribe [:name])]
    (fn []
      [:div (str "Hello from " @name ". This is the Home Page. Woot")
       [:div [:a {:href (url-for :about)} "go to About Page"]]])))

(defn about-panel []
  (fn []
    [:div "This is the About Page."
     [:div [:a {:href (url-for :home)} "go to Home Page"]]]))

(defmulti panels identity)
(defmethod panels :home-panel [] [home-panel])
(defmethod panels :about-panel [] [about-panel])
(defmethod panels :default [] [:div])
