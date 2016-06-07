(ns pharmacy.panels.google-results
  (:require [re-frame.core :as re-frame :refer [dispatch subscribe]]
            [pharmacy.components.searchbox :refer [searchbox]]))

(def ads [{:title "Find out if Lovastatin is right for you - DrugIQ.ca"
           :summary "Lovastatin is a cholesterol-lowering medication.  By answering a few simple questions, find out your risk of having an adverse health event and whether pharmacists would recommend it for you."
           :link-text "drugiq.ca › Drug Bible › Lovastatin"
           :url "#/drug/lovastatin"}
          ])

(def results [
              ;; {:title "Find out if Lovastatin is right for you - DrugIQ.ca"
              ;;  :summary "Lovastatin is a cholesterol-lowering medication.  By answering a few simple questions, find out your risk of having an adverse health event and whether pharmacists would recommend it for you."
              ;;  :link-text "drugiq.ca › Drug Bible › Lovastatin"
              ;;  :url "#/drug/lovastatin"}
              
              {:title "Lovastatin Side Effects in Detail - Drugs.com"
               :summary "Learn about the potential side effects of lovastatin. Includes common and rare side effects information for consumers and healthcare professionals."
               :link-text "www.drugs.com › Drugs A to Z › Lovastatin"
               :url "http://www.drugs.com"}

              {:title "lovastatin oral : Uses, Side Effects, Interactions, Pictures, Warnings ..."
               :link-text "www.webmd.com/drugs/2/drug-11594-92/lovastatin-oral/lovastatin.../details"
               :summary "Find patient medical information for lovastatin oral on WebMD including its uses, side effects and safety, interactions, pictures, warnings and user ratings."
               :url "http://www.webmd.com/drugs/2/drug-11594-92/lovastatin-oral/lovastatin---oral/details"}

              {:title "Lovastatin (Oral Route) Side Effects - Mayo Clinic"
               :link-text "www.mayoclinic.org/drugs-supplements/lovastatin-oral.../side-effects/drg-20069029"
               :summary "Dec 1, 2015 - Lovastatin (Oral Route) · Print. Sections ... Although not all of these side effects may occur, if they do occur they may need medical attention."
               :url "http://www.mayoclinic.org/drugs-supplements/lovastatin-oral-route/side-effects/drg-20069029"}

              {:title "Apo-Lovastatin - Uses, Side Effects, Interactions - MedBroadcast.com"
               :link-text "www.medbroadcast.com/Drug/GetDrug/Apo-Lovastatin"
               :summary "Lovastatin belongs to the family of medications known as ... The following side effects have been reported by at least 1% of people taking this medication."
               :url "http://www.medbroadcast.com/Drug/GetDrug/Apo-Lovastatin"}
              ])

(defn search-result [{:keys [title summary link-text url]} is-ad?]
  [:div.search-result
  [:a.search-result {:href url} 
    [:div.result-title title]
    [:span.link-text {:href url}
     (when is-ad? [:span.is-ad "Ad"])
     link-text]
    [:div summary]]])

(defn component []
  [:div.box
   [:img {:src "img/googlelogo.png"}]
   [searchbox {:placeholder ""
               :on-search #(dispatch [:set-active-panel :google-results-panel])}]

   (for [ad ads]
     ^{:key (:url ad)}
     [search-result ad true])

   (for [r results]
     ^{:key (:url r)}
     [search-result r false])])
