(ns pharmacy.config)

(def debug?
  ^boolean js/goog.DEBUG)

(when true
  (enable-console-print!))
