(ns store.db)

(def pedido1 {:usuario 15 
    :itens { :mochila {:id :mochila, :quantidade 2, :preco-unitario 10}
            :camiseta {:id :camiseta, :quantidade 3, :preco-unitario 40}
            :tenis {:id :tenis, :quantidade 1}}})

(def pedido2 {:usuario 15
    :itens { :mochila {:id :mochila, :quantidade 5, :preco-unitario 10}
            :camiseta {:id :camiseta, :quantidade 2, :preco-unitario 70}
            :tenis {:id :tenis, :quantidade 1}}})

(def pedido3 {:usuario 12
    :itens { :mochila {:id :mochila, :quantidade 5, :preco-unitario 10}
            :camiseta {:id :camiseta, :quantidade 2, :preco-unitario 70}
            :tenis {:id :tenis, :quantidade 1}}})

(defn todos-pedidos [] [pedido1, pedido2, pedido3])