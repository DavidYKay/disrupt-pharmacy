(ns pharmacy.helpers)

(defn on-enter
  "A function to create an on-enter-key listener.
  Most commonly used with the :on-key-down attribute"
  [f]
  #(case (.-which %)
     13 (f)
     nil))

(defn disabled-wrapper [class disabled?]
  (if disabled?
    (str class " is-disabled")
    class))
