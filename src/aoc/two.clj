
(ns aoc.two
  (:require [clojure.string :as str]
            [aoc.util :as util]
            [clojure.math.combinatorics :refer [combinations]]
            [clojure.data :refer [diff]]))

;; Read the file and get a vector of strings
;; Map that vector into a {char: occurence-count} map
;; Filter that vector into items with at least one value of 2
;; Seperately, filter it for items with a value of 3
;; Take those counts, and multiply them together

(defn load-bin-vector
  [file]
  (->> file slurp str/split-lines))

(defn occurence-counts
  [bin]
  (->> bin
       char-array
       seq
       frequencies
       vals))

(defn counts-with
  [occurences n]
  (count (filter #(util/in? n % ) occurences)))

(defn checksum
  [file]
  (let [bins (load-bin-vector file)
        occurences (map occurence-counts bins)]
        (* (counts-with occurences 2)
           (counts-with occurences 3))))

(checksum "src/aoc/two.txt")

(defn chars-off-by
  [[s1 s2]]
  (let [c1 (seq (char-array s1))
        c2 (seq (char-array s2))
        len (count c1)
        matched (get (diff c1 c2) 2)
        num-matched (count (filter some? matched))]
    (- len
       num-matched)))

(defn common-letters-in-matched-bins
  [file]
  (let [bins (load-bin-vector file)
        combinations (combinations bins 2)
        matches (some #(when (= (chars-off-by %) 1) %) combinations)
        c1 (seq (char-array (first matches)))
        c2 (seq (char-array (second matches)))
        same-chars (get (diff c1 c2) 2)]
    (apply str same-chars)))

(common-letters-in-matched-bins "src/aoc/two.txt")
