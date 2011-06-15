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

(defonce feed
  (memoize
   (fn []
     (reverse (parse-all-sources)))))

(defn render-item [item]
  [:li
   [:span.title (h (:title item))]
   " "
   [:span.date (h (str (:published-date item)))]
   [:div.contents
    (:value (first (:contents item)))]])

(defn render-feed []
  (html
   [:html
    [:head
     [:title title]
     (include-css "screen.css")]
    [:body
     [:h1 title]
     [:ol
      (map render-item (feed))]]]))

(defroutes public-routes
  (GET "/" []
       (render-feed))
  (compojure.route/not-found "duh.."))

(def app (-> public-routes (wrap-file "public") wrap-file-info))

(defn -main []
  (let [port (Integer/parseInt (get (System/getenv) "PORT" "8080"))]
    (run-jetty app {:port port})))