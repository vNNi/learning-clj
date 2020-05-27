(ns arity_loops)

(defn conta
    ([elementos] (conta 0 elementos))
    ([total-ate-agora elementos]
    (if (seq elementos)
        (recur (inc total-ate-agora) (next elementos))
        total-ate-agora)))

(conta 0 ["vini", "fe"])
(conta [])