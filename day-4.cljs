(defn build-range
  [rng-def]

  ;; This is actually over-engineered, we don't care about
  ;; intermediate values as long as the ends are contained within
  ;; each other.

  (let [[begin, end] (clojure.string/split rng-def #"-")]
    (range (Integer. begin) (inc (Integer. end)))))

(defn range-contains?
  [rng, other]
  (and
    (<= (first rng) (first other))
    (>= (last rng) (last other))))

(defn range-contained?
  [assignment]
  (let [[first-range, second-range] (clojure.string/split assignment #",")]
    (or
      (range-contains? (build-range first-range) (build-range second-range))
      (range-contains? (build-range second-range) (build-range first-range)))))

(defn answer-1
  [input]
  (count (filter range-contained? input)))

(defn- main
  []
  (let [input (clojure.string/split-lines (slurp "day-4.input"))]
    (println "Answer 1:" (answer-1 input))))

(main)
