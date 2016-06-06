(ns pharmacy.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]
              [pharmacy.data.drugs :refer [drugs]]))

(re-frame/register-sub
 :name
 (fn [db]
   (reaction (:name @db))))

(re-frame/register-sub
 :phn
 (fn [db]
   (reaction (:phn @db))))

(re-frame/register-sub
 :logged-in
 (fn [db]
   (reaction (not (nil? (:phn @db))))))

(re-frame/register-sub
 :current-drug
 (fn [db]
   (reaction (get drugs (:drug-id @db)))))

(re-frame/register-sub
 :menu-open
 (fn [db]
   (reaction (:menu-open @db))))

(re-frame/register-sub
 :modal-shown
 (fn [db]
   (reaction (:modal-shown @db))))

(re-frame/register-sub
 :active-panel
 (fn [db _]
   (reaction (:active-panel @db))))

(re-frame/register-sub
 :questions
 (fn [db [_ kind q]]
   (reaction (get-in @db [:questions kind q]))))

;; Risk
;; ~5% (based on assumption of high cholesterol)
;; ~10% (checked YES to smoking)
;; ~17% (checked yes to diabetes)
;; HIGH (or whatever is the worst rating on scale) (checked yes to: have you had a heart attack or stroke)

(re-frame/register-sub
 :risk
 (fn [db [_]]
   (reaction
    (cond
      (get-in @db [:questions :universal :cardiac-event]) "D"
      (get-in @db [:questions :universal :diabetes]) "C"
      (get-in @db [:questions :universal :smoker]) "B"
      :else "A"))))

;; Score
;; 10%  (based on assumption of high cholesterol)
;; 20%  (checked YES to smoking)
;; 40%  (checked yes to diabetes)
;; 80%  (or whatever is the worst rating on scale) (checked yes to: have you had a heart attack or stroke)

(re-frame/register-sub
 :drug-score
 (fn [db [_]]
   (reaction
    (cond
      (get-in @db [:questions :universal :cardiac-event]) "8"
      (get-in @db [:questions :universal :diabetes]) "4"
      (get-in @db [:questions :universal :smoker]) "2"
      :else "1"))))
