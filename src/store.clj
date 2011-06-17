(ns store
  (:refer-clojure :exclude [get set])
  (:require [redis.core :as redis]))

(def redis-url (clojure.core/get (System/getenv) "REDISTOGO_URL" "redis://localhost:6379/"))

(def redis-server-spec
  (let [uri (java.net.URI. redis-url)
        [_ user password] (re-find #"(.*?):(.*)" (or (.getUserInfo uri) ""))]
    {:host (.getHost uri), :port (.getPort uri)
     :user user, :password password}))

(defn set [key val]
  (redis/with-server redis-server-spec
    (when (:password redis-server-spec)
      (redis/auth (:password redis-server-spec)))
    (redis/set (str key)
               (with-out-str (prn val)))))

(defn get [key]
  (redis/with-server redis-server-spec
    (when (:password redis-server-spec)
      (redis/auth (:password redis-server-spec)))
    (if-let [val (redis/get (str key))]
      (with-in-str val (read)))))
