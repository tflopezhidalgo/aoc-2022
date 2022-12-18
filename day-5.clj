(require 'clojure.string)

;; Create 10 "queues" 
(defn build-stacks
  [size]
  (reduce 
   (fn [acc, _] (conj acc [])) 
   [] 
   (range size)))

(defn transpose [m] (apply (partial mapv vector) m))

(defn build-crate-stacks
  [serialized-state]

  ;; TODO. Build stacks based on parsing.
  (let [stacks (build-stacks 9)]
    ()))

(defn process-mov
  [mov]
  (println "Processing" mov "...no"))

(defn- main
  []
  (let [[current-state movs] (clojure.string/split (slurp "day-5.input") #"\n\n")]

    ;; (doall (map println (clojure.string/split-lines (slurp "day-5.input"))))

    (println
     "Transposed:"
     (transpose
      (map
       #(do (println "->" (clojure.string/split % #" ")) (clojure.string/split % #" "))
       (reverse (clojure.string/split-lines current-state)))))

    (map (fn [x] ()) movs)))

(main)
