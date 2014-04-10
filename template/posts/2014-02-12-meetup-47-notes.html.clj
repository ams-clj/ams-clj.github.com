; @layout post
; @title Meetup #47: Bake your own Emacs
; @tag meetup emacs

; //////// FUNCTIONS ////////
(defn gravatar [hash]
  (str "http://www.gravatar.com/avatar/" hash))

; //////// TEMPLATES ////////

[:a {:href "http://www.gnu.org/software/emacs/"}
 [:img {:class "blog-img"
        :src "http://www.gnu.org/software/emacs/tour/images/splash-small.png"
        :style "float: right; margin: 0px 0px 10px 10px"}]]

[:blockquote "These are the notes from the regular "
 [:a {:href "http://www.meetup.com/The-Amsterdam-Clojure-Meetup-Group/"} " Amsterdam Clojurians
meetup."] " Next time, why don't you join us?"]

[:p "The 47th edition of the meetup was quite a great one, both because
we had one presentation on the agenda (weeeee!), and because the crowd
is getting really big, with around 20 attendees. We started with a more
canonical presentation, then went on with more impromptu talks about
random topics from Cljureland."]

[:h2 "Emacs on stage"]

[:p "Coming from a Java background, " [:a {:href "https://twitter.com/akazlou"} "Aliaksandr Kazlou"]
" experienced the cultural shock of switching to Emacs for his Clojure development.
He was so kind to introduce Emacs to the meetup crowd, trying to make sense of
it by building up from a vanilla istall with an empty " [:code "init.el"] ", then
adding all the goodies function by function."]

[:p "He went through a host of useful functions and packages, such as "
 [:a {:href "http://wikemacs.org/index.php/Recentf"} [:code "helm-recentf"]] " and "
 [:a {:href "https://github.com/clojure-emacs/cider"} [:code "cider"]] "."]

[:p "One question was left unanswered: why on earth would anyone need "
 [:a {:href "http://nyan-mode.buildsomethingamazing.com/"} "Nyan mode"] "?!"]

[:h2 "Random talks"]

[:p "As for all the meetups, the discussion started with someone shouting a question,
then we all followed up with someone showing some code at the projector. This time
the question was"

 [:blockquote "Does anyone know how to use " [:a {:href "https://github.com/prismatic/schema"} "Schema"] "?"
  [:a {:href "https://github.com/prismatic/schema"}
   [:img {:src "https://raw.github.com/wiki/prismatic/schema/images/logo.png"
          :class "blog-img"
          :style "float: right; margin: 0px 0px 10px 10px; width: 100px"}]]]

 "Quickly enough, " [:a {:href "https://github.com/jeroenvandijk/"} "Jeroen van Dijk"] " from "
 [:a {:href "http://www.adgoji.com/"} "AdGoji"] " promptly hooked his
laptop to the projector and demonstrated how they use it. We all agreed
that, while quite an awesome library, Schema could do a better job
at logging."]

[:p "We then briefly discussed about some memory issues found when
using " [:a {:href "https://github.com/michaelklishin/neocons"} [:code  "neocons"]]
 " but didn't get much into the specifics of the issue to be able to tell anything about it."
 [:img {:src "/images/neo4j.png"
        :class "blog-img"
        :style "float: right; margin: 0px 0px 10px 10px; width: 100px"}]]

[:p "Finally, someone asked how to selectively enable or disable " [:code "assert"]
 " invocations. Now, while it will respect the value of the " [:code "*assert*"] " variable,
as " [:code "assert"] " is a macro you can only change its effects at compile
time. If you're using " [:code "leiningen"] " you can include the following snippet in
your " [:code "project.clj"] " to control whether the asserts will fire exceptions or not: "

 [:blockquote [:code ":profiles {:assert {:global-vars {*assert* true}}}"]]

 "You can then activate the asserts by running "
 [:blockquote [:code "leiningen with-profiles +assert ..."]]]

[:p "That said, we called beer time and continued the geek talks at "
 [:a {:href "http://www.amsterdamroest.nl/"} "the Roest"] ", as tradition."]

[:p "See you at the next meetup!"]

[:hr]

[:div
 [:img {:style "float:left; padding: 10px" :src "/images/newflag.png"}]
 [:br]
 [:i {:style "margin: 10px"} [:strong "Amsterdam Clojurians"] " is the
biggest community around Clojure in the Netherlands. We are a welcoming
and open meetup, so if you happen to be around Amsterdam you definitely
have to join us: see the schedule at " [:a {:href "http://www.meetup.com/The-Amsterdam-Clojure-Meetup-Group/"} " Meetup.com"]]
 [:br] [:br]
 [:a {:href "https://twitter.com/amsclj"} "@amsclj"]]
