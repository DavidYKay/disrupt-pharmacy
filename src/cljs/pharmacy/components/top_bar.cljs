(ns pharmacy.components.top-bar
  (:require
   [re-frame.core :as re-frame :refer [dispatch subscribe]]
   [pharmacy.components.join-button :refer [join-button]]
   [pharmacy.components.menu-button :refer [menu-button]]))

(defn top-bar []
  (let [logged-in (subscribe [:logged-in])]
    (fn []
      [:div.top-bar.box.columns.is-mobile
       [:div.column
        [menu-button]]
       [:div.column.top-logo
        [:a {:href "#"}
        [:h1.title.has-text-centered "DrugIQ"]]]
       [:div.column
        [join-button @logged-in]]])))
