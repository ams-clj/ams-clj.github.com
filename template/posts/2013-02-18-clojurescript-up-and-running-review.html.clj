; @layout post
; @title Book review "ClojureScript: up and running"
; @tag books reviews oreilly

; //////// FUNCTIONS ////////
(defn gravatar [hash]
  (str "http://www.gravatar.com/avatar/" hash))

; //////// TEMPLATES ////////

[:a {:href "http://bit.ly/cljs-uprun"}
 [:img {:class "blog-img"
        :src "http://akamaicovers.oreilly.com/images/0636920025139/cat.gif"
        :style "float: right; margin: 0px 0px 10px 10px"}]]

[:blockquote "The copy of "
 [:a {:href "http://bit.ly/cljs-uprun"}
  "ClojureScript: Up and Running"]
 " I read was provided to the Amsterdam Clojure meetup by O’Reilly as part of their " [:a {:href "http://oreilly.com/ug/"} "UserGroup"]
" program."]

[:p "My first impression of the book was that it was nice and thin - at
under 100 pages of content its stays true to the “up and running”
concept.  The book is aimed at someone who’s new to "
 [:a {:href "https://github.com/clojure/clojurescript"} "ClojureScript"] ",
whether or not they’ve used Clojure before, although it does require a
basic knowledge of JavaScript.  The book is structured in such a way
that someone who already has Clojure knowledge can skip a third to
half of the chapters and just focus on the ClojureScript specific
parts."]

[:p "After explaining the rationale behind ClojureScript, the book starts
off with a short example to get you started with ClojureScript and the
development process.  It uses the "
 [:a {:href "https://github.com/emezeske/lein-cljsbuild"} "lein-cljsbuild"]
" Leiningen plugin to
simplify the build and gets you going with minimal explanation.  From
there it dives deeper into the compiler, the configuration of it and
its relationship with the "
 [:a {:href "https://developers.google.com/closure/compiler/"} "Google Closure Compiler"] "."]

[:p "The next five chapters cover the basics of the ClojureScript language.
 These chapters provide a nice introduction to the ClojureScript
language.  They cover the core of the language, assuming nothing and
starting with the very basics, progressing to dealing with key
Clojure/ClojureScript concepts such as immutability, sequences and
namespaces.  They also touch on more advanced topics such as macros.
These chapters are only an introduction to the language.  The reader
is encouraged to seek out Clojure literature to discover more, but I
really feel they give a good introduction to the language, providing
enough information to the reader to draw them in and get them started
without overwhelming them."]

[:p "Much of the details of ClojureScript are similar enough for someone
with experience in Clojure not to need to read these chapters, however
there are some differences and an experienced Clojure developer would
benefit from at least skimming the content here - particularly the
chapter on namespaces, as there are quite a few implementation details
and quirks stemming from the use of the Google Closure Compiler."]

[:p "The final two chapters cover more of the development process and
workflow, including the ClojureScript browser repl vs the command line
repl, building ClojureScript from source, testing and so on.  They
also cover basic integration with server-side Clojure, including code
sharing."]

[:p "ClojureScript: Up and Running is a well written, concise, book.  It
states that it is for “software developers who want to learn how to
get started using ClojureScript to build web browser applications”.  I
think that anyone reading this book will get a solid grounding in
ClojureScript and it will enable them to get up and running very
quickly.  I also feel that a complete newcomer to ClojureScript (that
has some JavaScript experience) will find this book a great
introduction to the language.  My only concern is that a more
experienced Clojure developer might feel short changed by the book,
with probably half its pages covering areas they will already have
experience in, but certainly it will give them the knowledge to get
going with ClojureScript, so will still be a valuable book for them."]

[:p "So, bearing that small caveat in mind, I would recommend this book to
anyone wanting to get a good introduction to ClojureScript."]

[:hr]

(author "/images/chris.jpg"
        "Chris Wilson"
        " is something of a generalist, having worked in various fields -
from IT teacher in a prison to senior development positions in banking
and aerospace. Chris has been using Clojure on and off in personal
projects for a couple of years."
        "minleychris")
