 
 

(defn pivot [[currname & othernames :as names]]
  (loop [pv currname
        on othernames
        cnt (count names)
        acc (conj 
                  (mapv #(str pv " " %) on)
            (str pv))]
        (if (zero? cnt)
          acc
          (let [remainingnames (rest on)
            newpv (first on)
                ]
          (recur newpv
                remainingnames
                (count remainingnames) 
                (into acc 
                      (conj (mapv #(str newpv " " %) remainingnames)
                      (str newpv))))
        ))))

(defn runme [namen]
(let [fullname (clojure.string/split namen #" ")
      [fname & othern :as names] fullname
      lname (last othern)
      firstandlast (str fname " " lname)
      middlenames (vec (drop-last othern))
      allcombinationsmiddlenames (pivot middlenames)
      ]
     (conj 
      (if (<= (count middlenames) 2) 
      (mapv #(str fname " " %  " " lname)   
          middlenames)
      (mapv #(str fname " " %  " " lname)   
          allcombinationsmiddlenames))
      (str firstandlast)
      (str fname " " (clojure.string/join " " othern))
             ))
)

(runme "A B C D E F")