(ns bob (:require [clojure.string :as str]))

(defn- is-nothing-said?
  "Returns true if and only if line is just whitespace(s)."
  [line]
  (str/blank? line))

(defn- is-question?
  "Returns true if and only if line ends in question mark."
  [line]
  (= (last line) \?))

(defn- is-yelled?
  "Returns true if and only if line is all upper-case
  and contains some word (sequence of letters)"
  [line]
  (let [line-upper-cased (str/upper-case line)
        contains-word? #(boolean (re-find #"[a-zA-Z]" %))]
    (and (contains-word? line) (= line line-upper-cased))))

(defn response-for
  "Returns Bob's response to the line."
  [line]
  (cond
    (is-nothing-said? line) "Fine. Be that way!"
    (is-yelled? line) "Whoa, chill out!"
    (is-question? line) "Sure."
    :else  "Whatever." ))
