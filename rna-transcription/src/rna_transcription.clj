(ns rna-transcription (:require [clojure.string :as str]))

(defn to-rna
  [strand]
  (let [is-dna-strand (str/blank? (str/replace strand #"[GCTA]" ""))]
    (assert is-dna-strand (str "to-rna was called with non-proper strand = " strand))
    (let [transcript {\G \C
                      \C \G
                      \T \A
                      \A \U}]
      (str/join (map transcript strand)))))
