Design Decisions
Some of the design decisions you will need to consider include:

1. In which class and method is the strategy going to be set?
Each horse class will have a strategy variable that will be set with a public function such as SetStrategy(). For example, in Main() I will get a single horse from a Horse array in the Race class and then call SetStrategy() on that horse.

2. What will your strategy hierarchy look like? Will you use an abstract base class or an interface? What methods will strategy classes include? (Note: While I provided you with an initial interface – you can choose whether you like to keep the interface or replace with a super class).
My strategy hierarchy will implement a strategy interface where each of the three strategies: early sprint, steady, and slow start. The strategy classes will be forced to implement two functions, move() and changeSpeed().

3. What other classes will you need?
Besides the Main() class I plan to have a Race() class, a Horse() class, a Strategy() interface, EarlySprint() interface, Steady() interface, and SlowStart() interface.

4. Where will you put the control loop for the race?
The control loop for the race will be in the Race class start() public method.

5. What data structure will you use to manage horses in the race? The design rationale you write will likely be about one paragraph (maybe two) explaining your decisions. You could use these questions as an outline if you wish.
I plan to use an array of constant size five. I will iterate through the array and call respective methods for each horse.
