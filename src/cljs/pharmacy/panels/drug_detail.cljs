(ns pharmacy.panels.drug-detail
  (:require
   [pharmacy.components.consult-pharmacist-button :refer [consult-pharmacist-button]]
   [pharmacy.components.drug-rating :refer [drug-rating]]
   [pharmacy.components.fill-rx-button :refer [fill-rx-button]]
   [pharmacy.components.full-personalization-cta :refer [full-personalization-cta]]
   [pharmacy.components.personalization-question :refer [personalization-question]]
   [pharmacy.components.questions-box :refer [questions-box]]
   [pharmacy.components.top-bar :refer [top-bar]]
   [pharmacy.components.drug-scores-modal :refer [drug-scores-modal]]
   [pharmacy.components.appointment-modal :refer [appointment-modal]]
   [pharmacy.components.personalization-modal :refer [personalization-modal]]
   [pharmacy.data.questions :refer [score-risk-questions]]
   [reagent.core :as reagent]
   [re-frame.core :as re-frame :refer [dispatch subscribe]])
  (:require-macros [reagent.ratom :refer [reaction]]))


(defn component []
  (let [current-drug (subscribe [:current-drug])
        logged-in (subscribe [:logged-in])
        drug-scores-modal-shown (subscribe [:drug-scores-modal-shown])
        appointment-modal-shown (subscribe [:appointment-modal-shown])
        personalization-modal-shown (subscribe [:personalization-modal-shown])
        drug-score (subscribe [:drug-score])
        risk (subscribe [:risk])
        fresh-from-google (subscribe [:fresh-from-google])
        can-fill (reaction (= (:name @current-drug) "Lovastatin"))
        drug-name (reaction (:name @current-drug))
        answered-questions? (subscribe [:answered-all-questions])
        render (fn []
                 [:div.drugbible-page

                  [top-bar]

                  [:section.section.head-title
                    [:h1.title.is-2.drug-title.has-text-centered @drug-name]]
                  [:section.section.drug-detail-descrip
                   [:div.container
                    [:h2.subtitle "What is this drug for?"]
                    [:div.content (:description @current-drug)]]]

                  [:section.section
                   [:div.box..score-and-questions
                    [:div.has-text-centered
                     [drug-rating @drug-score @risk]
                     [:a {:on-click #(dispatch [:drug-scores-modal true])}
                      [:p.subtitle.is-6.info-text
                       [:i.fa.fa-question-circle] "What do these scores mean?"]]]
                    [questions-box score-risk-questions]]]

                  ;; TODO: also check for logged-in. We're not doing so right now because the login flow is messed up.
                  [:section.section
                   {:class (if (and @can-fill @answered-questions?)
                             "" "questions-complete")}
                   [:div.box.alternatives-box
                    [:div "Pharmacists have ranked 5 other cholesterol-lowering medications higher than Lovastatin."]
                    [:div.has-text-centered.container
                     [:a.button.is-warning {:href "#/treatment-alternatives"}
                      "See Better Options"]]]]

                  [:section.drug-detail-ctas.has-text-centered {:class (if @can-fill "" "with-descrip")}
                  (if @can-fill ""
                    [:div.consult-cta-blurb "Speak to a pharmacist about " @drug-name])
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
                     (for [interaction (:drug-interactions @current-drug)]
                       ^{:key interaction}
                       [:li (str "* " interaction)])]]]

                  [drug-scores-modal @drug-scores-modal-shown]
                  [appointment-modal @appointment-modal-shown]
                  ;; [personalization-modal @personalization-modal-shown]

                  [:section.section.ctas-placeholder-bottom]])]

    (reagent/create-class
     {:component-did-mount #(when @fresh-from-google
                              (dispatch [:personalization-modal true]))
      :reagent-render render})))
