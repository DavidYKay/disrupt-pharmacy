(ns pharmacy.components.drug-rating
  (:require [re-frame.core :as re-frame :refer [dispatch]]))

(defn drug-rating [grade risk]
  [:div.score-box.has-text-centered
    [:div.scorebox-recommend
     [:div.grade grade
     [:span.out-of-10 "/10"]]
     [:div.grade-label "Recommend"]
     ]
    [:div.scorebox-risk
     [:div.grade (or risk "?")]
     [:div.grade-label "Risk"]
     ]])
