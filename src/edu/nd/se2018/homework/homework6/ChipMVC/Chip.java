package edu.nd.se2018.homework.homework6.ChipMVC;

import java.awt.Point;
import java.util.Observable;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class Chip extends Observable {
	
	// Private Members:
	private Point pos;
	private int size;
	private int chips;
	private KeyCode dir;
	private ChipImage chipImage;
	
	// Constructor:
	public Chip(int s, int c){
		size = s;
		chips = c;
		pos = new Point(0, 0);
		chipImage = new ChipImage(size);
		addObserver(chipImage);
	}

	public int getX() { return pos.x; }

	public int getY() { return pos.y; }
	
	public KeyCode getDir() { return dir; }
	
	public void reset() { pos = new Point(0, 0); }

	public void moveUp(KeyCode c) {
		if (pos.y > 0) {
			pos.y -= 1;
			dir = c;	
		}
	}

	public void moveDown(KeyCode c) {
		if (pos.y < size) {
			pos.y += 1;
			dir = c;
		}
	}

	public void moveLeft(KeyCode c) {
		if (pos.x > 0) {
			pos.x -= 1;
			dir = c;
		}
	}

	public void moveRight(KeyCode c) {
		if (pos.x < size) {
			pos.x += 1;
			dir = c;
		}
	}
	
	public ImageView getImageView() {
		return chipImage.getImageView();
	}

	public void updateImage() {
		setChanged();
		notifyObservers();
	}
	
	public Boolean isDone() {
		System.out.println(pos);
		return pos.x == 3 && pos.y == 6;
	}
}
