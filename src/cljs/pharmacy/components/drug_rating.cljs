(ns pharmacy.components.drug-rating
  (:require [re-frame.core :as re-frame :refer [dispatch]]))

(defn drug-rating [grade]
  [:div.score-box.is-inline-flex.columns.is-gapless.has-text-centered
   [:div.column.is-two-third
    [:div.scorebox-overall
     [:div.grade grade]
     [:div.grade-label "Overall Score"]
     ]]
   [:div.column.is-one-third
    [:div.scorebox-efficacy
     [:div.grade "-"]
     [:div.grade-label "Effectiveness"]
     ]
    [:div.scorebox-sidefx
     [:div.grade "-"]
     [:div.grade-label "Side Effects"]
     ]]])
