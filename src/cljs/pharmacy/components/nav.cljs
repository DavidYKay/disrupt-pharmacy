(ns pharmacy.components.nav
  (:require
   ;;[pharmacy.routes :refer [home about]]
   [clojure.walk :refer [postwalk]]
   [re-frame.core :as re-frame :refer [subscribe]]))

(def items
  [
   ["Home" "#"]
   ["About" "#/about"]
   ;;["Home" (home)]
   ;;["About" (about)]
   ;;["Terms" about]
   ;;["Service" about]
   ;;["Consultation" about]
   ])

(defn component []
  (fn []
    [:div "Navigation"
     [:ul
      (for [[n p] items]
        [:li [:a {:href p} n]])]]))
