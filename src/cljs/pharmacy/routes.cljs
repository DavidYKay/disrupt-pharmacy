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

  (defroute menu "/menu" []
    (re-frame/dispatch [:set-active-panel :menu-panel]))

  (defroute drug-detail "/drug/:id" [id query-params]
    (re-frame/dispatch [:set-active-panel :drug-detail-panel]))

  (defroute login "/login" []
    (re-frame/dispatch [:set-active-panel :login-panel]))
  
  (defroute dashboard "/dashboard" []
    (re-frame/dispatch [:set-active-panel :dashboard-panel]))

  (defroute about "/about" []
    (re-frame/dispatch [:set-active-panel :about-panel]))


  ;; --------------------
  (hook-browser-navigation!))