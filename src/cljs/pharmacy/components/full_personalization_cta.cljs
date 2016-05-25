(ns pharmacy.components.full-personalization-cta
  (:require
   [re-frame.core :as re-frame :refer [dispatch subscribe]]))

(defn full-personalization-cta []
  [:div
   [:div "Want better clinical advice?"]
   [:a.button {:on-click #(dispatch [:set-active-panel :input-phn-panel])} "Sign in"]])
