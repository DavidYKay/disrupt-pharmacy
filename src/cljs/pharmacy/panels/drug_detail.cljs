(ns pharmacy.panels.drug-detail
  (:require
   [pharmacy.components.top-bar :refer [top-bar]]
   ))

(defn component []
  (fn []
    [:div

     [top-bar]
     
     [:section.section
      [:div.container
       [:div.tile.is-ancestor
        [:div.tile.is-parent
         [:div.tile.is-child.box
          [:div "B"]
          [:div "Overall Score"]
          ]]
        [:div.tile.is-parent.is-vertical
         [:div.tile.is-child.box
          [:div "A"]
          [:div "Effectiveness"]
          ]
         [:div.tile.is-child.box
          [:div "C"]
          [:div "Side Effects"]
          ]]]
       [:h1.title.drug-title "Atorvastatin"]]]

     
     [:section.section
      [:div.container

       [:h2.subtitle "Description"]
       [:div.content "This drug is the bee's knees. Here is a bunch of filler text. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla convallis ut diam eget consectetur. Vestibulum vehicula enim vel volutpat vestibulum. Donec non eros placerat, mollis massa ac, sagittis diam. Morbi aliquam commodo leo finibus mattis. Curabitur placerat nisl a turpis volutpat, dignissim vestibulum ante luctus. Nam posuere est sed dolor convallis, eget rhoncus turpis tempus. Aliquam ligula nulla, luctus vel lacus eget, elementum eleifend felis. Maecenas non nulla venenatis, lacinia lectus ac, sodales nisl. Suspendisse ultricies felis dui, bibendum sodales felis pellentesque vitae."]

       [:a.button "Improve Score for You"]
       [:a.button "Fill Prescription"]
       [:a.button "Consult"]
       ]]

     [:section.section
      [:div.container.box
       [:div "Have you ever had a heart attack or stroke?"]
       [:a.button "Yes"]
       [:a.button "No"]
       
       [:div "Do you have diabetes or are pre-diabetic?"]
       [:a.button "Yes"]
       [:a.button "No"]]]

     [:section.section
      [:div.container
       [:a.button "View Alternatives to Atorvastatin"]]]

     [:section.section
      [:div.container
       [:h2.subtitle "Side Effects"]
       [:div.content "Some known side effects. Here is a bunch of filler text. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla convallis ut diam eget consectetur. Vestibulum vehicula enim vel volutpat vestibulum. Donec non eros placerat, mollis massa ac, sagittis diam. Morbi aliquam commodo leo finibus mattis. Curabitur placerat nisl a turpis volutpat, dignissim vestibulum ante luctus. Nam posuere est sed dolor convallis, eget rhoncus turpis tempus. Aliquam ligula nulla, luctus vel lacus eget, elementum eleifend felis. Maecenas non nulla venenatis, lacinia lectus ac, sodales nisl. Suspendisse ultricies felis dui, bibendum sodales felis pellentesque vitae."]]]

     [:section.section
      [:div.container
       [:h2.subtitle "Drug Interactions"]
       [:div.content "Here's how the drug can interact with things. Here is a bunch of filler text. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla convallis ut diam eget consectetur. Vestibulum vehicula enim vel volutpat vestibulum. Donec non eros placerat, mollis massa ac, sagittis diam. Morbi aliquam commodo leo finibus mattis. Curabitur placerat nisl a turpis volutpat, dignissim vestibulum ante luctus. Nam posuere est sed dolor convallis, eget rhoncus turpis tempus. Aliquam ligula nulla, luctus vel lacus eget, elementum eleifend felis. Maecenas non nulla venenatis, lacinia lectus ac, sodales nisl. Suspendisse ultricies felis dui, bibendum sodales felis pellentesque vitae."]]]
       
     
     [:section.section
      [:div.container
       [:div.columns
        [:div.column
         [:a.button "Fill Prescription"]]
        [:div.column
         [:a.button "Consult Pharmacist"]]]]]

     ]))
