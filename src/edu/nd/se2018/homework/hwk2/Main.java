package edu.nd.se2018.homework.hwk2;

/**
 * A horse racing simulator to test which strategy wins overall:
 * 0 : Early Sprint - First 2 miles is max speed and then reduces to 75%.
 * 1 : Steady - Runs at 80% speed the entire race.
 * 2 : Slow Start - First 6 miles is 75% speed, next 3 miles is 90%, and last mile is 100%.
 * 
 * @author Donald Luc
 *
 */

public class Main
{
	public static void main(String[] args) {
		Race race = new Race();
		Horse blister = new Horse("Blister", StrategyEnum.EARLY_SPRINT);
		race.addHorse(blister);
		Horse mary = new Horse("Mary", StrategyEnum.STEADY);
		race.addHorse(mary);
		Horse gohsman = new Horse("Gohsman", StrategyEnum.STEADY);
		race.addHorse(gohsman);
		Horse roxie = new Horse("Roxie", StrategyEnum.SLOW_START);
		race.addHorse(roxie);
		Horse canter = new Horse("Canter", StrategyEnum.SLOW_START);
		race.addHorse(canter);
		race.start();
		
		race.reset();
		canter.setStrategy(StrategyEnum.STEADY);
		race.start();
	}
}
