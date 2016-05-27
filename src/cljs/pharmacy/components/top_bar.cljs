(ns pharmacy.components.top-bar
  (:require
   [re-frame.core :as re-frame :refer [dispatch subscribe]]
   [pharmacy.components.join-button :refer [join-button]]
   [pharmacy.components.menu-button :refer [menu-button]]))

(defn top-bar []
  (let [phn (subscribe [:phn])]
    (fn []
      [:div.top-bar.box.columns.is-mobile
       [:div.column
        [menu-button]]
       [:div.column
        [:h1.title.has-text-centered "DisPharm"]]
       [:div.column
        [join-button (not (nil? @phn))]]])))
