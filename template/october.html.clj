; @layout default
; @title #OctAmsClj
; @format xml

; //////////// FUNCTIONS //////////////////

(defn arrow [direction]
  [:a {:href "#"}
   [:img {:src (str "images/featured-arrow-" direction ".png")
          :alt ""}]])

(defn panel [{:keys [link title img alt body]} & panel-body]
  [:div {:class "panel"}

   [:div {:class "projectImage"}
    [:a {:href link
         :title title}
     [:img {:src img
            :alt alt}]]]

   [:div {:class "projectDescription"}
    panel-body]])

(defn script [src]
  [:script {:src src
            :type "text/javascript"}])

(defn button [href src title alt]
  [:a {:href href
        :title title}
    [:img {:src src
           :alt alt}]])

(def tracks
  [

   {:time "8:30"
    :title "Welcome, coffee, geek chats in the hallway"}
   
   {:name "Gijs Stuurman"
    :avatar "e12be5f21fc3bd031442b8db500e82fc"
    :time "9:30"
    :title "Simpler webapps with Clojure"
    :abstract "Showing a small Ring webapp and how to test the Ring routes with Kerodon. This practical subject will highlight the following points in Clojure: immutable data, composing functions, the threading macro."
    :bio "Hi, I'm Gijs Stuurman, a Clojure programmer from the Netherlands. I'm looking for Clojure work!"}

   {:name "Edoardo Causarano"
    :avatar "1d775a2f4e6b149ece61d0a79016acc0"
    :time "10:15"
    :title "Baby steps with Clojure, for Java developers"
    :abstract ""
    :bio "TBD"}

   {:time "11:00"
    :title "Coffee break"}

   {:name "Joost Diepenmaat"
    :avatar "76006c10b0773e69a6fcd70614ac258f"
    :time "11:15"
    :title "Functional Clojure: Sequences"
    :abstract ""
    :bio "Joost Diepenmaat focuses on developing web applications in Perl and Java, as an independent developer / consultant and freelance."}

   {:name "Michał Marczyk"
    :avatar "0f3d9e9dc3fb2c846327aaf805f01773"
    :time "12:00"
    :title "Persistent data structures in ClojureScript"
    :abstract ""
    :bio "Michał Marczyk is a researcher in logic / universal algebra in Kraków, Poland, always trying to coerce the computer into proving his theorems for him. His programming background is predominantly in functional programming; mostly in Scheme, Haskell and Clojure, which is rapidly becoming his favourite language."}

   {:time "12:45"
    :title "Lunch break"}

   {:time "14:00"
    :title "(Un)Conference"}

   {:name "Rodrigo B. Pimentel"
    :avatar "3d8c280edaafd988742f45e81f89d24a"
    :time "15:30"
    :title "First steps to running Clojure on Google AppEngine"
    :abstract ""
    :bio "I am a Free Software developer and enthusiast, a Python programmer, and currently an MSc. student. I also like to cook from time to thyme"}

   {:name "Oleksandr Petrov"
    :avatar "0895d796f866a9fc802350dbed192eb7"
    :time "16:15"
    :title "You and your system. Learning more about each other"
    :abstract ""
    :bio "Software quality freak. Ruby / Clojure / C hacker. @clojurewerkz core team. Mostly distributed."}

   {:time "17:00"
    :title "Coffee break"}

   {:name "Giacomo Cosenza"
    :avatar "704b6c1c37067920186e3198b64f1ad5"
    :time "17:15"
    :title "Teaching Clojure to math grads"
    :abstract ""
    :bio "CEO of Sinapsi S.p.A., system integrator which pioneered in free software diffusion in Italian large companies"}

   {:name "Meikel Brandmeyer"
    :avatar "5db30f607f0b5fa70d690311aa3bfd3b"
    :time "18:00"
    :title "Rocking the Gradle - with Clojure"
    :abstract ""
    :bio "I'm a clojure toolsmith and hobbyist. Occasionally I blog about Clojure or release my software concoctions to the clojure ecosphere."}
   
   ])

