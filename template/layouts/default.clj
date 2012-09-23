; @title  default title
; @format xml

; //////////// FUNCTIONS //////////////////

(defn logo []
  [:div {:class "grid_4 header"}
   [:a {:href "/"}
    [:img {:src "images/newflag.png"}]]])

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
  [:div {:class "container_12"}
   [:p {:class "footer"}
    text
    [:br]]])


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
                           (if (= text (:title site))
                             [text url id true]
                             [text url id false]))
                         [["Home Page"  "/" "home"]
                          ["#OctAmsClj" "/october.html" "october"]
                          ["The Meetup" "http://www.meetup.com/The-Amsterdam-Clojure-Meetup-Group/" "about"]
                          ["Contact"    "mailto:amsterdam-clojurians@googlegroups.com" "contact"]]))

   [:div {:class "clear"}]
   ]

  contents
  
  (page-footer "Copyright 2012 - 2013 by <strong>Amsterdam Clojurians</strong>")
  
  
  ] ; /body

 ] ; /html
