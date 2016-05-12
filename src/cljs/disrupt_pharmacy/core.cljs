(ns disrupt-pharmacy.core
  (:require [disrupt-pharmacy.components.book-consultation :as book-consultation]
            [disrupt-pharmacy.components.drug-detail :as drug-detail]
            [disrupt-pharmacy.components.main-ui :as main-ui]
            [disrupt-pharmacy.routes :as routes]
            [disrupt-pharmacy.handlers]
            [disrupt-pharmacy.subscriptions]
            [re-frame.core :as re-frame :refer [dispatch-sync subscribe register-handler register-sub]]
            [reagent.core :as r :refer [atom]]
            [reagent.session :as session])
  (:require-macros [reagent.ratom :refer [reaction]]))

;; -------------------------
;; Routing
;; -------------------------

(defn home-panel []
  (let [name (subscribe [:name])]
    (fn []
      [:div (str "Hello from " @name ". This is the Home Page.")
       [:div [:a {:href (routes/url-for :about)} "go to About Page"]]])))

(defn about-panel []
  (fn []
    [:div "This is the About Page."
     [:div [:a {:href (routes/url-for :home)} "go to Home Page"]]]))

(defmulti panels identity)
(defmethod panels :home-panel [] [home-panel])
(defmethod panels :about-panel [] [about-panel])
(defmethod panels :default [] [:div])

(defn main-panel []
  (let [active-panel (subscribe [:active-panel])]
    (fn []
      (panels @active-panel))))

(defn ^:export run []
  (enable-console-print!)
  (dispatch-sync [:initialize])
  (r/render [main-panel] (js/document.getElementById "app")))
