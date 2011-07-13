(ns bot
  (:use [feedparser-clj.core])
  (:require [http.async.client :as c]
            [org.danlarkin.json :as json]))

(defn fetch-members
  []
  (with-open [client (c/create-client)]
    (let [response (c/GET client "https://github.com/api/v2/json/organizations/ams-clj/public_members")]
      (map :login (:users (json/decode (c/string response)))))))

(def members (atom (fetch-members)))

(def refresh-members (* 1 60 1000))

(defn members-updater
  []
  (Thread/sleep refresh-members)
  (reset! members (fetch-members))
  (recur))

(. (Thread. members-updater) start)

(def sources
  (map #(str "https://github.com/" % ".atom")
       @members))

(defn parse-source [source]
  (let [feed (parse-feed source)]
    (map #(conj
           (select-keys % [:contents :link :title])
           [:author (-> % :authors first :name)]
           [:published-date (.getTime (:published-date %))]) ; can't (print) and (read) java.util.Date objects
         (:entries feed))))

(defn parse-all-sources []
  (sort-by :published-date (mapcat parse-source sources)))
