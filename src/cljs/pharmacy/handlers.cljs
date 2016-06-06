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
 :set-menu-open
 (fn [db [_ open]]
   (assoc db :menu-open open)))

(re-frame/register-handler
 :view-drug
 (fn [db [_ drug-id]]
   (assoc db :drug-id drug-id
          :active-panel :drug-detail-panel)))

(re-frame/register-handler
 :set-phn
 (fn [db [_ phn]]
   (assoc db :phn phn
          :active-panel :drug-detail-panel)))

(re-frame/register-handler
 :question
 (fn [db [_ kind q a]]
   ;; (println "received  " kind " question: " q " with answer:" a)
   (let [state (assoc-in db [:questions kind q] a)]
     (println "state is now: " state)
     state)))

(re-frame/register-handler
 :consult-pharmacist
 (fn [db [_ show]]
   (assoc db :appointment-modal-shown show)))

(re-frame/register-handler
 :personalization-modal
 (fn [db [_ show]]
   (assoc db :personalization-modal-shown show :fresh-from-google show)))
