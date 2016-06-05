(ns pharmacy.data.drugs)

(def statin-side-effects 
  [{:name "Muscle pain"                 :percentage "10%"}
   {:name "Diarrhea"                    :percentage "11%"}
   {:name "Insomnia"                    :percentage "5%"}
   {:name "Liver toxicity"              :percentage "rare"}
   {:name "Increase in blood sugars"    :percentage ""}
   {:name "Development of new diabetes" :percentage " 1%"}])

(def drugs {:atorvastatin {:name "Atorvastatin"
                           :description "A high-risk, high-reward drug. Is highly effective at reducing risk of heart attack but is known to cause significant side effects in some individuals."
                           :side-effects statin-side-effects
                           :drug-interactions [{:item "Grapefruit"
                                                :effect "Hives"}
                                               {:item "Tylenol"
                                                :effect "Diahrrea"}]}

            :rosuvastatin {:name "Rosuvastatin"
                           :description "A simple drug with different side effects."
                           :side-effects statin-side-effects
                           :drug-interactions [{:item "Strawberries"
                                                :effect "Hives"}
                                               {:item "Pumpkin"
                                                :effect "Diahrrea"}]}

            :lovastatin {:name "Lovastatin"
                           :description "Lovastatin, like other statin drugs, is used to lower cholesterol, and could lower your chance of heart attack, stroke, or death."
                         :side-effects statin-side-effects
                         :drug-interactions [{:item "Strawberries"
                                              :effect "Hives"}
                                             {:item "Pumpkin"
                                              :effect "Diahrrea"}]}}) 
