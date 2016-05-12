(ns disrupt-pharmacy.subscriptions
  (:require [re-frame.core :as re-frame :refer [register-sub]])
  (:require-macros [reagent.ratom :refer [reaction]]))

;; -------------------------
;; Subscriptions
;; -------------------------

(register-sub :active-panel 
              (fn [db _]
                (reaction (:active-panel @db))))

(register-sub :name
              (fn [db _]
                (reaction (:name @db))))
