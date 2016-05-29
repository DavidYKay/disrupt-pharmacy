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
        heart-attack (subscribe [:questions :drug-score :heart-attack])
        diabetes (subscribe [:questions :drug-score :diabetes])
        answered-risk-questions (subscribe [:answered-risk-questions])
        can-fill (reaction (= (:name @current-drug) "Atorvastatin"))
        risk (reaction (cond
                         (and @logged-in @answered-risk-questions) 20
                         @logged-in 10
                         :else "-"))
        drug-name (reaction (:name @current-drug))
        drug-score (reaction (cond
                               (and (false? @heart-attack) (false? @diabetes)) 10
                               (and (false? @heart-attack) (nil? @diabetes)) 15
                               :else 70))]
    (fn []
      [:div.drugbible-page

       [top-bar]

       [:section.section
        [:div.container.has-text-centered
         [drug-rating @drug-score @risk]
         [:h1.title.drug-title @drug-name]
         ;; [:h2.subtitle (str "sub:" @current-drug)]
         ]]

       [:section.section
        [:div.container

         [:h2.subtitle "Description"]
         [:div.content (:description @current-drug)]

         [fill-rx-button @can-fill]
         (when (and @can-fill @logged-in)
           [:a.button
            {:href "#/treatment-alternatives"}
            (str "View Alternatives to " @drug-name)])]]

       [questions-box "test"]

       (when @logged-in
         [:section.section
          [:div.container.box
           [:h2.subtitle "Two Risk Questions"]
           [personalization-question :risk :race "What is your race?" false]
           [personalization-question :risk :smoker "Have you had a heart attack?" false]]])

       [:section.section
        [:div.container.box
         [:h2.subtitle "Personalize your results"]
         [personalization-question :drug-score :heart-attack "Have you ever had a heart attack or stroke?" @logged-in]
         [personalization-question :drug-score :diabetes "Do you have diabetes or are pre-diabetic?" @logged-in]

         (when (and (not-any? nil? [@heart-attack @diabetes])
                    (not @logged-in))
           [full-personalization-cta])]]

       [:section.section
        [:div.container
         [:h2.subtitle "Side Effects"]

         [:ul
          (for [{:keys [name percentage]} (:side-effects @current-drug)]
            ^{:key name}
            [:li (str "* " name " - " percentage)])]]]

       [:section.section
        [:div.container
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
           [:h1.title "Consult Booked"]
           [:div "You have booked a consult with Dr. Nguyen for 3PM tomorrow. She will call you then."]
           [:a.button.is-primary {:href "/#/adaptation-email"
                                  ;; :on-click #(println "show adaptation")
                                  }
            "Fast Forward"]]]]
        [:button.modal-close {:on-click #(dispatch [:consult-pharmacist false])}]]

       [:section.section
        [:div.container
         [fill-rx-button @can-fill]
         [consult-pharmacist-button]]]])))
