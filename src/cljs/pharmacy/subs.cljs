(ns pharmacy.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

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
 :active-panel
 (fn [db _]
   (reaction (:active-panel @db))))

(re-frame/register-sub
 :questions
 (fn [db [_ q]]
   (reaction (get-in @db [:questions q]))))

(re-frame/register-sub
 :answered-risk-questions
 (fn [db]
   (reaction
    (every? #(not (nil? %)) (vals (:risk-questions @db))))))
