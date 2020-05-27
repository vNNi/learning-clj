(ns tail_recursion)

(defn meu-mapa
    [funcao sequencia]
    (let [primeiro (first sequencia)]
        (if (not (nil? primeiro))
        (do
            (funcao primeiro)
            (meu-mapa funcao (rest sequencia))))))

(defn meu-mapa-recur
    [funcao sequencia]
    (let [primeiro (first sequencia)]
        (if (not (nil? primeiro))
        (do
            (funcao primeiro)
            (recur funcao (rest sequencia))))))

(def vec ["vini" "fe" "lis"])

(meu-mapa-recur println vec) ; using recur macro

(meu-mapa println vec) ; using manual recursing, bad approach for some performance issues, like stack call
