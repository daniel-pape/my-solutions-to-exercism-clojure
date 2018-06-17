(ns beer-song (:require [clojure.string :as str]))

(defn verse
  [number]
  (letfn [(beginning-part
            [number]
            (case number
              0 (str "No more bottles of beer on the wall, no more bottles of beer.\n")
              1 (str number " bottle of beer on the wall, " number " bottle of beer.\n")
              (str number " bottles of beer on the wall, " number " bottles of beer.\n")))

          (middle-part
            [number]
            (case number
              0 "Go to the store and buy some more, "
              1 "Take it down and pass it around, "
              "Take one down and pass it around, "))

          (final-part
            [number]
            (case number
              0 "99 bottles of beer on the wall.\n"
              1 "no more bottles of beer on the wall.\n"
              (let [remaining (dec number)]
                (str remaining " bottle" (when (not= remaining 1) "s") " of beer on the wall.\n"))))]
    (str (beginning-part number)
         (middle-part number)
         (final-part number))))

(defn sing
  ([start end]
   (let [verses (for [i (range start (dec end) -1)] (verse i))]
     (str/join "\n" verses)))
  ([start] (sing start 0)))

