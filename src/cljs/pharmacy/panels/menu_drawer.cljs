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
   ["Join" "#/join"]])

(def items
  [["My Dashboard" "#/dashboard"]
   ["My Prescription" "#/prescription"]
   ["Checkout (2)" "#/checkout"]])

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
        [searchbox {:placeholder "Find Medication"
                    :on-search #(print "searching for" %)}]]]

      [:section.section
       [:div.container
        (for [[n p] items]
          ^{:key n}
          [:h1.title [:a {:href p
                          :on-click #(dispatch [:set-menu-open false])} n]])]]

      [:section.section
       [:div.container
        [:h2.subtitle "Recently Browsed"]
        (for [[n p] recent-drugs]
          ^{:key n}
           [:a {:href p
             :on-click #(dispatch [:set-menu-open false])}
            [drug-rating 80]
            [:h2.subtitle n]])]]

      [:section.section
       [:div.container
        [:h2.subtitle "Debug"]
        (for [[n p] debug-items]
          ^{:key n}
          [:h2.subtitle [:a {:href p
            :on-click #(dispatch [:set-menu-open false])} n]])]]]]))
