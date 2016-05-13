(ns disrupt-pharmacy.panels
  (:require [re-frame.core :as re-frame :refer [subscribe]]
            [disrupt-pharmacy.routes :refer [url-for]]
            [disrupt-pharmacy.panels.consult :as consult]
            [disrupt-pharmacy.panels.efficacy :as efficacy]
            [disrupt-pharmacy.panels.search   :as search]
            [disrupt-pharmacy.panels.drug-detail :as drug-detail]
            [disrupt-pharmacy.panels.login    :as login]
            [disrupt-pharmacy.panels.terms    :as terms]
            ))

;; -------------------------
;; Mapping to Panels
;; -------------------------

(defn home-panel []
  (let [name (subscribe [:name])]
    (fn []
      [:div (str "Hello from " @name ". This is the Home Page. Woot")
       [:div [:a {:href (url-for :about)} "go to About Page"]]])))

(defn about-panel []
  (fn []
    [:div "This is the About Page."
     [:div [:a {:href (url-for :home)} "go to Home Page"]]]))

(def panels {:home home-panel
             :about about-panel
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
