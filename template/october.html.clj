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

(defn orange [text]
  [:span {:class "orange"} text])

(def tracks
  [

   {:time "8:30"
    :title "Welcome, coffee, geek chats in the hallway"}
   
   {:name "Gijs Stuurman"
    :avatar "images/speakers/gijs.png"
    :time "9:30"
    :title "Simpler webapps with Clojure"
    :abstract "An introduction to Clojure using web programming as an example. Will show how the abstractions and philosophies of Clojure can be combined to build and test software."
    :bio "Got started with Clojure by using it for the software for my Master thesis. Now a full-time Clojure programmer at a start-up."}

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
    :abstract "One of the fundamental abstractions in Clojure is the sequence. This
talk introduces the sequence abstraction and some of the very useful
functional idioms in the Clojure core library that are based on it."
    :bio "Joost is a freelance software developer based in Utrecht, the
Netherlands, who is interested in functional programming techniques as
a way of maintaining clarity while growing systems. He's currently
working for a number of clients building high-traffic, web-based
systems in Clojure and Ruby. He's also got a very nice apartment in
Utrecht for sale."}

   {:name "Michał Marczyk"
    :avatar (gravatar "0f3d9e9dc3fb2c846327aaf805f01773")
    :time "12:00"
    :title "Persistent data structures in ClojureScript"
    :bio "Coming soon"}

   {:time "12:45"
    :title "Free lunch offered by GOTO Conference"}

   {:time "14:00"
    :title "(Un)Conference"}

   {:name "Meikel Brandmeyer"
    :avatar "images/speakers/kotarak.png"
    :time "15:30"
    :title "Rocking the Gradle - with Clojure"
    :abstract "While leiningen is omni-present in the Clojure world, there are other build systems out there which are worth considering. Besides the “old ones” – ant and maven – there are also quite new systems. One of those is gradle.

We will explore the motivation for gradle, its aims and its philosophy, see a little bit of theory on how it works and finally build some examples in a live demonstration.
"
    :bio "I'm a mathematician using Clojure since early 2008. As an early adopter I became a clojure toolsmith working on the Vim integration – VimClojure – as well as the gradle plugin for Clojure – clojuresque. I try to help with common tooling like eg. <a href=\"https://github.com/clojure/tools.nrepl\">nrepl</a>."}

   {:name "Oleksandr Petrov"
    :avatar "images/speakers/apetrov.png"
    :time "16:15"
    :title "You and your system. Learning more about each other"
    :abstract "Both infrastructure and application that runs on it are beautiful, and you know it. But do you know everything about them? Do you have a centralized storage of events that occur there? Can you correlate conversion and number of visitors with CPU peaks? Or plan an amount of hardware you'll require to run your service in a month, or even a year? Get all that data, and start making sense of it by using a very simple toolchain."
    :bio "Alex works for StyleFruits, a leading platform for mode in Germany, before that was developing software to manage payment terminals, gates in airport areas and business centers. With Clojure for about 1 year, but fell in love with it from the day one, and found ClojureWerkz together with Michael Klishin, a collection of Clojure libraries, each one of which just werkz. Also, writes boring bio blurbs for conferences.
"}

   {:time "17:00"
    :title "Coffee break"}

   {:name "Rodrigo B. Pimentel / Chris Wilson"
    :avatar "images/speakers/rbp-chris.png"
    :time "17:15"
    :title "First steps to running Clojure on Google AppEngine"
    :abstract "Google App Engine makes it really easy to develop and deploy web applications.

We will show you how to get your Clojure web applications running on it, in simple terms. We will present a sample application to demonstrate howto use App Engine's services from Clojure."
    :bio "Chris is something of a generalist, having worked in various fields -
from IT teacher in a prison to senior development positions in banking
and aerospace. Chris has been using Clojure on and off in personal
projects for a couple of years.
<br /><br />
Rodrigo has been doing a lot of Python stuff for the last 8 years. He
got his M.Sc. in mobile localisation, and is now studying simultaneous
localisation and mapping. Rodrigo has played around with functional
languages before, and has recently started on Clojure.
<br /><br />
Chris and Rodrigo are currently both core developers at Hyves"}

   {:time "18:00"
    :title "Closing, goodbye kisses and hugs"}
      
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
             [:span {:class "orange"} "LISP"] " sauce! The 2012 edition will be held at Backbase Headquarters in Amsterdam on " [:span {:class "orange"} "Saturday October 27th. "]
             [:p {:class "Desc"}
              [:span {:class "site"}
               [:a {:href "http://bit.ly/octamsclj-register"}
                "Book your seat (for FREE!)"]]
              [:span "&nbsp;&nbsp;&nbsp;&nbsp;"]
              [:span {:class "site"}
               [:a {:href "http://www.backbase.com/contact/DIRECTIONS-backbase-INIT.pdf"}
                "Directions to the venue"]]]])
     
     (panel {:link  "http://www.backbase.com/contact/DIRECTIONS-backbase-INIT.pdf"
             :title "HOW TO JOIN"
             :img   "images/map.png"
             :alt   "The biggest Clojure event in the Netherlands"}
            [:h1 "HOW TO JOIN"]
            [:p "The event is completely " [:span {:class "orange"} "FREE"] " for anyone to join. Unfortunately, space limitations requires us to ask you to sign up. The official registration form will soon be available on our " [:span {:class "orange"} "Meetup"] " page."
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

  [:a {:href "images/OctAmsClj12-big.png"}
   [:img {:src "images/OctAmsClj12.png"}]]
  
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
  (button "http://www.adgoji.com/"
          "images/sponsors/adgoji.png"
          "ADGOJI"
          "ADGOJI Mobile Audience Targeting")
  (spacer)
  (button "http://www.oreilly.com"
           "http://ug.oreilly.com/banners/ug_ad_250_viguy.gif"
           "O'Reilly Network"
           "")

  
  ]

 [:div {:class "clear"}]]