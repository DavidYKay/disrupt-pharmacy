(ns pharmacy.data.drugs)

(def statin-side-effects 
  [{:name "Muscle pain"                 :percentage "10%"}
   {:name "Diarrhea"                    :percentage "11%"}
   {:name "Insomnia"                    :percentage "5%"}
   {:name "Liver toxicity"              :percentage "rare"}
   {:name "Increase in blood sugars"    :percentage ""}
   {:name "Development of new diabetes" :percentage " 1%"}])

(def interactions ["Grapefruit juice"
                   "Red yeast rice products"
                   "Fibrates"
                   "Antiarrhythmics"
                   "Angina medication"
                   "Blood thinners"
                   "Azole antifungals"
                   "HIV protease inhibitors"
                   "Hepatitis C protease inhibitors"
                   "Clarithromycin (antibiotic)"
                   "Ciclosporin (organ transplant immunosuppressant)"
                   "Colchicine (gout medication)"])

(def drugs {:atorvastatin {:name "Atorvastatin"
                           :description "Atorvastatin is used to lower cholesterol, and could lower your chance of heart attack, stroke, or death."
                           :side-effects statin-side-effects
                           :drug-interactions interactions}

            :rosuvastatin {:name "Rosuvastatin"
                           :description "A simple drug with different side effects."
                           :side-effects statin-side-effects
                           :drug-interactions interactions}

            :lovastatin {:name "Lovastatin"
                           :description "Lovastatin is used to lower cholesterol, and could lower your chance of heart attack, stroke, or death."
                         :side-effects statin-side-effects
                         :drug-interactions interactions}}) 

