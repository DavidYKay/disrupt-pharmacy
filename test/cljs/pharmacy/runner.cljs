(ns pharmacy.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [pharmacy.core-test]))

(doo-tests 'pharmacy.core-test)
