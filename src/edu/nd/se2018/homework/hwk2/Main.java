package edu.nd.se2018.homework.hwk2;

/**
 * A horse racing simulator to test which strategy wins overall:
 * 		Early Sprint - First 2 miles is max speed and then reduces to 75%.
 * 		Steady - Runs at 80% speed the entire race.
 * 		Slow Start - First 6 miles is 75% speed, next 3 miles is 90%, and last mile is 100%.
 * 
 * The first argument for a horse is its name, the second is its strategy, and the third
 * is its miles per minute.
 * 
 * @author Donald Luc
 *
 */

public class Main
{
	public static void main(String[] args) {
		Race race = new Race();
		Horse blister = new Horse("Blister", StrategyEnum.EARLY_SPRINT, 0.5);
		race.addHorse(blister);
		Horse mary = new Horse("Mary", StrategyEnum.STEADY, 0.4);
		race.addHorse(mary);
		Horse gohsman = new Horse("Gohsman", StrategyEnum.STEADY, 0.3);
		race.addHorse(gohsman);
		Horse roxie = new Horse("Roxie", StrategyEnum.SLOW_START, 0.5);
		race.addHorse(roxie);
		Horse canter = new Horse("Canter", StrategyEnum.SLOW_START, 0.4);
		race.addHorse(canter);
		race.start();
	}
}
