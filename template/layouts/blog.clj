; @layout default
; @title Blog
; @isblog true

; ///////////////// FUNCTIONS ///////////////////

(defn render-tag [{:keys [url name]}]
  [:a {:href url} name])

(defn trim [post-file]
  (misaki.compiler.default.core/file->template-sexp post-file :allow-layout? false))

(defn preview-post [{:keys [url title tag date file]}]
  [:span
   [:h2 title]
   (take 3 (trim file))
   [:p (link "more..." url)]])

(defn preview-posts [site]
  (map preview-post (take 5 (:posts site))))

; ///////////////// TEMPLATES ///////////////////


[:div {:class "container_12 bottom"}
 [:div {:class "grid_8 rounded"  :style "background-color: white; border: 1px solid #F0F2EE"}
  [:br]
  [:div {:style "margin: 10px"}
   contents]]
 [:div {:class "grid_4 rounded"  :style "background-color: white; border: 1px solid #F0F2EE; width: 290px"}
  [:div {:style "margin: 10px"}
   [:h3 {:class "orange"} "Archive"]
   (post-list)
   [:br]
   [:h3 {:class "orange"} "Tags"]
   (tag-list)]]
 [:div {:class "clear"}]]

