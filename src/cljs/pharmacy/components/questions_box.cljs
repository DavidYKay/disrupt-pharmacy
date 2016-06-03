(ns pharmacy.components.questions-box
  (:require
   [re-frame.core :as re-frame :refer [dispatch subscribe]]
   [reagent.core :as reagent])
  (:require-macros [reagent.ratom :refer [reaction]]))

(def questions
  [{:question "What is your age?"
    :type :integer}
   {:question "What is your race?"
    :type :multiple-choice
    :choices ["Black"
              "White"
              "Other"]}
   {:question "Are you taking BP Meds?"
    :type :boolean}
   {:question "Are you a smoker?"
    :type :boolean}
   {:question "Have you ever had a heart attack or stroke?"
    :type :boolean}
   {:question "Do you have diabetes or are pre-diabetic?"
    :type :boolean}])

(defn questions-box [x]
  (let [pos (reagent/atom 0)
        on-yes #(swap! pos inc)
        on-no on-yes
        ;;empty? (reaction (= (inc pos) (count questions)))]
        empty? (reagent/atom false)]
    (fn []
      [:section.section
       ;{:class (str "section questions-box" (if @empty?
       {:class (str "section" (if @empty?
                                "questions-complete"
                                ""))}
       [:div.container
        [:h1.title "Questions box"]
        (doall
         (map-indexed (fn [idx {:keys [question type choices]}]
                        ^{:key idx}
                        [:div.question
                         {:class
                          (if (= idx @pos)
                            "active-question"
                            "")}
                         [:div question]
                         [:div.control.has-addons
                          [:a.button {:on-click on-yes} "Yes"]
                          [:a.button {:on-click on-no} "No"]]]) questions))]])))
