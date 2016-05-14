(ns pharmacy.views
    (:require [re-frame.core :as re-frame]
              [pharmacy.panels.home :as home]
              [pharmacy.panels.about :as about]))


(defmulti panels identity)
(defmethod panels :home-panel [] [home/component])
(defmethod panels :about-panel [] [about/component])
(defmethod panels :default [] [:div])

(defn show-panel
  [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [:active-panel])]
    (fn []
      [show-panel @active-panel])))
