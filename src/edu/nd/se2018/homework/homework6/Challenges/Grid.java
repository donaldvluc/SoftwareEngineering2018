package edu.nd.se2018.homework.homework6.Challenges;

import java.awt.Point;

public abstract class Grid {
	int[][] grid;
	Point init;
	Point target;
	public Grid() {};
	public int[][] getGrid() { return grid; }
	public Point getInit() { return init; }
	public Point getTarget() { return target; }
}
