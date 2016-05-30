(ns pharmacy.panels.dashboard
  (:require
   [pharmacy.components.searchbox :refer [searchbox]]
   [pharmacy.components.top-bar :refer [top-bar]]))

(defn component []
  (fn []
    [:div
     [top-bar]

     [:h1.title "My Dashboard"]

     [searchbox {:placeholder "Find a Medication"
                 :on-search #(print "searching for" %)}]

     [:a {:href "#/alerts"} [:h2.subtitle "Alerts"]]
     [:a {:href "#/pharmacist"} [:h2.subtitle "Consult Pharmacist"]]
     [:a {:href "#/prescriptions"} [:h2.subtitle "Fill A Prescription / Refills"]]
     [:a {:href "#/prescriptions/active"} [:h2.subtitle "My Active Medications"]]
     [:a {:href "#/prescriptions/history"} [:h2.subtitle "Fill & Order History"]]
     [:a {:href "#/health-profile"} [:h2.subtitle "My Health Profile"]]
     [:a {:href "#/account"} [:h2.subtitle "Account Information"]]



     ]))
