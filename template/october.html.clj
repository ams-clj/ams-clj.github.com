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
  [:p "The agenda was finalized, stay tuned for the final schedule, to be published any time now!"]
  [:p]
  [:p {:class "Desc"}
             [:span {:class "site"}
              [:a {:href "#"}
               "Coming soon"]]]
  [:p]]
 
 [:div {:class "grid_4"}
  [:p "Sponsored " [:span {:class "orange"} "by"]]
  (button "http://www.backbase.com"
          "images/sponsors/backbase.png"
          "Backbase"
          "NextGen Portal Software")
  [:h3 "&nbsp;"]
  (button "http://gotocon.com/amsterdam-2013/"
          "images/sponsors/goto.png"
          "GOTO Conference"
          "GOTO Conference Amsterdam 2013")
  [:h3 "&nbsp;"]
  (button "http://www.oreilly.com"
           "http://ug.oreilly.com/banners/ug_ad_250_viguy.gif"
           "O'Reilly Network"
           "")
  ]

 [:div {:class "clear"}]]
