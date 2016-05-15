(ns pharmacy.components.arrow-button
  (:require [re-frame.core :as re-frame :refer [dispatch]])
  )

(defn arrow-button [{:keys [on-click]}]
  [:i.fa.fa-arrow-left.is-pulled-right.hoverable {:aria-hidden true
                                                   :on-click on-click}])
