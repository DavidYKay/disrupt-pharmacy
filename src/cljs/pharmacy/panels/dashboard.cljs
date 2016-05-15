(ns pharmacy.panels.dashboard
  (:require
   [pharmacy.components.searchbox :refer [searchbox]]
   [pharmacy.components.top-bar :refer [top-bar]]))

(defn component []
  (fn []
    [:div
     [top-bar]

     [:h1.title "My Dashboard"]
     
     [searchbox {:placeholder "Find Medication"
                 :on-search #(print "searching for" %)}]

     [:a {:href "#/pharmacist"} [:h2.subtitle "My Pharmacist"]]
     [:a {:href "#/prescriptions"} [:h2.subtitle "Available E-Prescriptions"]]
     [:a {:href "#/prescriptions/history"} [:h2.subtitle "Prescription History"]]
     [:a {:href "#/health-profile"} [:h2.subtitle "Health Profile"]]
     [:a {:href "#/account"} [:h2.subtitle "Account Info"]]
     [:a {:href "#/recent-medications"} [:h2.subtitle "Recently Browsed Meds"]
      ]

     ]))
