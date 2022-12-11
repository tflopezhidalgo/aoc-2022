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

      ;; apply offset so we match A -> 26
      (is-uppercased-ascii (str item)) (+ (- item-ascii-code 64) 26)

      :else ((print "Ouch, you should not be here") -1))))

(defn get-shared-item [xs]
  (let [intersection (apply clojure.set/intersection (map set xs))]

    ;; it's a seq
    (first intersection)))

(defn process-rucksack
  [rucksack]
  (let [rucksack-size (count rucksack)
        [c1 c2] (partition (/ rucksack-size 2) rucksack)]
    (get-item-priority (get-shared-item [c1 c2]))))

(defn get-group-rucksacks-priority
  [rucksacks]
  (let [shared-item (get-shared-item rucksacks)]
    (get-item-priority shared-item)))

(defn answer-2
  [rucksacks]
  (let [groups-rucksacks (partition 3 rucksacks)]
    (apply + (map get-group-rucksacks-priority groups-rucksacks))))

(defn answer-1
  [rucksacks]
  (apply + (map process-rucksack rucksacks)))

(defn- main
  []
  (let [input (clojure.string/split-lines (slurp "day-3.input"))]
    (println "1. Answer:" (answer-1 input))
    (println "2. Answer:" (answer-2 input))))

(main)
