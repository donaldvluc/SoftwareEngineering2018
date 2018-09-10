package edu.nd.se2018.homework.hwk2;


public class Race {
	int MAX_HORSES = 5;
	int MILES = 10;

	int numHorses = 0;
	Horse[] horses = new Horse[MAX_HORSES];
	

	public Race() {
		System.out.println("Race Created!");
	}

	public void addHorse(Horse horse) {
		if (numHorses < MAX_HORSES) {
			horses[numHorses++] = horse;
		}
	}

	public void start() {
		print();
//		while (!finished()) {
//			for (Horse h : horses) {
//				print();
//			}
//		}
	}

	public void reset() {
		for (Horse h : horses) {
			h.reset();
		}
	}

	Boolean finished() {
		for (Horse h : horses) {
			if (h.getMile() >= MILES) {
				return true;
			}
		}
		return false;
	}

	private void print() {
		for (Horse h : horses) {
			h.print();
		}
	}
}
