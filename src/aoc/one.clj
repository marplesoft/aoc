(ns aoc.one
  (:require [clojure.string :as str]))

(defn parse-int-list
  [string]
  (map #(Long/parseLong %) (str/split-lines string)))

(defn resulting-frequency
  [freqs]
  (loop [acc 0
         fs freqs]
    (if (seq fs)
      (recur (+ acc (first fs)) (rest fs))
      acc)))

(defn first-duplicate
  [freqs]
  (loop [acc 0
         seen #{0}
         fs freqs]
    (let [freq (first fs)
          new-acc (+ acc freq)]
      (if (seen new-acc)
        new-acc
        (recur new-acc (conj seen new-acc) (rest fs))))))

(first-duplicate [2 4 1 -1])

(->> "src/aoc/one.txt"
     slurp
     parse-int-list
     resulting-frequency)

(->> "src/aoc/one.txt"
     slurp
     parse-int-list
     cycle
     first-duplicate)
