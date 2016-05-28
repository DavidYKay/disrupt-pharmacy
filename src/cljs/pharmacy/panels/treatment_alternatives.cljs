(ns pharmacy.panels.treatment-alternatives
  (:require
   [pharmacy.components.drug-rating :refer [drug-rating]]
   [pharmacy.components.top-bar :refer [top-bar]]))

(defn component []
  (let [alternatives [{:rating {:overall :B+
                                :effectiveness :B
                                :side-effects :A}
                       :title "Exercise"
                       :description "It has been shown that cardiovascular exercise of 45 minutes 5 days a week reduces heart attack risk by XX%."}
                      {:rating {:overall :C
                                :effectiveness :C
                                :side-effects :A}
                       :title "An OTC"
                       :description "This OTC has minimal side effects and so-so efficacy."}
                      {:rating {:overall :B-
                                :effectiveness :B
                                :side-effects :C}
                       :title "Some other drug"
                       :description "This other drug is comparable to Atorvastatin."}]]
    (fn []
      [:div
       [top-bar]
       
       [:h1.title "Alternatives to Atorvastatin"]

       (for [{:keys [rating title description]} alternatives]
         ^{:key title}
         [:div.box
          [drug-rating 85]
          ;;[:div (str "Overall: " (name (:overall rating)))]
          ;;[:div (str "Effectiveness: " (name (:effectiveness rating)))]
          ;;[:div (str "Side Effects: " (name (:side-effects rating)))]
          [:h2.subtitle title]
          [:div description]])])))
