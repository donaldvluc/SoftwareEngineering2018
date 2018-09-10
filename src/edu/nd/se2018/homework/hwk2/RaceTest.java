package edu.nd.se2018.homework.hwk2;

import org.junit.Test;

public class RaceTest {
	@Test // Initial number of horses is 0.
	public void Init() {
		Race race = new Race();
		assert(race.numHorses == 0);
	}

	@Test // Number of horses should increase by 1.
	public void AddHorse() {
		Race race = new Race();
		Horse blister = new Horse("Blister", StrategyEnum.EARLY_SPRINT, 0.5);
		race.addHorse(blister);
		assert(race.numHorses == 1);
	}
	
	@Test // Cannot have more than 5 race horses.
	public void MaxHorses() {
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
		Horse extra = new Horse("Extra", StrategyEnum.EARLY_SPRINT, 0.6);
		race.addHorse(extra);
		assert(race.numHorses == 5);
	}
	
	@Test // Do not add the same horse twice.
	public void UniqueHorses() {
		Race race = new Race();
		Horse blister = new Horse("Blister", StrategyEnum.EARLY_SPRINT, 0.5);
		race.addHorse(blister);
		race.addHorse(blister);
		assert(race.numHorses == 1);
	}

	@Test // Handle two or more winners.
	public void Winners() {
		Race race = new Race();
		Horse blister = new Horse("Blister", StrategyEnum.EARLY_SPRINT, 0.5);
		race.addHorse(blister);
		Horse mary = new Horse("Mary", StrategyEnum.STEADY, 0.4);
		race.addHorse(mary);
		Horse gohsman = new Horse("Gohsman", StrategyEnum.STEADY, 0.3);
		race.addHorse(gohsman);
		Horse roxie = new Horse("Roxie", StrategyEnum.SLOW_START, 0.5);
		race.addHorse(roxie);
		Horse canter = new Horse("Canter", StrategyEnum.SLOW_START, 0.5);
		race.addHorse(canter);
		Horse extra = new Horse("Extra", StrategyEnum.EARLY_SPRINT, 0.6);
		race.addHorse(extra);
		race.start();
		assert(race.findWinners() == 2);
	}
}
