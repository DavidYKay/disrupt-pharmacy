(ns pharmacy.panels.google-results
  (:require [re-frame.core :as re-frame :refer [dispatch subscribe]]
            [pharmacy.components.searchbox :refer [searchbox]]))

(def ads [

          ])

(def results [
              {:title "Lovastatin Side Effects in Detail - Drugs.com"
               :summary "Learn about the potential side effects of lovastatin. Includes common and rare side effects information for consumers and healthcare professionals."
               :url "www.drugs.com › Drugs A to Z › Lovastatin"}
              ])

(defn component []
  [:div.box
   [:img {:src "img/googlelogo.png"}]
   [searchbox {:placeholder ""
               :on-search #(dispatch [:set-active-panel :google-results-panel])}]

   ;; [:ul
   ;;  [:li "All"]
   ;;  [:li "Images"]
   ;;  [:li "More"]]

   (for [{:keys [title summary url]} results]
     ^{:key url}
     [:div 
      [:div title]
      [:div summary]
      [:a {:href "#/drug/lovastatin"} url]])
   
   ;; [:img {:src "img/searchbutton.png"}]
   ])
