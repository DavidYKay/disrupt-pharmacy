(ns pharmacy.components.questions-box
  (:require
   [re-frame.core :as re-frame :refer [dispatch subscribe]]
   [pharmacy.components.question :refer [response-form]]
   [pharmacy.helpers :refer [on-enter]]
   [reagent.core :as reagent])
  (:require-macros [reagent.ratom :refer [reaction]]))

(def questions
  [{:question "What is your age?"
    :type :integer
    :id :age}
   {:question "What is your race?"
    :id :race
    :type :multiple-choice
    :choices ["Black"
              "White"
              "Other"]}
   {:question "Are you taking BP Meds?"
    :id :bp-meds
    :type :boolean}
   {:question "Are you a smoker?"
    :id :smoker
    :type :boolean}
   {:question "Do you have diabetes or are pre-diabetic?"
    :id :diabetes
    :type :boolean}
   {:question "Have you ever had a heart attack or stroke?"
    :id :cardiac-event
    :type :boolean}
   ])

(defn questions-box [x]
  (let [pos (reagent/atom 0)
        on-response (fn [{:keys [id response]}]
                       (dispatch [:question :universal id response])
                      (swap! pos inc))
        ;; empty? (reaction (= (inc pos) (count questions)))]
        empty? (reagent/atom false)]
    (fn []
      [:section.section
       ;; {:class (str "section questions-box" (if @empty?
       {:class (str "section" (if @empty?
                                "questions-complete"
                                ""))}
       [:div.container
        [:h1.title "Questions box"]
        (doall
         (map-indexed (fn [idx {:keys [id question type choices] :as current-q}]
                        ^{:key idx}
                        [:div.question
                         {:class
                          (if (= idx @pos)
                            "active-question"
                            "")}
                         [response-form current-q (fn [response]
                                                    (on-response {:id id
                                                                  :response response}))]])
                      questions))]])))
