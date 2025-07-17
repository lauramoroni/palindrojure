(ns palindrojure.core
  (:gen-class))

(defn palindrome?
  "Check if a word is a palindrome."
  [word]
  ;; converte uma string em uma lista de caracteres (simula a fita).
  (let [tape (seq word)]
    (loop [current-tape tape]
      ;; teste: a fita é vazia?
      ;; se for, a palavra é aceita; se não, deve fazer mais uma verificação

      ; fita é vazia
      (if (<= (count current-tape) 1)
        true ; estado final: aceita

        ; fita não é vazia
        (let [start (first current-tape) ; 'lê valor' do início
              end    (last current-tape)]  ; 'lê valor' do final

          ;; teste: o valor do início e do final são iguais?
          (if (= start end)
            ;; se sim, 'escreve branco' e 'volta para o inicio da fita' são simulados
            (recur (-> current-tape rest butlast)) ; pega a fita sem o primeiro e o último valores

            ;; estado final: rejeita
            false))))))

(defn -main
  "Main function to palindrome checker"
  [& args]
  (println "=== Palindrojure ===\n Palindrome Checker\n")
  (println "Checking if" args "are palindromes...\n")

  (doseq [arg args]
    (if (palindrome? arg)
      (println (str "✅ '" arg "' is acceptable."))
      (println (str "❌ '" arg "' is rejected.")))))