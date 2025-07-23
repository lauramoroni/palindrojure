(ns palindrojure.core3
  (:gen-class))

(defn add
  "Cria uma função de ordem superior que soma n."
  [n]
  (fn [x]
    
    (println "-----------------------------------------")
    (println (str "|-> (add " n ") recebeu o valor: " x)) 
    (let [novo-valor (+ x n)] 
      (println (str "|   Calculando: " x " + " n " = " novo-valor))
      (println (str "|<- (add " n ") vai retornar o valor: " novo-valor))
      novo-valor)))

(defn mult
  "Calcula a * b compondo a função 'add' b vezes."
  [a b]
  (if (zero? b)
    0
    
    (let [multiplicador (apply comp (repeat b (add a)))] ;; cria a função composta

      (println "-----------------------------------------")
      (println (str "|-> (mult " a " " b ") vai aplicar a função composta: " multiplicador))
      (println (str "|-> (mult " a " " b ") vai receber o valor inicial: " 0))


      (let [resultado-final (multiplicador 0)]
        
        (println (str "|<- (mult " a " " b ") calculou o valor: " resultado-final))

        resultado-final))))


(defn -main
  [a b]
  (println (mult a b)))