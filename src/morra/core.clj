(ns morra.core
  (:gen-class))

(require '[clj-sockets.core :refer [close-socket write-line read-line listen create-server]])

(def server (listen (create-server 9871)))

(def data
  (atom
   {:player1-number 0
    :player1-sum 0
    :player2-number 0
    :player2-sum 0}))

(defn real-sum-players [data]
  (+
   (:player1-number data)
   (:player2-number data)))

(defn check-players [data]
  (prn (str "Player1 Number: " (:player1-number @data)))
  (prn (str "Player2 Number: " (:player2-number @data)))
  (prn (str "Player1 Sum: " (:player1-sum @data)))
  (prn (str "Player2 Sum: " (:player2-sum @data)))
  (prn (str "Real sum is: " (real-sum-players @data)))
  (when (= (:player1-sum @data) (real-sum-players @data))
    (prn "Player1 Wins!"))
  (when (= (:player2-sum @data) (real-sum-players @data))
    (prn "Player2 Wins!")))

(defn read-server [server]
  (int (read-string (read-line server))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (write-line server "Insert player1 number")
  (swap! data assoc :player1-number (read-server server))
  (write-line server "Insert player1 sum")
  (swap! data assoc :player1-sum (read-server server))
  (write-line server "Insert player2 number")
  (swap! data assoc :player2-number (read-server server))
  (write-line server "Insert player2 sum")
  (swap! data assoc :player2-sum (read-server server))
  (check-players data)
  )

