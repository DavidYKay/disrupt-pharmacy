(ns pharmacy.components.drug-rating
  (:require [re-frame.core :as re-frame :refer [dispatch]]))

(defn drug-rating []
  [:div.score-box.is-inline-flex.columns.is-gapless.has-text-centered
   [:div.column.is-two-third
    [:div.scorebox-overall
     [:div.grade "B"]
     [:div.grade-label "Overall Score"]
     ]]
   [:div.column.is-one-third
    [:div.scorebox-efficacy
     [:div.grade "A"]
     [:div.grade-label "Effectiveness"]
     ]
    [:div.scorebox-sidefx
     [:div.grade "C"]
     [:div.grade-label "Side Effects"]
     ]]])
