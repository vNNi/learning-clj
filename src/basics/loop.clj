(ns loop)

(defn conta 
    [elementos]
    (loop [total-ate-agora 0 elementos-restantes elementos]
        (if (seq elementos-restantes)
            (recur (inc total-ate-agora) (next elementos-restantes))
            total-ate-agora)))

(conta ["vin" "fe"])