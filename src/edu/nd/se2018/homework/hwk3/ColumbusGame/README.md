Columbus Game
-------------

### Author: Donald Luc
### Date: September 17, 2018


# Class Diagram
![alt text](https://github.com/donaldvluc/SoftwareEngineering2018/blob/master/src/edu/nd/se2018/homework/hwk3/ColumbusGame/ClassDiagram.png)


# Design Rationale
## What I Liked:
- The enumeration of OceanObjects with [OPEN, ISLAND, SHIP, PIRATE].
- The idea that ships cannot collapse on top of each other (I considered having one pirate "pillage" the ship but decided against it).
- I randomized the starting point of Columbus.
- The randomization of pirate movements to go either left/right, up/down instead of favoring left/right first.
- The idea that all ships, Columbus and Pirates, have an OceanMap as if it was an actual map navigators use to sail the seas

## What I Want To Improve:
- I realized after that I updated ship movement by *size* instead of by 1. As a result I had to downscale calculations later. (i.e. Some units were 0-624 instead of 0-24.)
- I would have liked to make an abstract Ship class and create a Columbus and Pirate class object to inherit from the Ship class.
- I could have further randomize the pirate movement by inserting another switch case within the switch case.
- I think I could add a test case to ensure that the number of islands and pirate ships does not overwhelm the grid.
- I could make certain pirate ships unique to move 2 spaces.

## Stretching:
- I would create a randomize button at the bottom right to randomize the islands and pirate ships (and keep teh number the same).
- I would detect the button is pressed if a click event was in the area of the button and then call two functions: reset() and generate().
- The reset() function would make all of the cells OceanObjects.OPEN.
- The generate function would encapsulate most of the code in OceanExplorer.start() so that it would generate a random number of nIslands() and nPirates() onto the map.
- Columbus would also have a randomized starting point.
