(ns hospital.aula3
    (:use [clojure pprint])
    (:require [hospital.logic :as h.logic])
    (:require [hospital.model :as h.model ]))



(defn testa-atomao []
    (let [hospital-vini (atom {:espera h.model/fila_vazia})]
        (pprint hospital-vini)
        (pprint @hospital-vini) ; take the value from atom reference
        (swap! hospital-vini assoc :laboratorio1 h.model/fila_vazia) ; this change the atom value from it reference
        (pprint @hospital-vini)
        ))

(testa-atomao)