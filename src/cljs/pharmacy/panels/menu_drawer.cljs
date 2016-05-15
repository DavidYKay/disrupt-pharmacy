(ns pharmacy.panels.menu-drawer)

(def items
  [["Home" "#/"]
   ["Drug Detail" "#/drug/1234"]
   ["Dashboard" "#/dashboard"]
   ["Consultation" "#/consultation"]
   ["Past Orders" "#/orders"]
   ["Login" "#/login"]])

(defn component []
  (fn []
    [:div
     [:h1 "Menu Drawer"]
     [:ul
      (for [[n p] items]
        [:li [:a {:href p} n]])]]))
