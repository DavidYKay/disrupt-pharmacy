(ns disrupt-pharmacy.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [disrupt-pharmacy.core-test]))

(enable-console-print!)

(doo-tests 'disrupt-pharmacy.core-test)
