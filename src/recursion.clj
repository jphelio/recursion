(ns recursion)

(defn product [coll]
  (if (empty? coll) 1 (if (== (count coll) 1) (first coll) (* (first coll) (product (rest coll))))))

;    (product '(1 2 3))
;=   (product (cons 1 (cons 2 (cons 3 '()))))
;=> (* 1 (product (cons 2 (cons 3 '()))))
;=> (* 1 (* 2 (product (cons 3 '()))))
;=> (* 1 (* 2 (3)))
;=> (* 1 (* 2 3))
;=> (* 1 6)
;=> 6

(defn singleton? [coll]
  (if (empty? coll) false (if (empty? (rest coll)) true false)))

(defn my-last [coll]
  (if (empty? coll) nil (if (singleton? coll) (first coll) (my-last (rest coll)))))

(defn max-element [a-seq]
  (if (empty? a-seq) nil (if (singleton? a-seq) (first a-seq) (max (first a-seq) (my-last (rest a-seq))))))

(defn seq-max [seq-1 seq-2]
  (if (< (count seq-1) (count seq-2)) seq-2 (if (== (count seq-1) (count seq-2)) seq-2 seq-1)))

(defn longest-sequence [a-seq]
  (if (empty? a-seq) nil (if (singleton? a-seq) (first a-seq) (seq-max (first a-seq) (my-last (rest a-seq))))))

(defn my-filter [pred? a-seq]
  (if (empty? a-seq) a-seq (if (not (pred? (first a-seq)))
                             (my-filter pred? (rest a-seq))
                             (cons(first a-seq) (my-filter pred? (rest a-seq))))))

(defn sequence-contains? [elem a-seq]
  (cond
   (empty? a-seq)
     false
   (== (first a-seq) elem)
     true
   :else
     (sequence-contains? elem (rest a-seq))))

(defn my-take-while [pred? a-seq]
  (cond
   (empty? a-seq)
     ()
   (pred? (first a-seq) )
     (cons (first a-seq) (my-take-while pred? (rest a-seq)))
   :else
     ()))

(defn my-drop-while [pred? a-seq]
  (cond
   (empty? a-seq)
     a-seq
   (pred? (first a-seq))
      (my-drop-while pred? (rest a-seq))
   :else
     a-seq))

(defn seq= [a-seq b-seq]
  (cond
   (and (not(empty? a-seq)) (empty? b-seq)) false
   (and (not(empty? b-seq)) (empty? a-seq)) false
   (and (empty? a-seq) (empty? b-seq)) true
   (== (first a-seq) (first b-seq)) (seq= (rest a-seq) (rest b-seq))
   :else false))


(defn my-map [f seq-1 seq-2]
  (cond
   (empty? seq-1)
     ()
   (empty? seq-2)
     ()
   :else
     (cons (f (first seq-1) (first seq-2)) (my-map f (rest seq-1) (rest seq-2)))))

(defn power [n k]
  (if (zero? k) 1 (* n (power n (dec k)))))

(defn fib [n]
  (if(== n 0) 0 (if(== n 1) 1 (+ (fib (- n 2)) (fib (dec n))))))

(defn my-repeat [how-many-times what-to-repeat]
  (if (<= how-many-times 0) () (cons what-to-repeat (my-repeat (dec how-many-times) what-to-repeat))))

(defn my-range [up-to]
  (if (== up-to 0) () (cons (dec up-to) (my-range (dec up-to)))))

(defn tails [a-seq]
  (if (empty? a-seq)
    (cons () ())
    (cons (reverse (reverse a-seq)) (tails (rest a-seq)))))

(defn inits [a-seq]
  (reverse (map reverse (tails (reverse a-seq)))))

 (defn rotations-helper [a-seq b-seq]
  (if (empty? b-seq)
    '()
    (cons (concat b-seq a-seq)
          (rotations-helper (concat a-seq (seq [(first b-seq)])) (rest b-seq)))))

(defn rotations [a-seq]
  (if (empty? a-seq)
    '(())
    (rotations-helper '() a-seq)))


(defn my-frequencies-helper [freqs a-seq]
  (if (empty? a-seq)
    freqs
    (let [eka (first a-seq)
          freq (if (nil? (freqs eka)) 0 (freqs eka))]
      (my-frequencies-helper (assoc freqs eka (inc freq))
                             (rest a-seq)))))

(defn my-frequencies [a-seq]
  (my-frequencies-helper {} a-seq))


(defn un-frequencies [a-map]
  [:-])

(defn my-take [n coll]
  [:-])

(defn my-drop [n coll]
  [:-])

(defn halve [a-seq]
  [:-])

(defn seq-merge [a-seq b-seq]
  [:-])

(defn merge-sort [a-seq]
  [:-])

(defn split-into-monotonics [a-seq]
  [:-])

(defn permutations [a-set]
  [:-])

(defn powerset [a-set]
  [:-])







