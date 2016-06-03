(ns pharmacy.components.questions-box
  (:require
   [re-frame.core :as re-frame :refer [dispatch subscribe]]
   [reagent.core :as reagent])
  (:require-macros [reagent.ratom :refer [reaction]]))

(def questions
  [{:question "What is your favorite color?"
    :type :multiple-choice
    :choices ["Red"
              "Blue"
              "Green"
              "Black"]}
   {:question "Are you a smoker?"
    :type :boolean}
   {:question "Are you taking BP Meds?"
    :type :boolean}
   {:question "Do you have a history of early cardiovascular disease in your family?"
    :type :boolean}
   ])

(defn questions-box [x]
  (let [pos (reagent/atom 0)
        on-yes #(swap! pos inc)
        on-no on-yes
        ;;empty? (reaction (= (inc pos) (count questions)))]
        empty? (reagent/atom false)]
    (fn []
      [:section.section
       {:class (if @empty?
                 "section questions-box questions-complete"
                 "section questions-box")}
       [:div.container
        [:h1.title "Questions box"]
        (doall
         (map-indexed (fn [idx {:keys [question type choices]}]
                        ^{:key idx}
                        [:div.question
                         {:class (if (= idx @pos)
                                   "active-question"
                                   "")}
                         [:div question]
                         [:div.control.has-addons
                          [:a.button {:on-click on-yes} "Yes"]
                          [:a.button {:on-click on-no} "No"]]]) questions))]])))
