Railway Crossing Homework #05
-----------------------------
## Author: Donald Luc  
## Date: September 25, 2018  


# Question 01: Design Changes
For overall design changes, I did not change the State pattern of the gates or the observer pattern of the train, gates, and cars. I agreed with the design decisions. I mainly added changes to the train and car classes as well as the Simulation.java. For example by adding a second train, I created an ArrayList of trains in Simulation.java to loop through the changes for each train and changed the signature of a train to accept a Direction enumeration to denote which way the train was going. This decision led me to change the update() function of CrossingGate.java to handle two types of ranges: exit and triggers for the train westbound and exit and triggers for the train eastbound. For the car crossing the "EastWay" highway I added a new section of code in the car constructor to randomize whether the car plans to turn or not. I successfully deleted observing turning cars but I failed to niether make the cars on the "EastWest" high observe each other nor observe the cars on the "Western" highway. I probably spent too much time considering refactoring the implementation of CarFactory and Road objects since I felt that the Road object should have the List<Car> instead of the CarFactory object. More analysis is needed.


# Question 02: Scalability
The current design is semi-scalable. When adding more trains than the current design is not that scalable since each exit and trigger range may be too many and the gates would never be fully open for cars to go through. Another issue is that cars are currently hardcoded to go west when turning but if another sideways road was added then more functionality needs to be made to handle westward movement. The scalable part of the design is that when adding a road it is self-maintained to build cars as needed. Also, adding more gates is scalable to always observe a train but the placement of the track needs to be right next to the gate.
