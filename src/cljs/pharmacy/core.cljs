(ns pharmacy.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [pharmacy.handlers]
              [pharmacy.subs]
              [pharmacy.routes :as routes]
              [pharmacy.views :as views]
              [pharmacy.config :as config]))

(when config/debug?
  (println "dev mode"))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init [] 
  (routes/app-routes)
  (re-frame/dispatch-sync [:initialize-db])
  (mount-root))
