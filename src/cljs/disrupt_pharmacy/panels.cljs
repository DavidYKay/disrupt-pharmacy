(ns disrupt-pharmacy.panels
  (:require [re-frame.core :as re-frame :refer [subscribe]]
            [disrupt-pharmacy.routes :refer [url-for]]
            [disrupt-pharmacy.panels.about :as about]
            [disrupt-pharmacy.panels.consult :as consult]
            [disrupt-pharmacy.panels.drug-detail :as drug-detail]
            [disrupt-pharmacy.panels.efficacy :as efficacy]
            [disrupt-pharmacy.panels.home :as home]
            [disrupt-pharmacy.panels.login    :as login]
            [disrupt-pharmacy.panels.search   :as search]
            [disrupt-pharmacy.panels.terms    :as terms]
            ))

(def panels {:home home/component
             :about about/component
             :consult consult/component
             :efficacy efficacy/component
             :search search/component
             :drug drug-detail/component
             :login login/component
             :terms terms/component})

(defn get-panel [k]
  (let [p (get panels k)]
    (if p
      [p]
      [:div])))
