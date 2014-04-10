; @layout landing
; @title #OctAmsClj

; sets up the carousel, overrides the one in landing.clj:
(defn header-elems []
  [{:image {:link  "http://www.meetup.com/The-Amsterdam-Clojure-Meetup-Group/"
             :title "Meetup Page"
             :img   "images/oct-logo.png"
             :alt   "Official Meetup.com page"}
    :content [:span
              [:h1 "THE DUTCH Clo" [:i "j"] "ure EVENT"]
              [:p [:span {:class "orange"} "October Amsterdam Clojure"]
               " is the Dutch stage for functional geeks, lots of parenthesis and fun, all in a spicy "
               [:span {:class "orange"} "LISP"] " sauce! "
               [:p "As of 2013, it is known as " [:a {:href "http://dutch.clojuredays.nl/"} "Dutch Clojure Days"]]
               [:p {:class "Desc"}]]]}

   {:image {:link  "http://www.backbase.com/contact/DIRECTIONS-backbase-INIT.pdf"
             :title "HOW TO JOIN"
             :img   "images/map.png"
             :alt   "The biggest Clojure event in the Netherlands"}
    :content [:span
              [:h1 "HOW TO JOIN"]
              [:p "The event is completely " [:span {:class "orange"} "FREE"] " for anyone to join. Follow the news at " [:a {:href "http://dutch.clojuredays.nl/"} "Dutch Clojure Days"] " or on " [:a {:href "http://twitter.com/dcdnl"} "Twitter"] " to get notified of the next event."]
              [:p {:class "Desc"}
               [:span {:class "site"}
                [:a {:href "http://dutch.clojuredays.nl/"}
                 "Dutch Clojure Days"]]]]}])

; //////////// TEMPLATES //////////////////

[:div {:class "container_12 bottom"}

 [:div {:class "grid_4" :style "float: right"}
  [:a {:class "twitter-timeline" :href "https://twitter.com/amsclj" :data-widget-id "389666614846582784"} "Tweets by @amsclj"]
  [:script "!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document,'script','twitter-wjs');"]]

 [:div {:class "grid_8"}
  [:h2 "Dutch " [:span {:class "orange"} "Clojure Days"]]
  [:a {:href "http://dutch.clojuredays.nl/"} [:img {:src "/images/dcdnl13.png" :style "float:right" :alt "Dutch Clojure Days 2013"}]]
  [:p "Starting with 2013, the Amsterdam Clojurians and " [:a {:href "http://www.ehrdclj.org/"}]
   " joined forces to boost up the organization of our yearly conference, aiming at being the best European free event on Clojure. You can read more about it at the "
   [:a {:href "dutch.clojuredays.nl"} "Dutch Clojure Days"] " main site."]]

 [:div {:class "grid_8"} "&nbsp;"]

 [:div {:class "grid_8" :style "align: center"}
  [:h2 "Past " [:span {:class "orange"} "events"]]
  [:a {:href "/october-2012.html"} [:img {:src "/images/OctAmsClj12.png"}]]
  [:a {:href "http://www.meetup.com/The-Amsterdam-Clojure-Meetup-Group/events/33351892/"} [:img {:src "/images/OctAmsClj11.png"}]]
  ]

 [:div {:class "clear"}]]
