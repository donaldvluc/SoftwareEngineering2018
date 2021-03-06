package edu.nd.se2018.homework.hwk3.ColumbusGame;

import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class OceanMap {
	// Private Members:
	int dimensions = 25;
	int squared_dimensions = dimensions*dimensions;
	int nIslands = 10;
	OceanObjects[][] oceanGrid = new OceanObjects[dimensions][dimensions];
	
	

	public OceanMap(int d, int i) {
		dimensions = d;
		nIslands = i;
	}
	
	public void drawMap(ObservableList<Node> root, int size) {
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x*size,y*size,size,size);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.PALETURQUOISE);
				root.add(rect);
				oceanGrid[x][y] = OceanObjects.OPEN;
			}
		}
	}
	
	public void randomizeIslands(ObservableList<Node> root) {
		for (int i = 0; i < nIslands; i++) {
			while(true) {
				Random r = new Random();
				int x = r.ints(0, dimensions).limit(1).findFirst().getAsInt();
				int y = r.ints(0, dimensions).limit(1).findFirst().getAsInt();
				if (oceanGrid[x][y] == OceanObjects.OPEN) {
					oceanGrid[x][y] = OceanObjects.ISLAND;
					Rectangle rect = (Rectangle) root.get(x*(dimensions)+y);
					rect.setFill(Color.DARKGREEN);
					break;
				}
			}
		}
	}
	
	public void setOceanCell(int x, int y, OceanObjects object) {
		oceanGrid[x][y] = object;
	}
	
	public Boolean isOceanObject(int x, int y, OceanObjects object) {
		int cellX = x / dimensions;
		int cellY = y / dimensions;
		return oceanGrid[cellX][cellY] == object;
	}
}
