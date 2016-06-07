(ns pharmacy.components.question
  (:require
   [re-frame.core :as re-frame :refer [dispatch subscribe]]
   [pharmacy.helpers :refer [on-enter]]
   [reagent.core :as reagent])
  (:require-macros [reagent.ratom :refer [reaction]]))

;; Define the multimethod
(defmulti response-form :type)

(defmethod response-form :boolean [question callback]
  [:div
   [:div (:question question)]
   [:div.control
    [:a.button {:on-click #(callback true)} "Yes"]
    [:a.button {:on-click #(callback false)} "No"]]])

(defmethod response-form :integer [question callback]
  (let [val (reagent/atom nil)]
    (fn []
      [:div
       [:div (:question question)]
       [:p.control
        [:input.input.is-large {:type "number"
                                :pattern "[0-9]*" 
                                :inputmode "numeric"
                                :placeholder "Age"
                                :on-key-down #(case (.-which %)
                                                13 (do
                                                     (.blur (.-currentTarget %))
                                                     (callback @val))
                                                nil)
                                :value @val
                                :on-change (fn [ev]
                                             (reset! val (-> ev .-target .-value)))}]
        [:a.button {:on-click #(callback @val)} "Submit"]]])))

(defmethod response-form :multiple-choice [question callback]
  (fn []
    [:div
     [:div (:question question)]
     [:div.control
      (for [choice (:choices question)]
        ^{:key choice}
        [:a.button {:on-click #(callback choice)} choice])]]))
