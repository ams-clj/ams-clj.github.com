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

(defn gravatar [hash]
  (str "http://www.gravatar.com/avatar/" hash))

(def tracks
  [

   {:time "8:30"
    :title "Welcome, coffee, geek chats in the hallway"}
   
   {:name "Gijs Stuurman"
    :avatar (gravatar "e12be5f21fc3bd031442b8db500e82fc")
    :time "9:30"
    :title "Simpler webapps with Clojure"
    :abstract "Showing a small Ring webapp and how to test the Ring routes with Kerodon.

This practical subject will highlight the following points in Clojure: immutable data, composing functions, the threading macro."
    :bio "Coming soon"}

   {:name "Edoardo Causarano"
    :avatar (gravatar "1d775a2f4e6b149ece61d0a79016acc0")
    :time "10:15"
    :title "Baby steps with Clojure, for Java developers"
    :bio "Coming soon"}

   {:time "11:00"
    :title "Coffee break"}

   {:name "Joost Diepenmaat"
    :avatar (gravatar "76006c10b0773e69a6fcd70614ac258f")
    :time "11:15"
    :title "Functional Clojure: Sequences"
    :bio "Coming soon"}

   {:name "Michał Marczyk"
    :avatar (gravatar "0f3d9e9dc3fb2c846327aaf805f01773")
    :time "12:00"
    :title "Persistent data structures in ClojureScript"
    :bio "Coming soon"}

   {:time "12:45"
    :title "Free lunch offered by GOTO Conference"}

   {:time "14:00"
    :title "(Un)Conference"}

   {:name "Rodrigo B. Pimentel"
    :avatar (gravatar "3d8c280edaafd988742f45e81f89d24a")
    :time "15:30"
    :title "First steps to running Clojure on Google AppEngine"
    :abstract "Google App Engine makes it really easy to develop and deploy web applications.

We will show you how to get your Clojure web applications running on it, in simple terms. We will present a sample application to demonstrate howto use App Engine's services from Clojure."
    :bio "Coming soon"}

   {:name "Oleksandr Petrov"
    :avatar (gravatar "0895d796f866a9fc802350dbed192eb7")
    :time "16:15"
    :title "You and your system. Learning more about each other"
    :abstract "How do you aggregate metrics from your systems? Is it painful? 
How do you analyze the aggregated data? Isn't it even more painful?
How do you vizualize it? Well, that's something else, too.

I'm going to talk about not-yet-releazed project, started under Clojurewerkz.org, that's intended to solve forementioned problems, providing you with a set of tools to aggregate, analyze and visualize very large amounts arbitrary data (speak: terabytes) with ease, using only best tools for the job.

It's all written in Clojure, of course!  
"
    :bio "Coming soon"}

   {:time "17:00"
    :title "Coffee break"}

   {:name "Giacomo Cosenza"
    :avatar (gravatar "704b6c1c37067920186e3198b64f1ad5")
    :time "17:15"
    :title "Teaching Clojure to math grads"
    :bio "Coming soon"}

   {:name "Meikel Brandmeyer"
    :avatar "images/speakers/kotarak.png"
    :time "18:00"
    :title "Rocking the Gradle - with Clojure"
    :abstract "While leiningen is omni-present in the Clojure world, there are other build systems out there which are worth considering. Besides the “old ones” – ant and maven – there are also quite new systems. One of those is gradle.

We will explore the motivation for gradle, its aims and its philosophy, see a little bit of theory on how it works and finally build some examples in a live demonstration.
"
    :bio "I'm a mathematician using Clojure since early 2008. As an early adopter I became a clojure toolsmith working on the Vim integration – VimClojure – as well as the gradle plugin for Clojure – clojuresque. I try to help with common tooling like eg. <a href=\"https://github.com/clojure/tools.nrepl\">nrepl</a>."}
   
   ])

(defn track [{:keys [time name title abstract]} class]
  [:li {:class class}
   [:span {:class "time"} time]
   [:span {:class "slot"}
    (if name
      [:span {:style "border-bottom: 1px black dotted; cursor:help"
              :title abstract}
       title [:span {:style "float:right"} [:em name]]]
      title)]])

(defn speaker [{:keys [name avatar time title bio]} float]
  [:li
   [:div {:style "min-height: 100px; height: auto"}
    [:img {:style (str "float:" float "; margin: 5px")
           :src avatar}]
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