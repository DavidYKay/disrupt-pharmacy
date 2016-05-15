(ns pharmacy.views
    (:require [re-frame.core :as re-frame]
              [pharmacy.panels.menu-drawer :as menu]
              [pharmacy.panels.drug-detail :as drug-detail]
              [pharmacy.panels.login :as login]
              [pharmacy.panels.dashboard :as dashboard]
              [pharmacy.panels.home :as home]
              [pharmacy.panels.about :as about]))


(defmulti panels identity)
(defmethod panels :home-panel [] [home/component])
(defmethod panels :menu-panel [] [menu/component])
(defmethod panels :drug-detail-panel [] [drug-detail/component])
(defmethod panels :login-panel [] [login/component])
(defmethod panels :dashboard-panel [] [dashboard/component])
(defmethod panels :about-panel [] [about/component])
(defmethod panels :default [] [:div])

(defn show-panel
  [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [:active-panel])]
    (fn []
      [show-panel @active-panel])))