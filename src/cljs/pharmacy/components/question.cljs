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
   [:div.control.has-addons
    [:a.button {:on-click #(callback true)} "Yes"]
    [:a.button {:on-click #(callback false)} "No"]]])

(defmethod response-form :integer [question callback]
  (let [val (reagent/atom nil)]
    (fn []
      [:div 
       [:div (:question question)]
       [:p.control 
        [:input.input.is-large {:type "text"
                                :placeholder "Age"
                                :on-key-down (on-enter #(callback @val))
                                :value @val
                                :on-change (fn [ev]
                                             (reset! val (-> ev .-target .-value)))}]]])))

(defmethod response-form :multiple-choice [question callback]
  (let [val (reagent/atom nil)]
    (fn []
      [:div 
       [:div (:question question)]
       [:p {:class "control"}
        [:span {:class "select"}
         [:select  {:on-change #(reset! val (.. % -target -value))}
          (for [choice (:choices question)]
            ^{:key choice}
            [:option choice])]]] 
       [:a.button {:on-click #(callback @val)} "OK"]])))
