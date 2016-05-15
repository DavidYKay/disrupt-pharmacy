(ns pharmacy.panels.login
  (:require
   [pharmacy.components.join-button :refer [join-button]]
   [pharmacy.components.menu-button :refer [menu-button]]
   [re-frame.core :as re-frame :refer [dispatch subscribe]]))

(defn component []
  (let [phn (subscribe [:phn])
        val (atom "")
        on-save (fn [v]
                  (dispatch [:set-phn v]))
        stop #(reset! val "")
        save #(let [v (-> @val str clojure.string/trim)]
                (if-not (empty? v) (on-save v))
                (stop))]
    (fn []
      [:div.container
       
       [:div.top-bar.box.columns
        [:div.column
         [menu-button]]
        [:div.column
         [join-button]]]
       
       [:div.box.columns
        [:div.column
         
         [:h1 "Login"]
         [:div "Current PHN:" @phn]
         [:div "Please input your PHN:"]

         [:input
          {:placeholder "1122334455",
           :type "text"
           :on-key-down #(case (.-which %)
                           13 (save)
                           nil)
           :on-change (fn [ev]
                        (reset! val (-> ev .-target .-value)))}]]]])))
