; @layout  blog
; @title   post default title

[:h2 (:title site)]

[:div {:class "post"} contents
 [:div {:id "disqus_thread"}
  [:script {:type "text/javascript"}
   " /* * * CONFIGURATION VARIABLES: EDIT BEFORE PASTING INTO YOUR WEBPAGE * * */
            var disqus_shortname = 'amsclj'; // required: replace example with your forum shortname

            /* * * DON'T EDIT BELOW THIS LINE * * */
            (function() {
                var dsq = document.createElement('script'); dsq.type = 'text/javascript'; dsq.async = true;
                dsq.src = 'http://' + disqus_shortname + '.disqus.com/embed.js';
                (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq);
            })();"]
  [:noscript "Please enable JavaScript to view the " (link "comments powered by Disqys." "http://disqus.com/?ref_noscript")]]]
