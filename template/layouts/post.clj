; @layout  blog
; @title   post default title

;/////////// FUNCTIONS /////////////

; @param avatar : a string with the URL to the avatar
; @param name   : the string with the full name
; @param desc   : the long text with the description
; @param twitter: the twitter handle
(defn author [avatar name desc twitter]
  [:div
   [:img {:style "float:left; padding: 10px" :src avatar}]
   [:br]
   [:i {:style "margin: 10px"} [:strong name] desc]
   [:br] [:br]
   [:a {:href (str "https://twitter.com/" twitter)} (str "@" twitter)]])

;/////////// TEMPLATES /////////////

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
