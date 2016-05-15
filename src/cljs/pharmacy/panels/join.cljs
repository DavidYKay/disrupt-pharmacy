(ns pharmacy.panels.join
  (:require
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

       ;;[top-bar]
       
       [:div.box.columns
        [:div.column
         
         [:h1.title "Join DisPharm"]
         [:h2.subtitle "for more personalized medication evaluations, ordering medication, or consulting our pharmacists."]

         [:input.input {:placeholder "Enter your email" :type "text"}]
         [:input.input {:placeholder "Set a password" :type "text"}]

         [:a.button
          {:on-click #(dispatch [:set-active-panel :input-phn])}
          "Continue"]
         [:div "OR"]
         [:a.button
          {:on-click #(dispatch [:set-active-panel :login-panel])}
          "Sign In"]
         
         ;;[:input.input {:placeholder "Retype password" :type "text"}]
         
         [:div "Current PHN:" @phn]
         [:div "Please input your PHN:"]

         [:input.input
          {:placeholder "1122334455",
           :type "text"
           :on-key-down #(case (.-which %)
                           13 (save)
                           nil)
           :on-change (fn [ev]
                        (reset! val (-> ev .-target .-value)))}]]]])))
