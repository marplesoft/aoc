(ns aoc.three
  (:require [clojure.core.matrix :as mat]))

(mat/set-current-implementation :vectorz)

(def m (mat/new-matrix 5 5))
(mat/fill! m 1)
(def sm (mat/submatrix m 1 3 1 3))
(mat/emap! inc sm)
m

