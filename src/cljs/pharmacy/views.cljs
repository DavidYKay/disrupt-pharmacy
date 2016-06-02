(ns pharmacy.views
    (:require [re-frame.core :as re-frame]
              [pharmacy.panels.adaptation-email :as adaptation-email]
              [pharmacy.panels.follow-up-email :as follow-up-email]
              [pharmacy.panels.consult :as consult]
              [pharmacy.panels.dashboard :as dashboard]
              [pharmacy.panels.drug-detail :as drug-detail]
              [pharmacy.panels.google :as google]
              [pharmacy.panels.google-results :as google-results]
              [pharmacy.panels.home :as home]
              [pharmacy.panels.input-phn :as input-phn]
              [pharmacy.panels.join :as join]
              [pharmacy.panels.menu-drawer :as menu]
              [pharmacy.panels.treatment-alternatives :as treatment-alternatives]
              ))

(defmulti panels identity)
(defmethod panels :consult-panel [] [consult/component])
(defmethod panels :dashboard-panel [] [dashboard/component])
(defmethod panels :drug-detail-panel [] [drug-detail/component])
(defmethod panels :home-panel [] [home/component])
(defmethod panels :input-phn-panel [] [input-phn/component])
(defmethod panels :join-panel [] [join/component])
(defmethod panels :menu-panel [] [menu/component])
(defmethod panels :treatment-alternatives-panel [] [treatment-alternatives/component])
(defmethod panels :default [] [:div])

(defmethod panels :google-panel [] [google/component])
(defmethod panels :google-results-panel [] [google-results/component])

(defmethod panels :adaptation-email-panel [] [adaptation-email/component])
(defmethod panels :follow-up-email-panel [] [follow-up-email/component])


(defn show-panel
  [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [:active-panel])
        menu-open (re-frame/subscribe [:menu-open])]
    (fn []
      [:div.root-container
       [:div.core-ui
        [show-panel @active-panel]]
       [:div {:class (if @menu-open
                       "nav-drawer nav-opened"
                       "nav-drawer")}
        [menu/component]]])))
