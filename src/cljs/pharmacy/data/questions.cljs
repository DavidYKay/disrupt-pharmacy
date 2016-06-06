(ns pharmacy.data.questions)

(def score-risk-questions
  [{:question "What is your sex?"
    :id :sex
    :type :multiple-choice
    :choices ["----"
              "Male"
              "Female"]}
   {:question "What is your age?"
    :type :integer
    :id :age}
   {:question "What is your ethnicity?"
    :id :race
    :type :multiple-choice
    :choices ["----"
              "Black"
              "White"
              "Other"]}
   {:question "Are you a smoker?"
    :id :smoker
    :type :boolean}
   {:question "Do you have diabetes?"
    :id :diabetes
    :type :boolean}
   {:question "Have you ever had a heart attack or stroke?"
    :id :cardiac-event
    :type :boolean}])
