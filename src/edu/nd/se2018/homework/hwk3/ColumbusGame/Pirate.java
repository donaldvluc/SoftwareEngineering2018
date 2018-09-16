package edu.nd.se2018.homework.hwk3.ColumbusGame;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pirate implements Observer {
	int size = 25;
	Point position;
	Point target;
	OceanMap oceanMap;
	Image pirateImage;
	ImageView pirateImageView;

	public Pirate(int s, OceanMap map) {
		// Set Members:
		size = s;
		oceanMap = map;
		
		// Set Pirate Position:
		while (true) {
			Random r = new Random();
			int x = r.ints(0, size).limit(1).findFirst().getAsInt();
			int y = r.ints(0, size).limit(1).findFirst().getAsInt();
			if (!oceanMap.isOceanObject(x*size, y*size, OceanObjects.ISLAND)) {
				position = new Point(x*size, y*size);
				oceanMap.setOceanCell(x, y, OceanObjects.PIRATE);
				break;
			}
		}
		
		// Set Pirate Image:
		pirateImage = new Image("images\\pirateship.gif",size,size,true,true);
		pirateImageView = new ImageView(pirateImage);
		pirateImageView.setX(position.x);
		pirateImageView.setY(position.y);
	}
	
	public ImageView getPirateImageView() {
		return pirateImageView;
	}

	private void movePirate() {
		System.out.println("wut");
		Random r = new Random();
		int n = r.ints(0, 1).limit(1).findFirst().getAsInt();
		switch(n) {
		case 0:
			if (target.x - position.x > 0 && !oceanMap.isOceanObject(position.x+1, position.y, OceanObjects.ISLAND)) {
				position.x--;
			} else {
				position.x++;
			}
			break;
		case 1:
			break;
		}
		pirateImageView.setX(position.x);
		pirateImageView.setY(position.y);
	}
	
	@Override
	public void update(Observable s, Object arg1) {
		System.out.println("yes");
		if (s instanceof Ship) {
			System.out.println("no?");
			target = ((Ship) s).getPosition();
			movePirate();
		}
	}
}
