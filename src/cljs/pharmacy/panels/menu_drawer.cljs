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
  [["Checkout (2)" "#/checkout" "fa-shopping-cart"]
   ["Alerts" "#/alerts" "fa-bell-o"]
   ["Consult Pharmacist" "#/pharmacist" "fa-user-plus"]
   ["Fill A Prescription / Refills" "#/prescriptions" "fa-sticky-note"]
   ["My Active Medications" "#/prescriptions/active" "fa-medkit"]
   ["Fill & Order History" "#/prescriptions/history" "fa-history"]
   ["My Health Profile" "#/health-profile" "fa-clipboard"]
   ["Account Information" "#/account" "fa-info"]])

(def recent-drugs
  [["Lovastatin" "#/drug/lovastatin"]
   ["Atorvastatin" "#/drug/atorvastatin"]
   ["Rosuvastatin" "#/drug/rosuvastatin"]])

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
       [:div.container.dashboard
        (for [[n p i] items]
          ^{:key n}
          [:a {:href p
                          :on-click #(dispatch [:set-menu-open false])} [:i.fa {:class i}] n])]]

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
