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

(re-frame/register-sub
 :answered-risk-questions
 (fn [db]
   (reaction
    (let [risk-questions (get-in @db [:questions :risk])]
      (println "risk questions:" risk-questions)
      (and (not (empty? risk-questions))
           (every? #(not (nil? %)) (vals risk-questions)))))))

