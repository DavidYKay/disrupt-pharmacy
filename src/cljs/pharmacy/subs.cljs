(ns pharmacy.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]
              [pharmacy.data.drugs :refer [drugs]]
              [pharmacy.data.questions :refer [score-risk-questions]]))

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
 :appointment-modal-shown
 (fn [db]
   (reaction (:appointment-modal-shown @db))))

(re-frame/register-sub
 :personalization-modal-shown
 (fn [db]
   (reaction (:personalization-modal-shown @db))))

(re-frame/register-sub
 :drug-scores-modal-shown
 (fn [db]
   (reaction (:drug-scores-modal-shown @db))))

(re-frame/register-sub
 :active-panel
 (fn [db _]
   (reaction (:active-panel @db))))

(re-frame/register-sub
 :questions
 (fn [db [_ kind q]]
   (reaction (get-in @db [:questions kind q]))))

(re-frame/register-sub
 :answered-all-questions
 (fn [db _]
   (reaction
    (let [greater? (fn [x]
                     (>= x (count score-risk-questions)))]
      (->> (get-in @db [:questions :universal])
           (vals)
           (count)
           (greater?))))))

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
      (get-in @db [:questions :universal :cardiac-event]) "80"
      (get-in @db [:questions :universal :diabetes]) "40"
      (get-in @db [:questions :universal :smoker]) "20"
      :else "10"))))

(re-frame/register-sub
 :fresh-from-google
 (fn [db [_]]
   (reaction (:fresh-from-google @db))))
