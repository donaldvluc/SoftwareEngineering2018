package edu.nd.se2018.homework.homework6.Challenges;

import java.awt.Point;

public class GridOne extends Grid {
	public GridOne() {
		init = new Point(1, 1);
		target = new Point (13, 11);
		grid = new int[][] {
		//                               Left Side
		//  { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24}
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, //  0
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4}, //  1
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4}, //  2
			{ 4, 0, 0, 4, 4, 4, 4, 4, 4, 4, 0, 0, 4, 0, 0, 4, 4, 4, 4, 4, 4, 4, 0, 0, 4}, //  3
			{ 4, 0, 0, 4, 0, 0, 4, 0, 0, 4, 0, 0, 4, 0, 0, 4, 0, 0, 4, 8, 0, 0, 0, 0, 4}, //  4
			{ 4, 0, 0, 4, 0, 4, 1, 4, 0, 4, 0, 0, 2, 0, 0, 4, 0, 0, 4, 4, 0, 0, 0, 0, 4}, //  5
			{ 4, 0, 0, 0, 4, 4, 0, 4, 4, 0, 0, 0, 4, 0, 0, 0, 4, 4, 0, 0, 4, 4, 0, 0, 4}, //  6
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4}, //  7
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4}, //  8
			{ 4, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 4}, //  9
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4}, // 10  B
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4}, // 11  o
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 9, 4, 4, 4, 4, 4}, // 12  t
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 7, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4}, // 13
			{ 4, 0, 3, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4}, // 14
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 4}, // 15
			{ 4, 0, 0, 0, 4, 4, 4, 4, 4, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 4}, // 16
			{ 4, 0, 0, 4, 0, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 4, 3, 0, 0, 0, 0, 0, 4}, // 17
			{ 4, 0, 0, 4, 0, 0, 0, 0, 0, 4, 0, 0,12, 0, 0, 0, 0,11, 4, 4, 4, 4, 0, 0, 4}, // 18
			{ 4, 0, 0, 4, 0, 3, 0, 4, 0, 4, 0, 0, 4, 0, 0, 0, 0, 4, 3, 0, 0, 0, 0, 0, 4}, // 19
			{ 4, 0, 0, 4, 0, 0, 0, 4, 5, 4, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 4}, // 20
			{ 4, 0, 0, 0, 0, 0, 0, 4, 4, 0, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 4}, // 21
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4}, // 22
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4}, // 23
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, // 24
		//                                  Right Side
		};
	}	
}
