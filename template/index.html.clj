; @layout landing
; @title Home Page

; //////////// FUNCTIONS //////////////////

(defn- rss-widget []
  (slurp "public/js/rss.js"))

; sets up the carousel, overrides the one in landing.clj:
(defn header-elems []
  [{:image {:link  "http://www.meetup.com/The-Amsterdam-Clojure-Meetup-Group/"
            :title "Meetup Page"
            :img   "images/slider/00x.jpg"
            :alt   "Official Meetup.com page"}
    :content [:span
              [:h1 "THE DUTCH Clo" [:i "j"] "ure COMMUNITY"]
              [:p [:a {:href "http://clojure.org"
                       :alt "Clojure official website"}
                   "Clo" [:i "j"] "ure "]
               "brings up the fun in functional programming languages. We  meet every second Wednesday of the month to talk about every thing Clo<i>j</i>ure, sometimes giving presentations, sometimes just having fun together."]
              [:p {:class "Desc"}
               [:span {:class "site"}
                [:a {:href "http://www.meetup.com/The-Amsterdam-Clojure-Meetup-Group/"}
                 "Meetup.com Page"]]]]}

   {:image {:link  "/october.html"
             :title "October Amsterdam Clojure"
             :img   "images/slider/001.jpg"
            :alt   "The biggest Clojure event in the Netherlands"}
    :content [:span
              [:h1 "October Amsterdam Clojure"]
              [:p "Every year around October we celebrate yet another Meetup birthday with a bigger event. Since 2013, we joined forces with the folks at " [:a {:href "http://www.ehrdclj.org/"} "EHRDC.clj"] " to organize an all-Netherlands, free Clojure conference, the biggest in Europe. Follow the discussion at " [:a {:href "http://dutch.clojuredays.nl/"} "Dutch Clojure Days"] "."]]}])

; //////////// TEMPLATES //////////////////

[:div {:class "container_12 bottom"}

 [:div {:class "grid_4"}
  [:h2 "Sponsors and " [:span {:class "orange"} "perks"]]
   (button "http://www.backbase.com"
          "images/sponsors/backbase.png"
          "Backbase"
          "NextGen Portal Software")
   (spacer)
   (button "http://www.oreilly.com"
           "http://ug.oreilly.com/banners/ug_ad_250_viguy.gif"
           "O'Reilly Network"
           "")

  (spacer)
  [:h2 "Clojure " [:span {:class "orange"} "Jobs"]]

  (rss-widget)]

 [:div {:class "grid_4"}
  [:h2 "Boost your " [:span {:class "orange"} "Clojure"]]
  [:p "By and large, teaching is the best way to learning. We will love to teach you Clo<i>j</i>ure,
          as well as having you on stage to present your brand new project or the library you just discovered."]

  [:p "&nbsp;"]

  [:h2 "Stay " [:span {:class "orange"} " in touch"]]

  (button "https://twitter.com/amsclj"
          "images/contact/twitter.png"
          "Twitter"
          "")

  (button "https://github.com/ams-clj"
          "images/contact/github.png"
          "GitHub"
          "")

  (button "mailto:amsterdam-clojurians@googlegroups.com"
          "images/contact/ggroup.png"
          "Google Group"
          "")

  ]

 [:div {:class "grid_4"}
  [:h2 "@Amsclj on " [:span {:class "orange"} "Twitter"]]

  [:a {:class "twitter-timeline" :href "https://twitter.com/amsclj" :data-widget-id "389666614846582784"} "Tweets by @amsclj"]
  [:script "!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document,'script','twitter-wjs');"]
  ]

 [:div {:class "clear"}]]
