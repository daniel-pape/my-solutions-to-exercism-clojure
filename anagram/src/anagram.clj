(ns anagram
  (:require [clojure.string :as str]))

(defn anagrams-for
  [word candidates]
  (let [letters-of #(map keyword (str/split (str/lower-case %) #""))
        count-rule #(assoc %1 %2 (inc (get %1 %2 0)))
        letter-count-for #(reduce count-rule {} (letters-of %))
        lcw (letter-count-for  word)
        word-lower-case (str/lower-case word)]
    (filter #(and
               (not= word-lower-case (str/lower-case %))
               (= lcw (letter-count-for %)))
            candidates)))

