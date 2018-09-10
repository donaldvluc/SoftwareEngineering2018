package edu.nd.se2018.homework.hwk2;

/**
 * Early Sprint : First 2 miles is max speed and then reduces to 75%.
 * 
 * @author Donald Luc
 *
 */

public class EarlySprint implements StrategyInterface {

	@Override
	public void move(Horse h) {
		double dx = 0;
		if (h.getDistance() <= 2.0) {
			dx = h.getSpeed();
		} else {
			dx = h.getSpeed() * 0.75;
		}
		h.addToDistance(dx);
	}

}
