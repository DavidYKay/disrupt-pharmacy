(ns pharmacy.components.arrow-button
  (:require [re-frame.core :as re-frame :refer [dispatch]])
  )

(defn arrow-button [{:keys [on-click]}]
  [:div.nav-drawer-topbar.sticky
  [:span.icon.is-large.is-pulled-right
  [:i.fa.fa-arrow-left.hoverable {:aria-hidden true
                                                   :on-click on-click}]]])
