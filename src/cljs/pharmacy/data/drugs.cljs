(ns pharmacy.data.drugs)

(def drugs {
            :atorvastatin {:name "Atorvastatin"
                           :description "A high-risk, high-reward drug. Is highly effective at reducing risk of heart attack but is known to cause significant side effects in some individuals."
                           :side-effects [{:name "Leg Cramps"
                                           :percentage "50%"}
                                          {:name "Headaches"
                                           :percentage "10%"}]
                           :drug-interactions [{:item "Grapefruit"
                                                :effect "Hives"}
                                               {:item "Tylenol"
                                                :effect "Diahrrea"}]}

            :lovastatin {:name "Lovastatin"
                           :description "A simple drug with different side effects."
                           :side-effects [{:name "Leg Cramps"
                                           :percentage "30%"}
                                          {:name "Headaches"
                                           :percentage "30%"}]
                           :drug-interactions [{:item "Strawberries"
                                                :effect "Hives"}
                                               {:item "Pumpkin"
                                                :effect "Diahrrea"}]}

            }

  )
