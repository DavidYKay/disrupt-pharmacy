(ns pharmacy.helpers)

(defn disabled-wrapper [class disabled?]
  (if disabled?
    (str class " is-disabled")
    class))