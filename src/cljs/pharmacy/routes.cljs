(ns pharmacy.routes
    (:require-macros [secretary.core :refer [defroute]])
    (:import goog.History)
    (:require [secretary.core :as secretary]
              [goog.events :as events]
              [goog.history.EventType :as EventType]
              [re-frame.core :as re-frame]))

(defn hook-browser-navigation! []
  (doto (History.)
    (events/listen
     EventType/NAVIGATE
     (fn [event]
       (secretary/dispatch! (.-token event))))
    (.setEnabled true)))

(defn app-routes []
  (secretary/set-config! :prefix "#")
  ;; --------------------
  ;; define routes here
  (defroute home "/" []
    (re-frame/dispatch [:set-active-panel :home-panel]))

  ;; --------------------
  ;; Google
  ;; --------------------
  (defroute google "/google" []
    (re-frame/dispatch [:set-active-panel :google-panel]))

  (defroute google-results "/google-results" []
    (re-frame/dispatch [:set-active-panel :google-results-panel]))

  ;; --------------------
  ;; Core Routes
  ;; --------------------

  (defroute consult "/consultation" []
    (re-frame/dispatch [:set-active-panel :consult-panel]))
  
  (defroute dashboard "/dashboard" []
    (re-frame/dispatch [:set-active-panel :dashboard-panel]))

  (defroute drug-detail "/drug/:id" [id query-params]
    (re-frame/dispatch [:view-drug (keyword id)]))

  (defroute menu "/menu" []
    (re-frame/dispatch [:set-active-panel :menu-panel]))

  (defroute join "/join" []
    (re-frame/dispatch [:set-active-panel :join-panel]))

  (defroute treatment-alternatives "/treatment-alternatives" []
    (re-frame/dispatch [:set-active-panel :treatment-alternatives-panel]))
  
  ;; --------------------
  ;; Emails
  ;; --------------------

  (defroute adaptation-email "/adaptation-email" []
    (re-frame/dispatch [:set-active-panel :adaptation-email-panel]))
  
  ;; --------------------
  (hook-browser-navigation!))
