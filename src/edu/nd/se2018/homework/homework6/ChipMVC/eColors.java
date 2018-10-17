package edu.nd.se2018.homework.homework6.ChipMVC;

public enum eColors {
	BLUE(0),
	GREEN(1),
	RED(2),
	YELLOW(3),
	NCOLORS(4);
	
	private int value;
	
	private eColors(int v) {
		value = v;
	}
	
	public int getValue() {
		return value;
	}
}
