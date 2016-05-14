(ns pharmacy.components.nav
  (:require
   [pharmacy.routes :refer [home about]]
   [clojure.walk :refer [postwalk]]
   [re-frame.core :as re-frame :refer [subscribe]]))

(def items
  [["Home" home]
   ["About" about]])

(defn component []
  (fn []
    [:div "Navigation"
     [:ul
      (for [[n f] items]
        [:li [:a {:href (f)} n]])]]))
