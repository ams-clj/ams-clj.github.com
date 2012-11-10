; @layout landing
; @foo bar

; //////////// FUNCTIONS //////////////////

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
              [:p "Every year around October we celebrate yet another Meetup birthday with a bigger event. We're busy organizing the 2012 edition, please hold your horses and wait until we'll make the Call For Papers public. In the meanwhile, go ahead and draft your proposal, we know you have something beautiful to disclose!"]]}])

; //////////// TEMPLATES //////////////////

[:div {:class "container_12 bottom"}

  [:div {:class "grid_4"}
   [:h2 "Last " [:span {:class "orange"} "tweets"]]
   [:ul {:id "twitter_update_list"} [:li]]
   (js "js/twitter.js")
   (js "http://twitter.com/statuses/user_timeline/amsclj.json?callback=twitterCallback&amp;count=3")]

  [:div {:class "grid_4"}
   [:h2 "Boost your " [:span {:class "orange"} "Clojure"]]
   [:p "By and large, teaching is the best way to learning. We will love to teach you Clo<i>j</i>ure,
          as well as having you on stage to present your brand new project or the library you just discovered."]
   [:h2 "Sponsors and " [:span {:class "orange"} "perks"]]
   (button "http://www.backbase.com"
          "images/sponsors/backbase.png"
          "Backbase"
          "NextGen Portal Software")
   (spacer)
   (button "http://www.oreilly.com"
           "http://ug.oreilly.com/banners/ug_ad_250_viguy.gif"
           "O'Reilly Network"
           "")]

  [:div {:class "grid_4"}
   [:h2 "Interested? " [:span {:class "orange"} "Get in touch"]]
   
   (button "https://twittwe.com/amsclj"
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

  [:div {:class "clear"}]]