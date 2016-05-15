(ns pharmacy.components.top-bar
  (:require
   [re-frame.core :as re-frame :refer [dispatch]]
   [pharmacy.components.join-button :refer [join-button]]
   [pharmacy.components.menu-button :refer [menu-button]]))

(defn top-bar []
  [:div.top-bar.box.columns
   [:div.column
    [menu-button]]
   [:div.column
    [join-button]]])
