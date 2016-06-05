(ns pharmacy.panels.drug-detail
  (:require
   [pharmacy.components.drug-rating :refer [drug-rating]]
   [re-frame.core :as re-frame :refer [dispatch subscribe]]
   [pharmacy.components.questions-box :refer [questions-box]]
   [pharmacy.components.consult-pharmacist-button :refer [consult-pharmacist-button]]
   [pharmacy.components.fill-rx-button :refer [fill-rx-button]]
   [pharmacy.components.personalization-question :refer [personalization-question]]
   [pharmacy.components.full-personalization-cta :refer
    [full-personalization-cta]]
   [pharmacy.components.top-bar :refer [top-bar]])
  (:require-macros [reagent.ratom :refer [reaction]]))


(defn component []
  (let [current-drug (subscribe [:current-drug])
        logged-in (subscribe [:logged-in])
        modal-shown (subscribe [:modal-shown])
        drug-score (subscribe [:drug-score])
        risk (subscribe [:risk])
        can-fill (reaction (= (:name @current-drug) "Lovastatin"))
        drug-name (reaction (:name @current-drug))]
    (fn []
      [:div.drugbible-page

       [top-bar]

       [:section.section.drug-detail-descrip
        [:div.container
        [:h1.title.is-2.drug-title.has-text-centered @drug-name]
         [:h2.subtitle "What is this drug for?"]

         [:div.content (:description @current-drug)]]]

       [:section.section
       [:div.box..score-and-questions
        [:div.has-text-centered
         [drug-rating @drug-score @risk]
         [:p.subtitle.is-6.info-text
          [:i.fa.fa-question-circle] "What do these scores mean?"]]

       [questions-box "test"]
       ;; [full-personalization-cta]
       ]]

       ;; TODO: also check for logged-in. We're not doing so right now because the login flow is messed up.
       (when @can-fill 
         [:section.section
          [:div.has-text-centered
           [:div "Out of the 6 cholesterol-lowering medications we asked pharmacists about, they have ranked Lovastatin 6 out of 6 (tie)."]
           [:a.button.is-medium {:href "#/treatment-alternatives"}
            "See better options"]]])

       [:section.drug-detail-ctas.has-text-centered
        [:div.container
         [fill-rx-button @can-fill]
         [consult-pharmacist-button]]]

       [:section.section
        [:div.box.drug-detail-sideFX
         [:h2.subtitle "Common Side Effects"]
         [:ul
          (for [{:keys [name percentage]} (:side-effects @current-drug)]
            ^{:key name}
            [:li (str "* " name " - " percentage)])]]

        [:div.box.drug-detail-interactions
         [:h2.subtitle "Drug Interactions"]
         [:ul
          (for [{:keys [item effect]} (:drug-interactions @current-drug)]
            ^{:key item}
            [:li (str "* " item " - " effect)])]]]

       [:div {:class (if @modal-shown
                       "modal is-active"
                       "modal")}
        [:div.modal-background {:on-click #(dispatch [:consult-pharmacist false])}]
        [:div.modal-container
         [:div.modal-content
          [:div.box
           [:h1.title "Consultation Appointment Booked"]
           [:div "Please expect a phone call from pharmacist Dr. Nguyen at 3:00 pm on Wednesday June 8th, 2016.  If you need to update your contact phone number or change the appointment, please do so via the Patient Dashboard."]
           
           [:a.button.is-primary {:href "/#/adaptation-email"}
            "Fast Forward"]]]]
        [:button.modal-close {:on-click #(dispatch [:consult-pharmacist false])}]]

        [:section.section.ctas-placeholder-bottom]

         ])))
