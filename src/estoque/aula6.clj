(ns estoque.aul6)

(def pedido { :mochila {:quantidade 2, :valor 80}, :caneta { :quantidade 2, :valor 5 }, :brinde { :quantidade 1, :valor 0 } })

(defn imprime [[chave valor]]  ; here we can desctruct a vector/mapEntry with the key and value, or the first and second value inside the vector
    (println chave "<e>" valor))

(defn preco-dos-produtos [[_ valor]]
    (* (:quantidade valor) (:valor valor)))

(map imprime pedido)

(println (map preco-dos-produtos pedido))

(def somados (reduce + (map preco-dos-produtos pedido)))

(println somados)

(defn somados-thread-last [pedido]
    (->>                            ;here we use thread last, the argumento from last function in thread is passed as the last argument.
        pedido
        (map preco-dos-produtos) ; last argument to the map is pedido
        (reduce +)))            ; last argumento to reduce is the (map preco-dos-produtos pedido)

(println (somados-thread-last pedido))

(defn get-total-product-price [product]
    (* (:quantidade product) (:valor product)))


(defn somados-thread-last-2 [pedido]
    (->>                            ;here we use thread last, the argumento from last function in thread is passed as the last argument.
        pedido
        vals                        ; here we take the values from the map, removing the keys and pass to map
        (map get-total-product-price) ; last argument to the map is pedido
        (reduce +)))            ; last argumento to reduce is the (map preco-dos-produtos pedido)

(println (somados-thread-last-2 pedido))

(defn free? 
    [item]
    (<= (:valor item) 0))

(defn filter-free-values [pedido]
    (->> 
        pedido
        vals
        (filter free?)))

(defn free-with-destruct? 
    [[key value]] ;destruct the map array.
    (<= (get value :valor 0) 0))

(println (filter-free-values pedido))
(println (filter free-with-destruct? pedido)) ; this dont need to use vals to take access to second value on the MapEntry

(println (filter (fn [[_ value]] (free? value)) pedido)) ; here we use a lambda/anonymous function to desctruct the map and pass the value to free function based in each pedido key of the map

(defn installment? 
    [item]
    (not (free? item))) ;reverse the result from free? function

(def installment2? (comp not free?)) ;here we just define, not define function, a symbol who composite the not and free? function using the argument passed with the symbol

(println (filter (fn [[_ value]] (installment? value)) pedido))

(println (filter (fn [[_ value]] (installment2? value)) pedido))