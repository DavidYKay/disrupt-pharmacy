(ns pharmacy.components.alternative-therapy-rating)

(defn alternative-therapy-rating [grade]
  [:div.score-box.has-text-centered
   [:div.scorebox-recommend
    [:div.grade grade
     [:span.out-of-10 "/10"]]]])
