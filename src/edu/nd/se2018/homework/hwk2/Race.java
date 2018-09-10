package edu.nd.se2018.homework.hwk2;

import java.util.List;
import java.util.ArrayList;

/**
 * Race : A class that controls the MAX_HORSES in the race the the win condition of how
 * many MILES a horse needs to run. Each loop in the while() of start() is a simulated
 * minute in real life.
 * 
 * @author Donald Luc
 *
 */

public class Race {
	int MAX_HORSES = 5;
	double MILES = 10.0;

	int minute = 0;
	int numHorses = 0;
	Horse[] horses = new Horse[MAX_HORSES];
	

	public Race() {}

	// Public Methods:

	public void addHorse(Horse horse) {
		if (numHorses < MAX_HORSES) {
			horses[numHorses++] = horse;
		}
	}

	public void start() {
		while (!finished()) {
			minute++;	
		}
		printWinner();
	}

	Boolean finished() {
		for (Horse h : horses) {
			if (h.getDistance() >= MILES) {
				printHorses();
				return true;
			}
		}
		printHorses();
		moveHorses();
		return false;
	}

	public void resetHorses() {
		for (Horse h : horses) {
			h.reset();
		}
	}

	// Private Methods:

	private void moveHorses() {
		for (Horse h : horses) {
			h.move();
		}
	}

	private void printHorses() {
		System.out.println(minute + " minutes -------------------- ");
		for (Horse h : horses) {
			h.print();
		}
	}

	private void printWinner() {
		System.out.println("-------------------------------");
		double d = 0.00;
		List<Horse> winners = new ArrayList<Horse>();
		for (Horse h : horses) {
			if (h.getDistance() > d) {
				winners.clear();
				winners.add(h);
				d = h.getDistance();
			} else if (h.getDistance() == d) {
				winners.add(h);
			}
		}
		
		if (winners.size() == 1) {
			System.out.println("The winner is: " + winners.remove(0).name);
		} else {
			System.out.println("The race is a tie: ");
			for (Horse h : winners) {
				System.out.println(h.name);
			}
		}
	}
}
