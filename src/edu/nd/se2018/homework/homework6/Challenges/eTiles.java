package edu.nd.se2018.homework.homework6.Challenges;

/*
 * Author: Donald Luc
 * Source: https://codingexplained.com/coding/java/enum-to-integer-and-integer-to-enum
 */

import java.util.HashMap;
import java.util.Map;

public enum eTiles {
	BLANK(0, "images\\blankTile.PNG"),
	B_KEY(1, ""),
	B_WALL(2, ""),
	CHIP(3, ""),
	WALL(4, "images\\grayWall.PNG"),
	G_KEY(5, ""),
	G_WALL(6, ""),
	PORTAL(7, ""),
	R_KEY(8, ""),
	R_WALL(9, ""),
	Y_KEY(11, ""),
	Y_WALL(12, "");
	
	
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
	
	public String getURI() {
		return uri;
	}
}
