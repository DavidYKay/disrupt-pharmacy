(ns disrupt-pharmacy.core
  (:require [reagent.core :as r :refer [atom]]
            [reagent.session :as session]
            
            [secretary.core :as secretary :include-macros true]
            [goog.events :as events]
            [goog.history.EventType :as HistoryEventType]
            [disrupt-pharmacy.components.book-consultation :as book-consultation]
            [disrupt-pharmacy.components.drug-detail :as drug-detail]
            [disrupt-pharmacy.components.main-ui :as main-ui]
            )
  (:require-macros [secretary.core :refer [defroute]])
  (:import goog.History))

(defonce app-state (atom {:text "Hello Chestnut!"}))

;; -------------------------
;; Routing
;; -------------------------

(defn hook-browser-navigation! []
  (doto (History.)
    (events/listen
     HistoryEventType/NAVIGATE
     (fn [event]
       (secretary/dispatch! (.-token event))))
    (.setEnabled true)))

(defn app-routes []
  (secretary/set-config! :prefix "#")

  (defroute "/" []
    (swap! app-state assoc :page :home))

  (defroute "/about" []
    (swap! app-state assoc :page :about))

  (defroute "/drug/:id" []
    (swap! app-state assoc :page :drug-detail))

  (defroute "/book-consultation" []
    (swap! app-state assoc :page :book-consultation))

  (hook-browser-navigation!))

(defn home []
  [:div [:h1 "Home Page"]
   [:a {:href "#/about"} "about page"]])

(defn about []
  [:div [:h1 "About Page"]
   [:a {:href "#/"} "home page"]])

(defmulti current-page #(@app-state :page))
(defmethod current-page :home [] 
  ;;[main-ui/component])
  [home])
(defmethod current-page :about [] 
  [about])

(defmethod current-page :drug-detail [] 
  [drug-detail/component])
(defmethod current-page :book-consultation [] 
  [book-consultation/component])

(defn ^:export main []
  (enable-console-print!)
  (app-routes)
  (r/render [current-page] (js/document.getElementById "app")))

;(r/render [(session/get :current-page)] (js/document.getElementById "app")))
;(r/render [main-ui/component] (js/document.getElementById "app"))
;(r/render [page] (js/document.getElementById "app"))
;(r/render page (js/document.getElementById "app"))
