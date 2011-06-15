(ns bot
  (:use [feedparser-clj.core]))

(def sources
  (map #(str "https://github.com/" % ".atom")
       ["adben"
        "beatlevic"
        "bulters"
        "gmodena"
        "joodie"
        "LaPingvino"
        "mdemare"
        "neotyk"
        "pepijndevos"
        "remvee"
        "rogier"
        "rosejn"
        "samaaron"
        "skuro"
        "Wijnand"]))

(defn parse-source [source]
  (let [feed (parse-feed source)]
    (map #(conj
           (select-keys % [:contents :link :published-date :title])
           [:author (-> % :authors first :name)])
         (:entries feed))))

(defn parse-all-sources []
  (sort-by :published-date (mapcat parse-source sources)))