(defn track [{:keys [time name title]} class]
  [:li {:class class}
   [:span {:class "time"} time]
   [:span {:class "slot"} (if name [:em (str name "&nbsp;-&nbsp;")]) title]])

(defn gravatar [hash]
  (str "http://www.gravatar.com/avatar/" hash))

(defn speaker [{:keys [name avatar time title bio]} float]
  [:li
   [:div {:style "min-height: 100px; height: auto"}
    [:img {:style (str "float:" float "; margin: 5px")
           :src (gravatar avatar)}]
    [:h4 name]
    [:p bio]
    [:p "&nbsp;"]]
   [:hr]])

;///////////// TEMPLATE //////////////////

[:div {:class "container_12 medium"}
 [:div {:id "featured"}
  [:div {:id "stripNavL0"
         :class "featured-arrow"}
   (arrow "left")]
  
   ; start the carousel
  [:div {:id "slider"}
   [:div {:id "sliderc"
          :class "csw"}
    [:div {:class "panelContainer"}

     (panel {:link  "http://www.meetup.com/The-Amsterdam-Clojure-Meetup-Group/"
             :title "Meetup Page"
             :img   "images/oct-logo.png"
             :alt   "Official Meetup.com page"}
            [:h1 "THE DUTCH Clo" [:i "j"] "ure EVENT"]
            [:p [:span {:class "orange"} "October Amsterdam Clojure"]
             " is the Dutch stage for functional geeks, lots of parenthesis and fun, all in a spicy "
             [:span {:class "orange"} "LISP"] " sauce! The 2012 edition will be held at Backbase Headquarters in Amsterdam on " [:span {:class "orange"} "Saturday October 27th."]
             [:p "The event is always " [:span {:class "orange"} "FREE"]]])

     (panel {:link  "http://www.backbase.com/contact/DIRECTIONS-backbase-INIT.pdf"
             :title "HOW TO JOIN"
             :img   "images/map.png"
             :alt   "The biggest Clojure event in the Netherlands"}
            [:h1 "HOW TO JOIN"]
            [:p "The event is completely " [:span {:class "orange"} "free"] " for anyone to join. Unfortunately, space limitations requires us to ask you to sign up. The official registration form will soon be available on our " [:span {:class "orange"} "Meetup"] " page."
             [:br]
             "Be sure to book your seat or you'll seriously risk to miss the hottest event this fall!"]
            [:p {:class "Desc"}
             [:span {:class "site"}
              [:a {:href "http://www.backbase.com/contact/DIRECTIONS-backbase-INIT.pdf"}
               "Directions to the venue"]]])

     ]]]

  [:div {:id "stripNavR0"
         :class "featured-arrow"}
   (arrow "right")]]]

[:div {:class "container_12 bottom"}

 [:div {:class "grid_8"}
  [:h2 "The " [:span {:class "orange"} "program"]]
  [:p]
  [:ul {:class "program"}
   (map #(track %1 %2) tracks (cycle ["dark" "light"]))]
  [:p]
  [:h2 "The " [:span {:class "orange"} "speakers"]]
  [:p]
  [:ul {:class "program"}
   (map #(speaker %1 %2) (filter :name tracks) (cycle ["left" "right"]))]]
 
 [:div {:class "grid_4"}
  [:p "Sponsored " [:span {:class "orange"} "by"]]
  (spacer)
  (button "http://www.backbase.com"
          "images/sponsors/backbase.png"
          "Backbase"
          "NextGen Portal Software")
  (spacer)
  (button "http://gotocon.com/amsterdam-2013/"
          "images/sponsors/goto.png"
          "GOTO Conference"
          "GOTO Conference Amsterdam 2013")
  (spacer)
  (button "http://www.oreilly.com"
           "http://ug.oreilly.com/banners/ug_ad_250_viguy.gif"
           "O'Reilly Network"
           "")
  ]

 [:div {:class "clear"}]]
