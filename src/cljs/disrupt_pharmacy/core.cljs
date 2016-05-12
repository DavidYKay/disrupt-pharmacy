(ns disrupt-pharmacy.core
  (:require [disrupt-pharmacy.components.book-consultation :as book-consultation]
            [disrupt-pharmacy.components.drug-detail :as drug-detail]
            [disrupt-pharmacy.components.main-ui :as main-ui]
            [disrupt-pharmacy.routes :as routes]
            [re-frame.core :as re-frame :refer [dispatch-sync subscribe register-handler register-sub]]
            [reagent.core :as r :refer [atom]]
            [reagent.session :as session])
  (:require-macros [reagent.ratom :refer [reaction]]))

;;(defonce app-db (atom {:text "Hello Chestnut!"}))

(def initial-state
  {:active-panel :home-panel
   :name "David"
   })


(register-handler                 ;; setup initial state
  :initialize                     ;; usage:  (dispatch [:initialize])
  (fn
    [db _]
    (println "initializing")
    (let [new-db (merge db initial-state)]
      ;;(println "old-db: " db)
      ;;(println "new-db: " new-db)
      new-db)))    

(register-handler :set-active-panel 
                  (fn [db [_ item-id]]
                    (assoc db :active-panel item-id)))

(register-sub :active-panel 
              (fn [db _]
                (reaction (:active-panel @db))))

(register-sub :name
              (fn [db _]
                (reaction (:name @db))))

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


(defn greet         ;; outer, setup function, called once
  []
  (let [name-ratom  (subscribe [:name-query])]    ;; <---- subscribing happens here
    (fn []        ;; the inner, render function, potentially called many times.
      [:div "Hello" @name-ratom])))

(defn main-panel []
  (let [active-panel (subscribe [:active-panel])]
    (println "Hello main panel")
    (println "active panel: " active-panel)
    (println "active panel deref: " @active-panel)
    ;;(println "App db: " @app-db)
    (fn []
      (panels @active-panel))))

(defn ^:export run []
  (enable-console-print!)
  (dispatch-sync [:initialize])
  (r/render [main-panel] (js/document.getElementById "app")))
