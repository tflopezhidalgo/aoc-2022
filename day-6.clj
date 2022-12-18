(defn find-first
  [pred col]
  (first (filter pred col)))

(defn is-marker-signal
  [[signal i]]
  (= (count (set signal)) (count signal)))

(defn find-start-of-packet
  [input nth]
  (let [chunks (map list (partition nth 1 input) (range))]
    (+ nth (second (find-first is-marker-signal chunks)))))

(defn- main
  []
  (let [data (slurp "day-6.input")]
    (println (find-start-of-packet data 4))
    (println (find-start-of-packet data 14))))

(main)