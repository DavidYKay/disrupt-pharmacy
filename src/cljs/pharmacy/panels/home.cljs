(ns pharmacy.panels.home
  (:require
            [pharmacy.components.searchbox :refer [searchbox]]
            [pharmacy.components.top-bar :refer [top-bar]]
            [re-frame.core :as re-frame :refer [subscribe]]))

(def items [
            {:title "Drug Glossary"
             :img "http://placehold.it/350x200"
             :text "Look up a drug's efficacy, its side-effects"
             :cta "Learn About A Medication"
             :className "front-meds"}
            {:title "Alternatives"
             :img "http://placehold.it/350x200"
             :text "Placeholder text about alternatives"
             :cta "Explore Alternatives"
             :className "front-alt"}
            {:title "Consult"
             :img "http://placehold.it/350x200"
             :text "Placeholder text about consultation"
             :cta "Consult a Pharmacist"
             :className "front-consult"}
            {:title "Medication Delivery"
             :img "http://placehold.it/350x200"
             :text "Placeholder text about filling Rx"
             :cta "Fill Prescription"
             :className "front-prescript"}])

(defn component []
  (let [name (subscribe [:name])]
    (fn []
      [:div

       [top-bar]

       [:section.hero.is-medium.has-text-centered.front-hero
       [:div.hero-body.front-search
        [:div.container
         [:h1.title.is-1 [:span "DrugIQ"]]
         [:h2.subtitle "How effective is your medication?"]

         [searchbox {:placeholder "Enter your medication"
                     :on-search #(println "Searched with term: " %)}]]]

       [:div.hero-foot.front-features
        [:div.container
         [:h4.subtitle.is-4 "Learn about the medication you're taking"]
         [:h4.subtitle.is-4 "See alternatives"]
         [:h4.subtitle.is-4 "Consult a pharmacist"]
         [:h4.subtitle.is-4 "Get Prescriptions Filled"]]]]

       (for [{:keys [title text img cta className]} items]
         ^{:key title}
         [:section.section {:class className}
          [:div.container.columns

           [:div.column.has-text-centered
            [:h1.title title]
            [:p text]
            [:a.button.is-large {:href "#"} cta]]]])])))
