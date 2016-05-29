(ns pharmacy.components.x-button
  (:require [re-frame.core :as re-frame :refer [dispatch]])
  )

(defn x-button []
  [:span.icon.is-large.is-pulled-right
   [:i.fa.fa-times.hoverable {:aria-hidden true
                                              :on-click #(dispatch [:set-active-panel :menu-panel])}]])
