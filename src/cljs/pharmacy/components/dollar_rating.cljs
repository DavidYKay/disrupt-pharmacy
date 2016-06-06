(ns pharmacy.components.dollar-rating
  (:require
   [re-frame.core :as re-frame :refer [dispatch]]))

(def dollar-signs (repeat "$"))

(defn dollar-rating [val max]
  [:span.cost-rating
   (let [dark-signs (take val dollar-signs)
         grey-signs (take (- max val) dollar-signs)]
     (concat
      (for [sign dark-signs]
        [:span.dark sign])
      (for [sign grey-signs]
        [:span.grey sign])))])
