(ns hospital.aula1
    (:use [clojure pprint])
    (:require [hospital.model :as h.model]
              [hospital.logic :as h.logic]))
  
  (defn simula-um-dia []
    ; root binding
    (def hospital (h.model/novo-hospital))
    (def hospital (h.logic/chega-em hospital :espera "111"))
    (def hospital (h.logic/chega-em hospital :espera "222"))
    (def hospital (h.logic/chega-em hospital :espera "333"))
    ; funciona mas ja começamos a ter um treco no coração com
    ; esse simbolo global, com root binding sendo alterado a rodo
    (pprint hospital)
  
    (def hospital (h.logic/chega-em hospital :laboratorio1 "444"))
    (def hospital (h.logic/chega-em hospital :laboratorio3 "555"))
    (pprint hospital)
  
    (def hospital (h.logic/atende hospital :laboratorio1))
    (def hospital (h.logic/atende hospital :espera))
    (pprint hospital)
  
    (def hospital (h.logic/chega-em hospital :espera "666"))
    (def hospital (h.logic/chega-em hospital :espera "777"))
    (def hospital (h.logic/chega-em hospital :espera "888"))
    (pprint hospital)
    (def hospital (h.logic/chega-em hospital :espera "999"))
    (pprint hospital))
  
  ;(simula-um-dia)
  
  
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
