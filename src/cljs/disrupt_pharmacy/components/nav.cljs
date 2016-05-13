(ns disrupt-pharmacy.components.nav
  (:require [disrupt-pharmacy.routes :refer [routes url-for]]
            [clojure.walk :refer [postwalk]]
            [re-frame.core :as re-frame :refer [subscribe]]))

(defn component []
  (fn []
    [:div "Navigation"
     ;(print (vals (last routes)))
     (for [k (->> (vals (last routes))
                  (filter keyword?)
                  ;;(postwalk #(if (keyword? %)
                  ;;             %
                  ;;             nil))
                  ;;(remove nil?)
                  )]
       [:div [:a {:href (url-for k)} (name k)]])
     ;[:div [:a {:href (url-for :home)} "Home"]]
     ;;[:div [:a {:href (url-for :about)} "About"]]
     ]))
