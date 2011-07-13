(ns web
  (:use [bot]
        [hiccup.core]
        [hiccup.page-helpers]
        [compojure.core]
        [compojure.route]
        [ring.middleware.file]
        [ring.middleware.file-info]
        [ring.adapter.jetty])
  (:require [store :as store]))

(def title "Amsterdam.CLJ!")

(defmacro ignore-exceptions [& body]
  `(try (do ~@body) (catch Exception ~'_)))

(def refresh-rate (* 15 60 1000))

(defn fetch-feed []
  (take 150 (reverse (parse-all-sources))))

(def feed (atom (or
                 ;;(store/get :feed)
                 false
                 (take 150 (reverse (parse-all-sources))))))

(defn feed-updater [_]
  (ignore-exceptions (swap! feed (fn [_] (fetch-feed))))
  (ignore-exceptions (store/set :feed @feed))
  (. Thread (sleep refresh-rate))
  (send-off *agent* feed-updater))

(send-off (agent nil) feed-updater)

(defn render-item [item]
  [:li
   [:a.title {:href (h (:link item))} (h (:title item))]
   " "
   [:span.date (h (str (java.util.Date. (:published-date item))))]])

(defn render-feed []
  (html
   [:html
    [:head
     [:title title]
     (include-css "screen.css")]
    [:body
     [:h1 title]
     [:ol
      (map render-item @feed)
      [:li [:em "etcetera etcetera.."]]]]]))

(defroutes handler
  (GET "/" [] (render-feed))
  (compojure.route/not-found "duh.."))

(defn wrap-errors [app]
  (fn [req] (try (app req)
                 (catch Exception e
                   (do
                     (prn req) (.printStackTrace e)
                     {:status 500, :body "auch!"})))))

(def app (-> handler (wrap-file "public") wrap-file-info wrap-errors))

(defn -main []
  (let [port (Integer/parseInt (get (System/getenv) "PORT" "8080"))]
    (run-jetty (var app) {:port port :join? false})))
