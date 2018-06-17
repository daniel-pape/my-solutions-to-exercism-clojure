(ns hamming)

(defn distance
  [strand-1 strand-2]
  (loop [xs   strand-1
         ys   strand-2
         dist 0]
    (cond
      (and (empty? xs) (empty? ys)) dist
      (or (empty? xs) (empty? ys)) nil
      :default (recur (rest xs)
                      (rest ys)
                      (+ dist (if (= (first xs) (first ys)) 0 1))))))

;; Or just:
;; (defn distance
;;   [strand-1 strand-2]
;;   (let [same-length (= (count strand-1)
;;                        (count strand-2))]
;;     (when same-length
;;       (count (filter false?
;;                      (map
;;                        #(apply = %)
;;                        (map vector strand-1 strand-2)))))))
