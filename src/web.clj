(ns web
  (:use
   bot
   [hiccup.core]
   [hiccup.page-helpers]
   [compojure.core]
   [compojure.route]
   [ring.middleware.file]
   [ring.middleware.file-info]
   [ring.adapter.jetty]))

(def title "Amsterdam.CLJ!")

(def refresh-rate (* 15 60 1000))

(defn fetch-feed []
  (take 150 (reverse (parse-all-sources))))

(def feed (atom (fetch-feed)))

(defn feed-updater [_]
  (. Thread (sleep refresh-rate))
  (swap! feed (fn [_] (fetch-feed)))
  (send-off *agent* feed-updater))

(send-off (agent nil) feed-updater)

(defn render-item [item]
  [:li
   [:a.title {:href (h (:link item))} (h (:title item))]
   " "
   [:span.date (h (str (:published-date item)))]])

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

(defroutes public-routes
  (GET "/" []
       (render-feed))
  (compojure.route/not-found "duh.."))

(def app (-> public-routes (wrap-file "public") wrap-file-info))

(defn -main []
  (let [port (Integer/parseInt (get (System/getenv) "PORT" "8080"))]
    (run-jetty app {:port port})))