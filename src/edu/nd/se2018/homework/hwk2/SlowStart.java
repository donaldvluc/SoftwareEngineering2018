package edu.nd.se2018.homework.hwk2;

/**
 * Slow Start - First 6 miles is 75% speed, next 3 miles is 90%, and last mile is 100%.
 * 
 * @author Donald Luc
 *
 */

public class SlowStart implements StrategyInterface {

	@Override
	public void move(Horse h) {
		double dx = 0;
		if (h.getDistance() <= 6.0) {
			dx = h.getSpeed() * 0.75;
		} else if (h.getDistance() <= 9.0) {
			dx = h.getSpeed() * 0.90;
		} else {
			dx = h.getSpeed();
		}
		h.addToDistance(dx);
	}

}
