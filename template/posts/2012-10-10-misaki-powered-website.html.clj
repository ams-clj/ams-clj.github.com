; @layout post
; @title A Misaki powered website
; @tag misaki website


[:img {:style "float:right; margin: 10px" :src "/images/poweredby-misaki.png"}]

[:p
 "The first version of this website was a mere two-pages static HTML, most of which were just a cut and paste from each other. Besides being hard to manage and inherently bad (though extremely performant!), it was always meant for the " [:span {:class "orange"} "Amsterdam Clojurians"] " website to have an institutional website powered by Clojure based technologies."]

[:p "Serving static HTML pages is the quickest way to scale at Internet levels, and " (link "Jekyll" "https://github.com/mojombo/jekyll") " is rightfully all the rage when it comes to static site generators, with " (link "GitHub Pages" "http://pages.github.com/") " pushing it to the maximum. Now, while Jekyll would have already been a great tool to serve our pages, it being Ruby was a bit of an idiosynchrasy with the core values of our Meetup, those of pushing and evangelizing Clojure and related technologies. We needed a Clojure alternative."]

[:br]

[:h3 "Blooming beautifully with Misaki"]

[:p "A quick search over GitHub provided straght out an interesting candidate: " (link "Misaki" "https://github.com/liquidz/misaki") ", admittendly a Jekyll clone written completely in Clojure and still under active development from his creator " (link "Masashi Iizuka" "http://liquidz.github.com/") ". Time was ripe to migrate, and the result is the very blog you're reading right now."]

[:p "If everything goes in the right direction, you'll read more on Misaki from this blog. For now, we will just send an enormous thank you to Masashi, and wish you a happy reading."]
