(ns aoc.one-test
  (:require  [clojure.test :refer :all]
             [aoc.one :as one]))

(deftest file-parsing
  (is (= (one/parse-int-list "+1\n-2\n0")
         [1 -2 0])))

(deftest acceptance
  (is (= (one/resulting-frequency [1 -2])
         -1)))
