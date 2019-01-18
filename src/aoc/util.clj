(ns aoc.util)

(defn in?
  [el col]
  (some #(= el %) col))
