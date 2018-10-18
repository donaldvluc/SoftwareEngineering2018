package edu.nd.se2018.homework.hwk6.Challenges;

import java.awt.Point;

public abstract class Grid {
	int[][] grid;
	int nChips;
	Point init;
	Point target;
	public Grid() {};
	public int[][] getGrid() { return grid; }
	public int getChips() { return nChips; }
	public Point getInit() { return init; }
	public Point getTarget() { return target; }
}
