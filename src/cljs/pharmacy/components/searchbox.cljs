(ns pharmacy.components.searchbox
  (:require
   [pharmacy.helpers :refer [on-enter]]
   [re-frame.core :as re-frame :refer [dispatch]]))

(defn searchbox [{:keys [placeholder
                         on-search]}]
  (let [val (atom "")
        stop #(reset! val "")
        save #(let [v (-> @val str clojure.string/trim)]
                (if-not (empty? v) (on-search v))
                (stop))]
    (fn []
      [:p.control.has-icon.has-icon-right
       [:input.input.is-large
        {:placeholder placeholder
         :type "text"
         :on-key-down (on-enter save)
         :on-change (fn [ev]
                      (reset! val (-> ev .-target .-value)))}]
       [:i.fa.fa-search]])))
