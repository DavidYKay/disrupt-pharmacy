(ns pharmacy.panels.menu-drawer)

(def items
  [["Home" "#/"]
   ["Drug Detail" "#/drug/1234"]
   ["Dashboard" "#/dashboard"]
   ["Consultation" "#/consultation"]
   ["Past Orders" "#/orders"]
   ["Join" "#/join"]])

(defn component []
  (fn []
    [:div.columns
     [:div.column.container
      [:section.section
       [:div.container
        [:h1.title "Menu Drawer"]]]
      [:section.section
       [:div.container
        (for [[n p] items]
          [:h2.subtitle [:a {:href p} n]])]]]]))
