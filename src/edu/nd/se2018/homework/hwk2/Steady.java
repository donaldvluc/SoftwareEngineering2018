package edu.nd.se2018.homework.hwk2;

/**
 * Steady - Runs at 80% speed the entire race.
 * 
 * @author Donald Luc
 *
 */

public class Steady implements StrategyInterface {

	@Override
	public void move(Horse h) {
		double dx = h.getSpeed() * 0.80;
		h.addToDistance(dx);
	}

}
