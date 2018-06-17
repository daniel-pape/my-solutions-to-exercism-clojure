(ns nucleotide-count)

(defn- is-admissable?
  "Checks whether strand is a string only containing one of
  the nucleotide characters A, G, C or T."
  [strand]
  (letfn [(checker [x] (some #(= % x) "AGCT"))]
    (every? checker (str strand))))

(defn count
  [nucleotide strand]
  (assert (and
            (is-admissable? nucleotide)
            (is-admissable? strand)))
  (clojure.core/count (filter #(= % nucleotide) (seq strand))))

(defn nucleotide-counts
  [strand]
  (assert (is-admissable? strand))
  (reduce #(assoc %1 %2 (count %2 strand)) {} "AGCT"))
