(defn get-points-from-shape
  [shape]
  (let [points-per-shape {:rock 1 :paper 2 :scissors 3}]
    (points-per-shape shape)))

(defn get-opponent-shape-from-movement
  [opponent-movement]
  ({"A" :rock, "B" :paper, "C" :scissors} oponent-movement))

(defn get-movement-shape-from-movement
  [movement]
  ({"X" :rock, "Y" :paper, "Z" :scissors} movement))

;; scissors < rock
;; rock < paper
;; paper < scissor
(defn get-match-result
  [my-movement opponent-movement]
  (cond
    ;; TODO
    (eq)))

(defn resolve-match
  "Given a match tell me how many points I made."
  [match]
  (let [my-mov (first (get-movement-shape-from-movement match))
        opponent-mov (second (get-opponent-shape-from-movement match))]
    ))

(defn build-points-list
  "Build a single list containing total points of each match."
  [matches]
  ;; (loop [-matches matches
  ;;        cum []]
  ;;   (println "Processing match" (take 2 -matches))
  ;;   (println "Matches is" -matches)
  ;;   (cond
  ;;     (= 0 (count (nnext -matches))) cum
  ;;     :else (recur (nnext -matches) (conj cum ))))
  (partition-all 2 matches))

(defn- main []
  (let [-input (clojure.string/split-lines (slurp "day-2.input"))]
    (println "hey" -input)
    (map #(println "value" %) -input)))

(main)
