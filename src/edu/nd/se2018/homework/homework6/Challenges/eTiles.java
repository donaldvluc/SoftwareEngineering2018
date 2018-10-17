package edu.nd.se2018.homework.homework6.Challenges;

/*
 * Author: Donald Luc
 * Source: https://codingexplained.com/coding/java/enum-to-integer-and-integer-to-enum
 */

import java.util.HashMap;
import java.util.Map;

public enum eTiles {
	BLANK(0, "images\\blankTile.PNG"),
	B_KEY(1, "images\\blueKey.PNG"),
	B_WALL(2, "images\\blueKeyWall.PNG"),
	CHIP(3, "images\\chipItem.PNG"),
	WALL(4, "images\\grayWall.PNG"),
	G_KEY(5, "images\\greenKey.PNG"),
	G_WALL(6, "images\\greenKeyWall.PNG"),
	PORTAL(7, "images\\portal.PNG"),
	R_KEY(8, "images\\redKey.PNG"),
	R_WALL(9, "images\\redKeyWall.PNG"),
	Y_KEY(11, "images\\yellowKey.PNG"),
	Y_WALL(12, "images\\yellowKeyWall.PNG");
	
	
	private final int value;
	private final String uri;
	private static Map<Integer, eTiles> eMap = new HashMap<>();
	private static Map<Integer, String> sMap = new HashMap<>();
	
	private eTiles(int v, String u) {
		value = v;
		uri = u;
	}
	
	static {
		for (eTiles tiles : eTiles.values()) {
			eMap.put(tiles.value, tiles);
			sMap.put(tiles.value, tiles.uri);
		}
	}

	public static eTiles valueOf(int n) {
		return (eTiles) eMap.get(n);
	}
	
	public static String stringOf(int n) {
		return (String) sMap.get(n);
	}

	public int getType() {
		return value;
	}
}
