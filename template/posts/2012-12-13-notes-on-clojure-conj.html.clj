; @layout post
; @title Notes from the Clojure Conj 2012
; @tag conference events #OctAmsClj

; //////// FUNCTIONS ////////
(defn gravatar [hash]
  (str "http://www.gravatar.com/avatar/" hash))

; //////// TEMPLATES ////////

[:blockquote [:i "The following notes were taken while attending the 2012 edition of the " [:a {:href "http://clojure-conj.org/"} "Clojure/conj"] " conference. The style is quite succint and compact as it goes with personal notes, but it will be hopefully a nice reading in this blog format as well. You can find the " [:a {:href "https://github.com/wvdlaan/conj2012"} "original notes"] " on GitHub."]]

[:h2 "Keynote"]

[:p "In his keynote, Rich Hickey focused on the big difference there is between programs and systems:
Programs lives in a &quot;bubble&quot; where I/O is someone else's problem,
while Systems live in the real world. Failures can only be addressed at the system level."]
[:p "Joe Armstrong's 2003 Erlang thesis exposes the concept of "
  [:a {:href "http://www.erlang.org/download/armstrong_thesis_2003.pdf"}
   [:i "Making reliable distributed systems in the presence of software errors"]]
 "."]
[:p "Rich's advice: build simple systems like e.g.: "
 [:a {:href "http://memcached.org/"} "memcached"] ", "
 [:a {:href "http://zookeeper.apache.org/"} "Zookeper"] " or "
 [:a {:href "http://aws.amazon.com/s3/"} "Amazon S3"] "."]

[:br]

[:h2 "Everything as a value"]

[:p "Several speakers talked about values, i.e.: "
 [:ol {:style "margin: 20px"}
  [:li "do not change the past"]
  [:li "do not change in place"]
  [:li "register everything in like e.g. git or Datomic"]]]

[:p [:strong "Stuart Halloway"] " showed a simulation based testing approach
 it was used for Datomic and that will be open sourced soon. It mainly revolves on
 the equation system testing = real world testing, and that everything is data and is stored forever
 as an immutable value."]

[:p "The conceptual steps are:"
 [:ol {:style "margin: 20px"}
  [:li "define the business model ->"]
  [:li "generate, record and replay events ->"]
  [:li "always store results from system under test as queriable data"]]]

[:p
 "Having all historical test data available, if you change the program you can check differences between result sets
  by simulating the same events. You can go always go back in time and answer the question:"
 [:blockquote "is this problem new or did we previously miss it?"]]

[:p [:strong "Rich Hickey"] " then shared ideas about "
 [:a {:href "https://github.com/Datomic/codeq"} "codeq"] ". "
 "Git does not handle the world outside a single repo, whereas
 codeq adds the missing higher level: putting together multiple repositories.
 This is not properly completely defined, so that things like unique naming might be solved through github.
 Git takes the SHA of a file, and any new SHA is then add to repo. Codeq takes an additional step:
 a file is a directory of positons, so codeq makes a SHA for each code block in the file.
 For any new SHA then adda filename + position of the code block in file to the repo.
 Also, if you add something to codeq you must also add a transaction record
 to document what you did.
 As a result, we could have a central codeq-db were you can ask questions like:"

 [:blockquote
  "what libraries ever used torque?"
  [:br]
  "are they still using it?"
  [:br]
  "show me some use examples"]]

[:p "The next step is to get function calls in codeq."]

[:p [:strong "Kovas Boguta"] " showed how the " [:a {:href "https://github.com/kovasb/session"} "repl-session"] " can also be a value"]

[:p [:strong "Antoni Batchelli & Hugo Duncan"] " said they're thinking about moving the pallet config to datomic."]

[:br]

[:h2 "ClojureScript"]

[:p [:strong "Chris Granger"] " introduced the recent changes in LightTable:"
 [:ol {:style "margin: 10px"}
  [:li "LT uses Roger Wang's " [:a {:href "https://github.com/rogerwang/node-webkit"} "node-webkit"] "(node.js + chromium)"]
  [:li "LT will use a " [:a {:href "http://www.chris-granger.com/2012/12/11/anatomy-of-a-knockout/"} "Component-Entity-System (CES) engine"]]]]

[:p [:strong "Bodil Stokke"] " presented a live coding demo using node.js and " [:a {:href "https://github.com/drcode/webfui"}] ". She used the " [:a {:href "https://github.com/bodil/catnip"} "catnip editor"] "and " [:a {:href "https://github.com/bodil/cljs-noderepl"} "cljs-noderepl"]]

[:p [:strong "Paul DeGrandis"] " talked about using ClojureScript in the browser, and stressed the importance of learning how to use the goog library. Documentation on goog is rare: there's only one book and the newsgroup. Still, its features are still worth it. The goog libary handles browser differences really well, but once you get to the HTML5 stuff it gets tricky. The goog library has two calling conventions that are different to require and call. Still, you need to understand this difference. You can use the protocols and the handy functions in " [:a {:href "https://github.com/shoreleave"} "shoreleave"] " to avoid working directly  with the goog library. This gives you loosely coupled code and inverted control. If you run into troubles on the client, you can always shift the work to the server. It is of course always fine to use other libraries like jQuery if you need to."]

[:p [:strong "Conrad Barski"] " demonstrated " [:a {:href "https://github.com/drcode/webfui"} "webfui"] ", a client side web development framework. It stored the DOM in atoms using EDN as the representation. It automatically keeps changes in the EDN model in sync with the browser DOM. It allows you to define functions to be run when the state changes."]

[:p [:strong "Alan Dipert"] " did a lightning talk over Functional Reactive Programming (FRP) in ClojureScript using " [:a {:href "https://github.com/alandipert/flapjax-demo"} "Flapjax"] "."]

[:h2 "Miscellaneous"]

[:p [:strong "David Nolen"] " added custom constraints to core.logic he calls this 'open unification'. This helped to make the sudoku solver an order of magnitude faster because you can now define your custom search strategy."]

[:p [:strong "Hugo Duncan"] " gave a demo of " [:a {:href "https://github.com/pallet/ritz/tree/develop/nrepl"} "ritz-nrepl"] ". It allows you to inspect the locals in your stacktrace (with or without locals clearing), or inspect the forms that raised compiler errors in compile time stacktraces."]

[:p "Finally, a team of renowned European Clojure practitioners started " [:a {:href "http://www.lambdanext.com"}] ", they think about planning a training in Amsterdam second half of 2013. They are:"

 [:p
  "Christophe Grand (enlive, Clojure Programming)" [:br]
  "Sam Aaron (overtone)" [:br]
  "Edmund Jackson (talk on Machine Learning at Clojure/conj 2012)" [:br]
  "Meikel Brandmeyer (vimclojure)"]]

[:hr]

[:div
 [:img {:style "float:left; padding: 10px" :src "https://secure.gravatar.com/avatar/284b1d54e55bf79734cc389aa56ff9f4?s=100"}]
 [:br]
 [:i {:style "margin: 10px"} [:strong "Walter van der Laan "] " is cofounder of Fincite, a pure Clojure startup with a focus on business analysis"]]

