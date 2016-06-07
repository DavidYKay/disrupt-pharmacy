(ns pharmacy.panels.google-results
  (:require [re-frame.core :as re-frame :refer [dispatch subscribe]]
            [pharmacy.components.searchbox :refer [searchbox]]))

(def ads [

          ])

(def results [{:title "Find out if Lovastatin is right for you - DrugIQ.ca"
               :summary "Lovastatin is a cholesterol-lowering medication.  By answering a few simple questions, find out your risk of having an adverse health event and whether pharmacists would recommend it for you."
               :link-text "drugiq.ca › Drug Bible › Lovastatin"
               :url "#/drug/lovastatin"}
              
              {:title "Lovastatin Side Effects in Detail - Drugs.com"
               :summary "Learn about the potential side effects of lovastatin. Includes common and rare side effects information for consumers and healthcare professionals."
               :link-text "www.drugs.com › Drugs A to Z › Lovastatin"
               :url "http://www.drugs.com"}])

(defn component []
  [:div.box
   [:img {:src "img/googlelogo.png"}]
   [searchbox {:placeholder ""
               :on-search #(dispatch [:set-active-panel :google-results-panel])}]

   (for [{:keys [title summary link-text url]} results]
     ^{:key url}
     [:a.search-result {:href url} 
      [:div 
       [:div title]
       [:div summary]
       [:a.link-text {:href url} link-text]]])])
