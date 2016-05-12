(ns disrupt-pharmacy.handlers
  (:require [re-frame.core :as re-frame :refer [register-handler]]))

(def initial-state
  {:active-panel :home-panel
   :name "David"})

;; -------------------------
;; Handlers
;; -------------------------

(register-handler                 ;; setup initial state
  :initialize                     ;; usage:  (dispatch [:initialize])
  (fn
    [db _]
    (merge db initial-state)))

(register-handler
 :set-active-panel 
 (fn [db [_ item-id]]
   (assoc db :active-panel item-id)))
