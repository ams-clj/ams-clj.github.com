(ns web
  (:use
   bot
   [hiccup.core]
   [hiccup.page-helpers]
   [compojure.core            :only [defroutes GET]]
   [ring.middleware.file      :only [wrap-file]]
   [ring.middleware.file-info :only [wrap-file-info]]))

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