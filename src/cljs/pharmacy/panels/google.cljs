(ns pharmacy.panels.google
  (:require [re-frame.core :as re-frame :refer [dispatch subscribe]]
            [pharmacy.components.searchbox :refer [searchbox]]))

(defn component []
  [:div.box.has-text-centered
   [:img {:src "img/googlelogo.png"}]
   ;; [:img {:src "img/searchbutton.png"}]
   [searchbox {:placeholder ""
               :on-search #(dispatch [:set-active-panel :google-results-panel])}]])
