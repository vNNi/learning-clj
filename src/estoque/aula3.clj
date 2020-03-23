(ns estoque.aula3)

(defn aplica-desconto?
    [valor-bruto]
    (> valor-bruto 100))

(println (aplica-desconto? 1000))

(defn valor-descontado
    "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
    [valor-bruto]
    (if (aplica-desconto? valor-bruto)
      (let [taxa-de-desconto (/ 10 100)
            desconto         (* valor-bruto taxa-de-desconto)]
        (println "Calculando desconto de " desconto)
        (- valor-bruto desconto))
      valor-bruto))

(valor-descontado 1000)

(valor-descontado 100)

(def precos [30 50 40 1000])

(def nprecos (conj precos 1000)) ; create new array adding new value, don't change de last one array

(println precos)
(println nprecos)

(println (update precos 1 inc)) ; update will exec the last param on the index you gave in your vector

(println (map valor-descontado precos )) ; pass in every value applying valor-descontado and return the values in a new array

(println (filter aplica-desconto? precos)) ; pass in every value applying aplica-desconto? and return to new array only values which returned true from aplica-desconto?


(println (reduce + proces)) ; pass in every item applying two params in the function (+) and use the result from that function in the next call with the next value in the vector :(+ arg1 arg2)
