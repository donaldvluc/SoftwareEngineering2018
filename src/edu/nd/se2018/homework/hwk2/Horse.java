package edu.nd.se2018.homework.hwk2;

public class Horse {
	String name = "";
	int mile = 0;
	StrategyInterface strategy;

	public Horse(String n, StrategyEnum strategyEnum) {
		name = n;
		setStrategy(strategyEnum);
		System.out.println("New Horse!");
	}

	public int getMile() {
		return mile;
	}

	public void setStrategy(StrategyEnum strategyEnum) {
		switch (strategyEnum) {
		case EARLY_SPRINT:
			System.out.println("0");
			break;
		case STEADY:
			System.out.println("1");
			break;
		case SLOW_START:
			System.out.println("2");
			break;
		}
	}

	public void print() {
		System.out.println(name + " has run " + mile + " miles.");
	}
	
	public void reset() {
		mile = 0;
	}
}
