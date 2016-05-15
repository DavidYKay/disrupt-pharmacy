(ns pharmacy.components.drug-rating
  (:require [re-frame.core :as re-frame :refer [dispatch]]))

(defn drug-rating []
  [:div.tile.is-ancestor
   [:div.tile.is-parent
    [:div.tile.is-child.box
     [:div "B"]
     [:div "Overall Score"]
     ]]
   [:div.tile.is-parent.is-vertical
    [:div.tile.is-child.box
     [:div "A"]
     [:div "Effectiveness"]
     ]
    [:div.tile.is-child.box
     [:div "C"]
     [:div "Side Effects"]
     ]]])
