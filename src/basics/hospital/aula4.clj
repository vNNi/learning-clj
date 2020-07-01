(ns hospital.aula4
    (:use [clojure pprint])
    (:require [hospital.model :as h.model]
              [hospital.logic :as h.logic]))

(defn chega-em-malvado [hospital pessoa]
    (swap! hospital h.logic/chega-em-pausado :espera pessoa)
    (println "apos inserir" pessoa))

;here has a use of retries in atoms context, which means, when the fuction change de atom, he is recalled with your param again.
(defn simula-um-dia-em-paralelo
[]
; MUITO CLARO o problema de variavel global (simbolo do namespace) compartilhado entre threads
(let [hospital (atom (h.model/novo-hospital))]
    (.start (Thread. (fn [] (chega-em-malvado hospital "111"))))
    (.start (Thread. (fn [] (chega-em-malvado hospital "222"))))
    (.start (Thread. (fn [] (chega-em-malvado hospital "333"))))
    (.start (Thread. (fn [] (chega-em-malvado hospital "444"))))
    (.start (Thread. (fn [] (chega-em-malvado hospital "555"))))
    (.start (Thread. (fn [] (chega-em-malvado hospital "666"))))
    (.start (Thread. (fn [] (Thread/sleep 4000)
                (pprint hospital))))))


(simula-um-dia-em-paralelo)
            