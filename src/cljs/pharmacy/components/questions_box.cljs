(ns pharmacy.components.questions-box
  (:require
   [re-frame.core :as re-frame :refer [dispatch subscribe]]
   [pharmacy.components.page-indicator :refer [page-indicator]]
   [pharmacy.components.question :refer [response-form]]
   [pharmacy.helpers :refer [on-enter]]
   [reagent.core :as reagent])
  (:require-macros [reagent.ratom :refer [reaction]]))

(defn questions-box [questions]
  (let [pos (reagent/atom 0)
        on-response (fn [{:keys [id response]}]
                       (dispatch [:question :universal id response])
                      (swap! pos inc))
        answered-all? (subscribe [:answered-all-questions])]
    (fn []
      [:div.questions-box {:class (if @answered-all? "questions-complete" "")}
       [:div.container
        [:h1.title.is-4 "Customize Your Score"]
        
        (doall
         (map-indexed (fn [idx {:keys [id question type choices] :as current-q}]
                        ^{:key idx}
                        [:div.question
                         {:class
                          (if (= idx @pos)
                            (do (str "q" idx " active-question"))
                            (str "q" idx))}
                         [response-form current-q (fn [response]
                                                    (on-response {:id id
                                                                  :response response}))]])
                      questions))

        [page-indicator @pos questions]]])))
