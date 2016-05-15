(ns pharmacy.components.x-button
  (:require [re-frame.core :as re-frame :refer [dispatch]])
  )

(defn x-button []
  [:span.icon.is-large
   [:i.fa.fa-times.is-pulled-right.hoverable {:aria-hidden true
                                              :on-click #(dispatch [:set-active-panel :menu-panel])}]])
