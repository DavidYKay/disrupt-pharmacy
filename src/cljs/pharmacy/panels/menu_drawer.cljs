(ns pharmacy.panels.menu-drawer)

(def items
  [["Home" "#"]
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
