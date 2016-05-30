(ns pharmacy.panels.menu-drawer
  (:require
   [pharmacy.components.arrow-button :refer [arrow-button]]
   [pharmacy.components.drug-rating :refer [drug-rating]]
   [pharmacy.components.searchbox :refer [searchbox]]
   [re-frame.core :as re-frame :refer [dispatch]]
   ))

(def debug-items
  [["Home" "#/"]
   ["Google" "#/google"]
   ["Consultation" "#/consultation"]
   ["Past Orders" "#/orders"]
   ["My Dashboard" "#/dashboard"]
   ["Join" "#/join"]])

(def items
  [["Checkout (2)" "#/checkout"]
   ["Alerts" "#/alerts"]  
   ["Consult Pharmacist" "#/pharmacist"]
   ["Fill A Prescription / Refills" "#/prescriptions"]
   ["My Active Medications" "#/prescriptions/active"]
   ["Fill & Order History" "#/prescriptions/history"]
   ["My Health Profile" "#/health-profile"]
   ["Account Information" "#/account"]   ])

(def recent-drugs
  [["Atorvastatin" "#/drug/atorvastatin"]
   ["Rosuvastatin" "#/drug/rosuvastatin"]
   ["Lovastatin" "#/drug/lovastatin"]])

(defn component []
  (fn []
    [:div.columns
     [:div.dim-layer ]
     [:div.column.container.nav-drawer-main

      [arrow-button {:on-click #(dispatch [:set-menu-open false])}]

      [:section.section
       [:div.container
        [searchbox {:placeholder "Find a Medication"
                    :on-search #(print "searching for" %)}]]]

      [:section.section
       [:div.container
        (for [[n p] items]
          ^{:key n}
          [:h1 [:a {:href p
                          :on-click #(dispatch [:set-menu-open false])} n]])]]

      [:section.section
       [:div.container.recently-browsed
        [:h2.subtitle "Recently Browsed"]
        (for [[n p] recent-drugs]
          ^{:key n}
           [:a {:href p
             :on-click #(dispatch [:set-menu-open false])}
            [drug-rating 80]
            [:h2.subtitle.is-inline n]])]]

      [:section.section.debugmenu
       [:div.container
        [:h2.subtitle "Debug"]
        (for [[n p] debug-items]
          ^{:key n}
          [:h2.subtitle [:a {:href p
            :on-click #(dispatch [:set-menu-open false])} n]])]]]]))
