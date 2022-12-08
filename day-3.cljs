(require 'clojure.set)
(require 'clojure.string)

(def lowercased-alphabet "abcdefghijklmnopqrstuvwxyz")

(defn is-lowercased-ascii [x]
  (clojure.string/includes? lowercased-alphabet x))

(defn is-uppercased-ascii[x]
  (clojure.string/includes? (clojure.string/upper-case lowercased-alphabet) x))

(defn get-item-priority [item]
  (let [item-ascii-code (int item)]
    (cond
      ;; apply offset so we match a -> 1
      (is-lowercased-ascii (str item)) (- item-ascii-code 96)

      ;; apply offset so we match a -> 1
      (is-uppercased-ascii (str item)) (+ (- item-ascii-code 64) 26)

      :else (print "Ouch, you should not be here"))))

(defn get-shared-item [[c1 c2]]
  (let [return (clojure.set/intersection (set c1) (set c2))]
    (println "Shared item between" c1 "and" c2 "is" return)
    (first return)))

(defn process-rucksack
  [rucksack]
  (let [rucksack-size (count rucksack)
        [c1 c2] (partition (/ rucksack-size 2) rucksack)]
    (get-item-priority (get-shared-item [c1 c2]))))

(defn- main
  []
  (let [input (clojure.string/split-lines (slurp "day-3.input"))]
    (println (apply + (map process-rucksack input)))))

(main)
