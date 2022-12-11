(require 'clojure.string)

(defn transpose [m] (apply (partial mapv vector) m))

(defn build-crate-stacks
  [serialized-state]
  ())

(defn process-mov
  [mov]
  (println "Processing" mov "...no"))

(defn- main
  []
  (let [[current-state movs] (clojure.string/split (slurp "day-5.input") #"\s\n")]

    (println
      "Transposed:"
      (transpose
        (map #(clojure.string/split % #"\s") (clojure.string/split current-state #"\n"))))

    (println "-----")

    (doall (map
      #(println %)
      (transpose
        (map #(clojure.string/split % #"\s") (clojure.string/split current-state #"\n")))))))
  ;; (println movs)))

(main)
