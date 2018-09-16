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
		int oldX = position.x;
		int oldY = position.y;
		Random r = new Random();
		int n = r.ints(0, 2).limit(1).findFirst().getAsInt();
		switch(n) {
		case 0:
			if (target.x - position.x > 0 && oceanMap.isOceanObject(position.x+size, position.y, OceanObjects.OPEN)) {
				position.x += size;
			} else if (target.x - position.x < 0 && oceanMap.isOceanObject(position.x-size, position.y, OceanObjects.OPEN)) {
				position.x -= size;
			} else if (target.y - position.y < 0 && oceanMap.isOceanObject(position.x, position.y-size, OceanObjects.OPEN)) {
				position.y -= size;
			} else if (target.y - position.y > 0 && oceanMap.isOceanObject(position.x, position.y+size, OceanObjects.OPEN)) {
				position.y += size;
			}
			break;
		case 1:
			if (target.y - position.y < 0 && oceanMap.isOceanObject(position.x, position.y-size, OceanObjects.OPEN)) {
				position.y -= size;
			} else if (target.y - position.y > 0 && oceanMap.isOceanObject(position.x, position.y+size, OceanObjects.OPEN)) {
				position.y += size;
			} else if (target.x - position.x > 0 && oceanMap.isOceanObject(position.x+size, position.y, OceanObjects.OPEN)) {
				position.x += size;
			} else if (target.x - position.x > 0 && oceanMap.isOceanObject(position.x-size, position.y, OceanObjects.OPEN)) {
				position.x -= size;
			}
			break;
		default:
			break;
		}
		oceanMap.setOceanCell(oldX/size, oldY/size, OceanObjects.OPEN);
		oceanMap.setOceanCell(position.x/size, position.y/size, OceanObjects.PIRATE);
		pirateImageView.setX(position.x);
		pirateImageView.setY(position.y);
	}
	
	
	
	@Override
	public void update(Observable s, Object arg1) {
		if (s instanceof Ship) {
			target = ((Ship) s).getPosition();
			movePirate();
		}
	}
}
