(ns pharmacy.components.page-indicator
  (:require
   [re-frame.core :as re-frame :refer [dispatch]]))

(defn page-indicator [current items]
  [:div.page-indicator
   (doall
    (map-indexed (fn [idx circle] 
                   ^{:key circle}
                   [:div
                    {:class (if (= idx current)
                              "circle current"
                              "circle other")}])
                 items))])
