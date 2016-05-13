(ns disrupt-pharmacy.core
  (:require [disrupt-pharmacy.routes :as routes]
            [disrupt-pharmacy.handlers]
            [disrupt-pharmacy.subscriptions]
            [re-frame.core :as re-frame :refer [dispatch-sync subscribe]]
            [reagent.core :as r :refer [atom]]
            [reagent.session :as session])
  (:require-macros [reagent.ratom :refer [reaction]]))

(defn main-panel []
  (let [active-panel (subscribe [:active-panel])]
    (fn []
      (routes/panels @active-panel))))

(defn ^:export run []
  (enable-console-print!)
  (dispatch-sync [:initialize])
  (routes/app-routes)
  (r/render [main-panel] (js/document.getElementById "app")))
