(ns pharmacy.components.fill-rx-button
  (:require
   [re-frame.core :as re-frame :refer [dispatch]]))

(defn fill-rx-button [can-fill]
  (when can-fill
    [:a.button.is-medium.fill-rx-button "Fill Prescription"]))
