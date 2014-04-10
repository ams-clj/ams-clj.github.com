; @layout post
; @title Meetup #49: A Clojure Dojo
; @tag meetup dojo

; //////// FUNCTIONS ////////
(defn gravatar-hash [addr]
  (let [md5 (java.security.MessageDigest/getInstance "md5")]
    (.update md5 (.getBytes (.trim addr) "utf-8"))
    (.toString (BigInteger. 1 (.digest md5)) 16)))

(defn gravatar [addr]
  (str "http://www.gravatar.com/avatar/" (gravatar-hash addr)))

; //////// TEMPLATES ////////

[:a {:href "http://www.gnu.org/software/emacs/"}
 [:img {:class "blog-img"
        :src "http://photos3.meetupstatic.com/photos/event/a/f/4/8/600_350924872.jpeg"
        :style "float: right; margin: 0px 0px 10px 10px"}]]

[:blockquote "These are the notes from the regular "
 [:a {:href "http://www.meetup.com/The-Amsterdam-Clojure-Meetup-Group/"} " Amsterdam Clojurians
meetup."] " Next time, why don't you join us?"]

[:p "In its #49 edition, the Amsterdam Clojure meetup was not about
presenting or discussing about our beloved language: it was about
getting our hands dirty and engage in a programming challenge."]

[:p "This writeup will surely fail to capture how fun it was,
but will hopefully give you some good ideas about how to
organize a super fun event with your colleagues or your
local clojure community."]

[:br]

[:h2 "Approach the dojo"]

[:p "There are many ways you can run a code dojo. The most adopted formula
is the " [:a {:href "http://dojo.wikidot.com/randori"} "Randori"] ", where"]

[:img {:style "float: right" :src "/images/randori.png"}]

[:br]

[:ul
 [:li "> you hook up one laptop to the projector"]
 [:li "> the group chooses a problem to attack"]
 [:li "> two folks start to pair program in front of the others"]
 [:li "> after 5~10 minutes one new developer joins the pair and one leaves"]]

[:br]

[:p "Now, in my experience that can be an awesome format for a dojo when "
 [:strong "most of the developers in the audience are experienced"] ". Participation
is really key in a successful dojo experience, and if newbies are there they
will likely be unable to follow the most experienced ones, disconnecting
pretty soon from the collective stream of thought presented on screen." [:br]
 "The main reason for organizing our dojo was to make it easier for
newcomers to enjoy and learn from the meetups, so clearly the randori was "
 [:strong "not the best option for us"] "."]

[:br]

[:h2 "Extreme pair programming"]

[:p "Getting inspiration from " [:a {:href "http://otfrom.wordpress.com/2012/07/04/how-to-run-a-london-clojure-dojo-in-20ish-easy-steps/"} "various "]
 [:a {:href "http://ntoll.org/article/how-to-run-an-awesome-code-dojo"} "sources, "]
"I settled for the following structure:"]

[:br]

[:ul
 [:li "> I chose a problem upfront, both challenging and accessible: " [:a {:href "http://butunclebob.com/ArticleS.UncleBob.TheBowlingGameKata"} "the bowling kata"]]
 [:li "> the audience was split up in pairs"]
 [:li "> every pair had three " [:a {:href "http://pomodorotechnique.com/"} "pomodoros "] "to complete the task"]
 [:li "> at the end of each pomodoro anyone gets to choose where to keep or change the partner"]
 [:li "> each pair presents their solution, however partial or broken, hooking up to the projector"]]

[:br]

[:p "The result was great, both clojure veterans and complete newbies had the
chance to progam, discuss and try to solve the riddle. Out of seven pairs, only
one was eventually able to complete the assignment, and only at the very end
of the time available."]

[:p "Both pair progamming and the final show and tell sessions were particularly
engaging. We didn't have many swapping pairs, IMO because of the almost perfect
split between veterans and newbies: only one swap after the first pomodoro. But
the idea seemed to tickle enough people to propose it again the next time."]

[:hr]

[:div
 [:img {:style "float:left; padding: 10px" :src (gravatar "skuro@skuro.tk")}]
 [:br]
 [:i {:style "margin: 10px"} [:strong "Carlo Sciolla"] " is a Clojure
fanatic, open source addict and technology enthusiast. He likes to organize
stuff, and runs the Amsterdam Clojure meetup in the last years. He also likes
to write about himself in third person."]
 [:br]
 [:a {:href "http://skuro.tk"} "Skuro.tk"] " &lt;&gt; " [:a {:href "https://twitter.com/amsclj"} "@skuro"]]
