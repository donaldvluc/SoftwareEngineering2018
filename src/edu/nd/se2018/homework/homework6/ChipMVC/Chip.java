package edu.nd.se2018.homework.homework6.ChipMVC;

import java.awt.Point;
import java.util.Observable;

import edu.nd.se2018.homework.homework6.Challenges.eTiles;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class Chip extends Observable {
	
	// Private Members:
	private Point pos;
	private int size;
	private int[][] map;
	private KeyCode dir;
	private ChipImage chipImage;
	
	// Constructor:
	public Chip(int s, Point init, int[][] m){
		size = s;
		pos = init;
		map = m;
		chipImage = new ChipImage(size, pos);
		addObserver(chipImage);
	}

	public int getX() { return pos.x; }

	public int getY() { return pos.y; }
	
	public KeyCode getDir() { return dir; }
	
	public void reset() { pos = new Point(0, 0); }

	public void moveUp(KeyCode c) {
		int next = pos.y - 1;
		if (pos.y > 1) { // In bounds of outer walls.
			if (checkMove(pos.x, next)) {
				pos.y = next;
				dir = c;	
			}
		}
	}

	public void moveDown(KeyCode c) {
		int next = pos.y + 1;
		if (pos.y < size-2) { // In bounds of outer walls.
			if (checkMove(pos.x, next)) {
				pos.y = next;
				dir = c;
			}
		}
	}



	public void moveLeft(KeyCode c) {
		int next = pos.x - 1;
		if (pos.x > 1) { // In bounds of outer walls.
			if (checkMove(next, pos.y)) {
				pos.x = next;
				dir = c;
			}
		}
	}

	public void moveRight(KeyCode c) {
		int next = pos.x + 1;
		if (pos.x < size-2) { // In bounds of outer walls.
			if (checkMove(next, pos.y)) {
				pos.x = next;
				dir = c;
			}
		}
	}
	
	private boolean checkMove(int x, int y) {
		int tile = map[x][y];
		eTiles eTile = eTiles.valueOf(tile);
		if (eTile == eTiles.BLANK)
			return true;
		return false;
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
