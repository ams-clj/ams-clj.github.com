(ns bot
  (:use [feedparser-clj.core]))

(def sources ["https://github.com/joodie.atom", "http://blog.remvee.net/rss.xml"])

(defn parse-source [source]
  (let [feed (parse-feed source)]
    (map #(select-keys % [:contents :link :published-date :title]) (:entries feed))))

(defn parse-all-sources []
  ())
