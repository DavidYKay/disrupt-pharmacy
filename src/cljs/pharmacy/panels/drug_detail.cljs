(ns pharmacy.panels.drug-detail
  (:require
   [pharmacy.components.drug-rating :refer [drug-rating]]
   [re-frame.core :as re-frame :refer [dispatch subscribe]]
   [pharmacy.components.debug :refer [debug-boolean]]
   [pharmacy.components.personalization-question :refer [personalization-question]]
   [pharmacy.components.full-personalization-cta :refer
    [full-personalization-cta]]
   [pharmacy.components.top-bar :refer [top-bar]]))


(defn component []
  (let [heart-attack (subscribe [:questions :heart-attack])
        diabetes (subscribe [:questions :diabetes])]
    ;(println "diabetes: " @diabetes)
    (fn []
      [:div.drugbible-page

       [top-bar]

       [:section.section
        [:div.container.has-text-centered
         [drug-rating]
         [:h1.title.drug-title "Atorvastatin"]]]

       [:section.section
        [:div.container

         [:h2.subtitle "Description"]
         [:div.content "A high-risk, high-reward drug. Is highly effective at reducing risk of heart attack but is known to cause significant side effects in some individuals."]

         [:a.button "Fill Prescription"]
         [:a.button "Consult"]]]

       [:section.section
        [:div.container.box
         [:h2.subtitle "Personalize your results"]

         [personalization-question :heart-attack "Have you ever had a heart attack or stroke?"]
         [personalization-question :diabetes "Do you have diabetes or are pre-diabetic?"]
         
         ;;[:a.button {:on-click #(dispatch [:question :diabetes true])} "Yes"]
         ;;[:a.button {:on-click #(dispatch [:question :diabetes false])} "No"]

         (when (not-any? nil? [@heart-attack @diabetes])
           [full-personalization-cta]
           )]]

       [:section.section
        [:div.container
         [:a.button
          {:href "#/treatment-alternatives"}
          "View Alternatives to Atorvastatin"]]]

       [:section.section
        [:div.container
         [:h2.subtitle "Side Effects"]
         [:ul
          [:li "* Leg Cramps - 50%"]
          [:li "* Headaches - 10%"]]]]

       [:section.section
        [:div.container
         [:h2.subtitle "Drug Interactions"]
         [:ul
          [:li "* Grapefruit - Hives"]
          [:li "* Tylenol - Diahrrea"]]]]

       [:section.section
        [:div.container
         [:div.columns
          [:div.column
           [:a.button "Fill Prescription"]]
          [:div.column
           [:a.button "Consult Pharmacist"]]]]]])))
