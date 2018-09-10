package edu.nd.se2018.homework.hwk2;

/**
 * Horse : A class with the horse's name, strategy, speed, and current distance.
 * 
 * @author Donald Luc
 *
 */

public class Horse {
	String name = "";
	StrategyInterface strategy;
	double speed = 0;
	double distance = 0;

	public Horse(String n, StrategyEnum strategyEnum, double s) {
		if (n == "") {
			System.exit(2);
		} else {
			name = n;
		}

		setStrategy(strategyEnum);

		if (s < 0.00) {
			System.exit(3);
		} else {
			speed = s;
		}
	}

	public double getSpeed() {
		return speed;
	}

	public double getDistance() {
		return distance;
	}
	
	public void addToDistance(double d) {
		distance += d;
	}

	public void setStrategy(StrategyEnum strategyEnum) {
		switch (strategyEnum) {
		case EARLY_SPRINT:
			strategy = new EarlySprint();
			break;
		case STEADY:
			strategy = new Steady();
			break;
		case SLOW_START:
			strategy = new SlowStart();
			break;
		}
	}

	public void move() {
		strategy.move(this);
	}

	public void print() {
		System.out.printf("%s has run %.2f miles.\n", name, distance);
	}
	
	public void reset() {
		distance = 0;
	}
}
