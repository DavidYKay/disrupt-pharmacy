(ns pharmacy.components.debug
  (:require
   [re-frame.core :as re-frame :refer [dispatch]]))

(defn debug-boolean [x]
  [:div 
   (if x
     "true"
     "false")])
   
