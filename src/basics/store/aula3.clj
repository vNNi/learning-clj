(ns store.aula3
    (:require [store.db :as db]))

(def pedidos-agrupados (group-by :usuario (db/todos-pedidos)))
(println pedidos-agrupados)
(println (vals pedidos-agrupados))
(map count (vals pedidos-agrupados))

(->> (db/todos-pedidos)
        (group-by :usuario)
        vals
        (map count)
        println) ;using thread last ->> to do the same from above

(defn total-do-item [[itemId detalhes]] (* (get detalhes :quantidade 0) (get detalhes :preco-unitario 0 )))

(defn total-do-pedido [pedido] (reduce + (map total-do-item pedido))) ;para cada item no pedido, calcular seu valor individual e retornar a soma de todos os itens de cada pedido

(defn total-dos-pedidos 
    [pedidos]
    (->> pedidos
        (map :itens) ;mapeamos a chave :itens para transformar seu valor em um array contendo os itens ({:mochila {:quantidade 1, :preco-unitario 2}, etc)
        (map total-do-pedido)))

(defn conta-total-por-usuario
    [[usuario pedidos]]
    {:id usuario, 
    :total-de-pedidos (count pedidos), ;count do array de pedidos
    :preco-total (reduce + (total-dos-pedidos pedidos)) ;calculamos o total dos pedidos de cada key
    })

(->> (db/todos-pedidos) ; thread last para executar funcoes na estrutua de dados "importada" de outro arquivo
    (group-by :usuario) ;agrupamos pela chave :usuário, transformando em um map com as keys :usuario e seus respectivos agrupamentos
    (map conta-total-por-usuario) ;aplicamos a funcao em cada key do mapa
    println)