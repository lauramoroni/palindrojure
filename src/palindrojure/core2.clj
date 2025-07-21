(ns palindrojure.core2
   (:require [clojure.string :as str]))

(defn palindrome?
  "Checks if a given string is a palindrome."
  [word]
  (let [reversed-word (str/reverse (str/lower-case word))] 
    (= (str/lower-case word) reversed-word)))
    
(defn -main
  "Main function to test the palindrome function."
  [& args]
  
  (println "=== Palindrojure ===")
  (println " Palindrome Checker")

  (if (empty? args)
    (println "Please provide a word to check.")
    (doseq [word args]
      (println (str word " is a palindrome: " (palindrome? word))))))
