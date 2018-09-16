package edu.nd.se2018.homework.hwk3.ColumbusGame;

import java.awt.Dimension;
import java.awt.Point;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

public class Ship {
	int size = 25;
	Point position;
	OceanMap oceanMap;

	public Ship(int s, OceanMap map) {
		size = s;
		int origin = size*size/2-size/2;
		position = new Point(origin, origin);
		oceanMap = map;
	}

	public Point getPosition() {
		return position;
	}
	
	public void goEast() {
		int cellX = (position.x - size/2) / size;
		int cellY = (position.y - size/2) / size;
		OceanObjects cell = oceanMap.getOceanGrid()[cellX][cellY];
		if (position.x+size < size*size && cell != OceanObjects.ISLAND) {
			position.x += size;
		}
	}
	
	public void goWest() {
		if (position.x-size >= 0) {
			position.x -= size;
		}
	}
	
	public void goNorth() {
		if (position.y-size >= 0) {
			position.y -= size;
		}
	}
	
	public void goSouth() {
		if (position.y+size < size*size) {
			position.y += size;
		}
	}
}
