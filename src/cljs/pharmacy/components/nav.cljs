(ns pharmacy.components.nav
  (:require
   ;;[pharmacy.routes :refer [home about]]
   [clojure.walk :refer [postwalk]]
   [re-frame.core :as re-frame :refer [subscribe]]))

(def items
  [
   ;;["Home" "#"]
   ;;["About" "#/about"]
   ["Menu" "#/menu"]
   ])

(defn component []
  (fn []
    [:div "Navigation"
     [:ul
      (for [[n p] items]
        [:li [:a {:href p} n]])]]))
