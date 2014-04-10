; @title  default title
; @format xml

; //////////// FUNCTIONS //////////////////

(defn logo []
  [:div {:class "grid_4 header"}
   [:a {:href "/"}
    [:img {:src "/images/newflag.png"}]]])

(defn navigation-link
  [[text url selected]]
  (if selected
    [:a {:href url :title text :class "currentPage"} text]
    [:a {:href url :title text} text]))

(defn navigation-menu [links]
  [:div {:class "grid_8 header"}
   [:div {:id "navigation"}
    [:ul {:id "nav"} (for [[text url id selected] links]
                       [:li {:id id} (navigation-link [text url selected])])]
    [:div {:class "clear"}]]])

(defn page-footer [text]
  [:div {:class "footer"}
   [:div {:class "container_12 bottom"}

    [:br]

    [:div {:class "grid_4"}
     [:h3 "About"]
     [:p "Amsterdam Clojurians is the biggest Dutch community around Clojure. Out activities started back in September '09, and we pride ourselves to never have let a month go without our regular meetup ever since. We are a free group and we welcome everyone to come and enjoy his time with a bunch of Clojure enthusiasts."]]

    [:div {:class "grid_4"}
     [:a {:href "https://github.com/liquidz/misaki"} [:img {:src "/images/poweredby-misaki.png"}]]]

    [:div {:class "grid_4"}
     [:i "You can reach a point in LISP where you only write code that matters"]
     [:p {:style "text-align: right"} [:i "Rich Hickey"]]]

    [:br]
    [:div {:class "clear"}]
    text]
   [:br]])


(defn spacer []
  [:h3 "&nbsp;"])

; //////////// TEMPLATES //////////////////

[:html
 [:head
  [:meta {:charset (:charset site)}]
  [:meta {:name    "author"
          :content "Carlo Sciolla [credits to yourinspirationweb.com]"}]
  [:meta {:name    "description"
          :content "The Amsterdam Clojurians Meetup gathers the whole Dutch Clojure Community. Come to the meetup to chat and talk about every thing Clojure, functional programming, LISP and other topics. We have fun through presentations, code reading and mocking lesser languages."}]
  [:meta {:http-equiv "Content-Type"
          :content    "text/html; charset=utf-8"}]
  [:meta {:name    "keywords"
          :content "clojure, amsterdam, meetup, clj, dutch, netherlands, nederland, lisp, functional, programming, languages, developer, software, technology, group, event, talk, training, presentation"}]

  [:title
   (if (= (:title site) "home")
     (:site-title site)
     (str (:site-title site) " - " (:title site)))]

  [:link {:rel   "shortcut icon"
          :href  "/favicon.ico"}]

  [:link {:href  "/atom.xml"
          :rel   "alternate"
          :title (:title site)
          :type  "application/atom-xml"}]

  (absolute-css [(:css site)])
  (absolute-js [(:js site)])]
                                        ; /head

 [:body

  [:div {:class "container_12"}

                                        ; site logo
   (logo)

                                        ; main navigation menu
   (navigation-menu (map (fn [[text url id]]
                           ;(navigation-link [text url] (= text
                           ;(:title site)))
                           (if (or
                                (= text (:title site))
                                (and (= "blog" id) (= "true" (:isblog site))))
                             [text url id true]
                             [text url id false]))
                         [["Home Page"  "/" "home"]
                          ["Blog" "/blog.html" "blog"]
                          ["#OctAmsClj" "/october.html" "october"]
                          ["The Meetup" "http://www.meetup.com/The-Amsterdam-Clojure-Meetup-Group/" "about"]]))

   [:div {:class "clear"}]
   ]

  contents

  (page-footer "Copyright 2012 - 2014 by <strong>Amsterdam Clojurians</strong>")

  [:script {:type "text/javascript"}
   "var _gaq = _gaq || [];
      _gaq.push(['_setAccount', 'UA-32788361-1']);
      _gaq.push(['_setDomainName', 'amsclj.nl']);
      _gaq.push(['_setAllowLinker', true]);
      _gaq.push(['_trackPageview']);

      (function() {
      var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
      ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
      var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
      })();
"]


  ] ; /body

 ] ; /html
