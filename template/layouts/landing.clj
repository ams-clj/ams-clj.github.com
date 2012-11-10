; @title landing page layout
; @format html
; @layout default


; //////////// FUNCTIONS //////////////////

; redefine in child layouts to configure the carousel elements
(defn header-elems [])

(defn panel [{{:keys [link title img alt]} :image panel-body :content}]
  [:div {:class "panel"}

   [:div {:class "projectImage"}
    [:a {:href link
         :title title}
     [:img {:src img
            :alt alt}]]]

   [:div {:class "projectDescription"}
    panel-body]])

(defn apply-panels []
  (map panel (header-elems)))

(defn arrow [direction]
  [:a {:href "#"}
   [:img {:src (str "images/featured-arrow-" direction ".png")
          :alt ""}]])

(defn button [href src title alt]
  [:a {:href href
        :title title}
    [:img {:src src
           :alt alt}]])

; //////////// TEMPLATES //////////////////

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
       
       (apply-panels)
       
       ]]]
    
    [:div {:id "stripNavR0"
           :class "featured-arrow"}
     (arrow "right")]]]

contents
