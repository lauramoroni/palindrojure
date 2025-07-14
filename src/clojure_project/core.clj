(ns clojure-project.core
   (:require [clojure.string :as str]
             [clojure.test :refer [is]])
   (:gen-class))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
 ;; 1. DEFINIÇÕES BÁSICAS (Variáveis e Funções)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

 (def GLOBAL_MESSAGE "Welcome to the Clojure tutorial!")

 (defn print-hello
   "Create a simple function to say hello."
   [name]
   (let [greetings "Hello "
         name-formatted (str/capitalize name)]
     (str greetings ", " name-formatted "!")))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
 ;; 2. ESTRUTURAS DE DADOS
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

 (def numbers [1 2 3 4 5])
 (def user {:id 101
            :name "Ana"
            :interests #{"Leitura" "Música"}})
 (def task-list '("Comprar pão" "Estudar Clojure"))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
 ;; 3. PROGRAMAÇÃO FUNCIONAL
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

 (defn functional-demo
   "Demonstrate basic functional programming concepts. Mainly using map, filter, and threading."
   []
   (println "--- Functional Demo ---")
   (let [doubled (map #(* % 2) numbers)]
     (println "Doubled numbers:" doubled))

   (let [even (filter even? numbers)]
     (println "Even numbers:" even))

   (let [first-interest (-> user
                            :interests
                            first
                            str/upper-case)]
     (println "First interest (uppercase):" first-interest))

   (let [first-task (-> task-list
                        first
                        str/upper-case)]
     (println "First task (uppercase):" first-task)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
 ;; 4. MANIPULAÇÃO DE STRINGS
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

 (defn string-manipulation
   "Demonstrates basic string manipulation functions."
   [sentence]
   (println "\n--- String ---")
   (println "Original:" sentence)
   (let [words (str/split sentence #" ")]
     (println "Splited words:" words)
     (println "Joined with dash:" (str/join "-" words)))
   (println "Uppercase:" (str/upper-case sentence))
   (println "Lowercase:" (str/lower-case sentence))
   (println "Is the string blank?" (str/blank? sentence))
   (println "String trimmed:" (str/trim "  espaços  "))
   (println "Starts with 'clojure'?" (str/starts-with? sentence "clojure")))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
 ;; 5. ESTADO E CONCORRÊNCIA (Átomos)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

 (def counter (atom 0))

 (defn counter-plus
   "Increments the atom 'counter' safely."
   []
   (swap! counter inc))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
 ;; 6. TESTES
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

 (defn sum [a b] (+ a b))
 (defn isPositive [n] (pos? n))
 (defn isZero [n] (zero? n))

 (defn run-tests
   "Executa algumas asserções de teste usando a macro 'is'."
   []
   (println "\n--- Tests ---")
   (is (= (sum 2 3) 5) "Correct")
   (is (= (sum 2 3) 6) "Incorrect")
   (is (= (:name user) "Ana"))
   (is (isPositive 5) "5 is positive")
   (is ((isPositive -7)) "-7 is not positive")
   (is (isZero 0) "0 is zero")
   (is ((isZero 5)) "5 is not zero")
   (is (= (str/split "My 1st Clojure string" #" ") ["My" "1st" "Clojure" "string"]) "String split correctly")
   (println "Finalizing tests..."))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
 ;; 7. FUNÇÃO PRINCIPAL (-main)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

 (defn -main
   "I don't do a whole lot ... yet."
   [& args]
   (println GLOBAL_MESSAGE)
   (println (print-hello "mundo"))

   (functional-demo)

   (string-manipulation "Clojure é uma linguagem poderosa")

   (println "\n--- Atom ---")
   (println "Initial counter:" @counter)
   (counter-plus)
   (counter-plus)
   (println "Final counter:" @counter)

 (run-tests))
