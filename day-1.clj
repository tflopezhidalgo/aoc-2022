(defn sum-parts
  [x]
  (map #(reduce + %) x))

(defn reduce-calories
  [v]
  (let [result (filter #(not (= '(-1) %)) (partition-by #(= -1 %) v))]
    (sum-parts result)))

(defn get-num-or-sentinel
  [x]
  (cond
    (not (clojure.string/blank? x))
      (do
        (println "Processing" x)
        (Integer/parseInt x))
    :else -1))

(defn- main []
  (let [input (clojure.string/split-lines (slurp "day-1.input"))
        calories-vector (reverse (sort (reduce-calories (map get-num-or-sentinel input))))]

    (println
      "1. Max of calories:"
      (first calories-vector))

    (println
      "2. Sum of top 3 calories:"
      (+ (first calories-vector) (first (rest calories-vector)) (first (rest (rest calories-vector)))))))

(main)
