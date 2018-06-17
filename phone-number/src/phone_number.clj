(ns phone-number (:require [clojure.string :as str]))

(defn number
  [input]
  (let [clean (fn [input] (str/join (filter #(Character/isDigit %) input)))
        cleaned-input (clean input)
        number-of-digits (count cleaned-input)
        bad-number "0000000000"]
    (cond
      (= number-of-digits 10)                    cleaned-input
      (and (= number-of-digits 11)
           (str/starts-with? cleaned-input "1")) (str/replace-first cleaned-input "1" "")
      :default                                   bad-number)))

(defn area-code
  [input]
  (subs (number input) 0 3))

(defn pretty-print
  [input]
  (let [number (number input)]
    (str/replace number #"(...)(...)(....)" "($1) $2-$3")))
