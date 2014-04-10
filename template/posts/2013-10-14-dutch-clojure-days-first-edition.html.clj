; @layout post
; @title Dutch Clojure Days: the first edition
; @tag conference #dcdnl

; //////// FUNCTIONS ////////
(defn gravatar [hash]
  (str "http://www.gravatar.com/avatar/" hash))

; //////// TEMPLATES ////////

[:p "Here we are, two days after the last edition of the biggest Clojure event in the Netherlands, possibly the biggest free Clojure conference in Europe. This time around the " [:a {:href "http://www.ehrdclj.org/"} "EHRDC.clj"] " meetup joined the Amsterdam community to make a pan-Dutch event, and the conference was appropriately rebranded to be called " [:a {:href "http://dutch.clojuredays.nl/"} "Dutch Clojure Days"] ". Still, it has been the fourth edition of our yearly conference, and it proved itself to be an established tradition in the Dutch Clojure community."]

[:p]

[:h2 "A big thank you"]

[:p "This year we found some enthusiastic companies that supported our conference in all ways possible, and sponsored it not only with money but with excellent stories and experiences from the trenches. Without them we would not have been able to put together such a perfect day as what the Dutch Clojure Day happened to be. So, a big hand goes to " [:a {:href "http://announce.ly/"} "Announcely"] ", " [:a {:href "http://screen6.io/"} "Screen" [:sup "6"]] ", " [:a {:href "http://www.adgoji.com/"} "AdGoji"] " and " [:a {:href "http://www.backbase.com"} "Backbase"] ". The most awesome fact about most of our sponsors is that they not only put Clojure at the base of their technology stack, they're also looking for new Clojure developers to join their teams. Th'ere it is, your chance to work with the most awesome programming language ever conceived!"]

[:p "Sponsors alone don't make a great events. We also had the honor to give the stage to some very talented speakers. Go look at the " [:a {:href "http://dutch.clojuredays.nl/programme.html"} "program"] " and you'll see what I'm talking about. Besides, we will put the videos of the recordings online, so you'll be able to judge by yourself the high level of the talks."]

[:p]

[:h2 "See you next year"]

[:p "One thing is for sure: there will be more and bigger Dutch Clojure Days in the future. And we're committed to keep it a free event, with a very informal and welcoming atmosphere, still putting on stage the greatest people and technologies from the Clojure world. See all of you next year!"]

[:hr]

(author "http://www.gravatar.com/avatar/de4b1a10e60f6a0202e0f3c82f70fb5f.jpg?s=150"
        "Amsterdam Clojurians"
        " is the biggest Clojure community in the Netherlands. Out activities started back in September '09, and we pride ourselves to never have let a month go without our regular meetup ever since. We are a free group and we welcome everyone to come and enjoy his time with a bunch of Clojure enthusiasts."
        "amsclj")
