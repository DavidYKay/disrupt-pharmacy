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
  (:import goog.History))

(defn page []
  [(session/get :current-page)])

;; -------------------------
;; Routes
(secretary/set-config! :prefix "#")

(secretary/defroute "/" []
  (session/put! :current-page main-ui/component))

(secretary/defroute "/drug/:id" []
  (session/put! :current-page drug-detail/component))

(secretary/defroute "/book-consultation" []
  (session/put! :current-page book-consultation/component))

(enable-console-print!)

(defonce app-state (atom {:text "Hello Chestnut!"}))

;(r/render [main-ui/component] (js/document.getElementById "app"))
(r/render [page] (js/document.getElementById "app"))
