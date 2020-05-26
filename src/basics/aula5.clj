(ns estoque.aula5)

(def estoque { "Mochila" 10, "Lapis" 2 })

(println (keys estoque)) ;return the keys from the hash/map

(println (count estoque)) ; return the 'length'

(def estoques2 { :mochila 10, :lapis 5 })

(println (keys estoques2))

(println (assoc estoques2 :caneta 1)) ; return a map afeter add a key and value

(println (update estoques2 :lapis inc)) ; apply a function in the key(index) and return a new map

; #(- % 3)  == lambda function should apply minus (-) in the first arg with 3

(println (dissoc estoques2 :lapis )) ; remove the key in the map and return a new one.

(def pedido { :mochila {:quantidade 2, :valor 80}, :caneta { :quantidade 2, :valor 5 }})

(println pedido)

(println (pedido :mochila)) ; access :mochila key, but this can break if pedido is nil

(println (:mochila pedido {})) ; access :mochila key but dont throw exception if pedido is nil

(println (get pedido :mochila {})); access :mochila with get function

(println (:quantidade (:mochila pedido {}))) ;here we can access deep keys inside a map but this can be verbose

(println (-> pedido :mochila :quantidade )) ;here we can access deep keys with "THREADING ->"

(println (update-in pedido [:mochila :quantidade] inc)) ;update deep keys inside a map with update-in => print mochila with quantidade +1