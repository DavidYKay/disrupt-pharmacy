(ns disrupt-pharmacy.routes
  (:require [bidi.bidi :as bidi]
            [pushy.core :as pushy]
            [re-frame.core :as re-frame :refer [dispatch]]))

;; -------------------------
;; Route List
;; -------------------------

(def routes ["/" {
                  ""      :home
                  "about" :about
                  "drugs/" {"index.html" :drugs
                            [:id "/drug.html"] :drug}
                  ;; TODO: put these under drug detail
                  "consult" :consult
                  "uses" :uses
                  "efficacy" :efficacy
                  "questionnaire" :questionnaire
                  ;; Misc
                  "login" :login
                  "terms" :terms
                  ;[["foo/" [ #"\d+" :id ] "/bar" ] :handler ]
                  }])

(defn- parse-url [url]
  (bidi/match-route routes url))

(defn- dispatch-route [matched-route]
  (let [panel-name (keyword (str (name (:handler matched-route)) "-panel"))]
    (dispatch [:set-active-panel panel-name])))

(defn app-routes []
  (pushy/start! (pushy/pushy dispatch-route parse-url)))

(def url-for (partial bidi/path-for routes))

