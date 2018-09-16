package edu.nd.se2018.homework.hwk3.ColumbusGame;

import java.awt.Point;
import java.util.Observable;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Ship extends Observable {
	int size = 25;
	Point position;
	OceanMap oceanMap;
	Image shipImage;
	ImageView shipImageView;

	public Ship(int s, OceanMap map) {
		// Set Members:
		size = s;
		oceanMap = map;
		
		// Set Ship Position:
		while (true) {
			Random r = new Random();
			int x = r.ints(0, size).limit(1).findFirst().getAsInt();
			int y = r.ints(0, size).limit(1).findFirst().getAsInt();
			if (oceanMap.isOceanObject(x*size, y*size, OceanObjects.OPEN)) {
				position = new Point(x*size, y*size);
				oceanMap.setOceanCell(position.x/size, position.y/size, OceanObjects.SHIP);
				break;
			}
		}

		// Set Ship Image:
		shipImage = new Image("images\\ColumbusShip.png",size,size,true,true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(position.x);
		shipImageView.setY(position.y);
	}

	public Point getPosition() {
		return position;
	}
	
	public ImageView getShipImageView() {
		return shipImageView;
	}
	
	public void goEast() {
		if (position.x+size < size*size && oceanMap.isOceanObject(position.x+size, position.y, OceanObjects.OPEN)) 
		{
			oceanMap.setOceanCell(position.x/size, position.y/size, OceanObjects.OPEN);
			position.x += size;
			oceanMap.setOceanCell(position.x/size, position.y/size, OceanObjects.SHIP);
			movePirates();
		}
	}
	
	public void goWest() {
		if (position.x-size >= 0 && oceanMap.isOceanObject(position.x-size, position.y, OceanObjects.OPEN)) 
		{
			oceanMap.setOceanCell(position.x/size, position.y/size, OceanObjects.OPEN);
			position.x -= size;
			oceanMap.setOceanCell(position.x/size, position.y/size, OceanObjects.SHIP);
			movePirates();
		}
	}
	
	public void goNorth() {
		if (position.y-size >= 0 && oceanMap.isOceanObject(position.x, position.y-size, OceanObjects.OPEN)) 
		{
			oceanMap.setOceanCell(position.x/size, position.y/size, OceanObjects.OPEN);
			position.y -= size;
			oceanMap.setOceanCell(position.x/size, position.y/size, OceanObjects.SHIP);
			movePirates();
		}
	}
	
	public void goSouth() {
		if (position.y+size < size*size && oceanMap.isOceanObject(position.x, position.y+size, OceanObjects.OPEN)) 
		{
			oceanMap.setOceanCell(position.x/size, position.y/size, OceanObjects.OPEN);
			position.y += size;
			oceanMap.setOceanCell(position.x/size, position.y/size, OceanObjects.SHIP);
			movePirates();
		}
	}
	
	private void movePirates() {
		setChanged();
		notifyObservers();
	}
}
