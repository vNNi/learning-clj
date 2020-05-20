(ns loja)

(defn greetin [greet]
    (str greet "world"))

(def ar ["vini" "fe"])
(map println ["vini" "fe"])

(first ar) ;first item on array
(rest ar) ;the rest from array

(defn meu-mapa
    [funcao sequencia]
    (let [primeiro (first sequencia)]
    (if primeiro 
        (do
            (funcao primeiro)
            (meu-mapa funcao (rest sequencia ))))))

(meu-mapa println ar)
(meu-mapa println ["vini" false]) ; não funciona pois na função está verificando se há primeiro, e no caso de um valor como false, ele não passa..

(defn meu-mapa
    [funcao sequencia]
    (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
        (do
            (funcao primeiro)
            (meu-mapa funcao (rest sequencia ))))))

(meu-mapa println ar)