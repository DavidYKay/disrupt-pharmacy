(ns pharmacy.panels.input-phn
  (:require
   [re-frame.core :as re-frame :refer [dispatch subscribe]]
   [pharmacy.components.x-button :refer [x-button]]))

(def example-phn "1122334455")
(defn component []
  (let [phn (subscribe [:phn])
        val (atom example-phn)
        on-save (fn [v]
                  (dispatch [:set-phn v]))
        stop #(reset! val "")
        save #(let [v (-> @val str clojure.string/trim)]
                (println "saving")
                (if-not (empty? v) (on-save v))
                (stop))]
    (fn []
      [:div.container.box

       [x-button]

       [:h1.title "Please input your Personal Health Number (PHN):"]

       [:input.input
        {:value @val
         :text "11"
         :type "text"
         :on-key-down #(case (.-which %)
                         13 (save)
                         nil)
         :on-change (fn [ev]
                      (reset! val (-> ev .-target .-value)))}]
       ;;[:h2.subtitle "Current PHN:" @phn]
       ])))
