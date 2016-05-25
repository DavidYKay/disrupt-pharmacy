(ns pharmacy.handlers
    (:require [re-frame.core :as re-frame]
              [pharmacy.db :as db]))

(re-frame/register-handler
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/register-handler
 :set-active-panel
 (fn [db [_ active-panel]]
   (assoc db :active-panel active-panel)))

(re-frame/register-handler
 :set-phn
 (fn [db [_ phn]]
   (assoc db :phn phn
          :active-panel :drug-detail-panel)))

