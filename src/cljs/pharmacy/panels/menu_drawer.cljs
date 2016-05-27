(ns pharmacy.panels.menu-drawer
  (:require
   [pharmacy.components.arrow-button :refer [arrow-button]]
   [pharmacy.components.drug-rating :refer [drug-rating]]
   [pharmacy.components.searchbox :refer [searchbox]]
   [re-frame.core :as re-frame :refer [dispatch]]
   ))

(def debug-items
  [["Home" "#/"]
   ["Drug Detail" "#/drug/1234"]
   ["Dashboard" "#/dashboard"]
   ["Consultation" "#/consultation"]
   ["Past Orders" "#/orders"]
   ["Join" "#/join"]])

(def items
  [["My Dashboard" "#/dashboard"]
   ["My Prescription" "#/prescription"]
   ["Checkout (2)" "#/checkout"]])

(def recent-drugs
  [["Atorvastatin" "#/drug/1234"]
   ["Drug B" "#/drug/5678"]
   ["Drug C" "#/drug/9012"]])

(defn component []
  (fn []
    [:div.columns.dim-layer
     [:div.column.container.nav-drawer-main

      [arrow-button {:on-click #(dispatch [:set-active-panel :home-panel])}]

      [:section.section
       [:div.container
        [searchbox {:placeholder "Find Medication"
                    :on-search #(print "searching for" %)}]]]

      [:section.section
       [:div.container
        (for [[n p] items]
          [:h1.title [:a {:href p} n]])]]

      [:section.section
       [:div.container
        [:h2.subtitle "Recently Browsed"]
        (for [[n p] recent-drugs]
           [:a {:href p}
            [drug-rating]
            [:h2.subtitle n]
            ])]]

      [:section.section
       [:div.container
        [:h2.subtitle "Debug"]
        (for [[n p] debug-items]
          [:h2.subtitle [:a {:href p} n]])]]]]))
