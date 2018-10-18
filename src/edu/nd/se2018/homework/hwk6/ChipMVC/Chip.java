package edu.nd.se2018.homework.hwk6.ChipMVC;

import java.awt.Point;
import java.util.Observable;

import edu.nd.se2018.homework.hwk6.Challenges.eTiles;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class Chip extends Observable {
	
	// Private Members:
	private Point pos;
	private Point init;
	private int size;
	private int[] keys = new int[] {0, 0, 0, 0} ;
	private int[][] grid;
	private KeyCode dir;
	private ChipImage chipImage;
	
	// Constructor:
	public Chip(int s, Point i, int[][] g){
		size = s;
		init = i;
		pos = init;
		grid = g;
		chipImage = new ChipImage(size, pos);
		addObserver(chipImage);
	}

	public int getX() { return pos.x; }

	public int getY() { return pos.y; }
	
	public Point getPos() { return pos; }
	
	public KeyCode getDir() { return dir; }
	
	public int[] getKeys() { return keys; }
	
	public int getKey(int index) { return keys[index]; }
	
	public void reset() { pos = init; }

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
	
	private Boolean checkMove(int x, int y) {
		Boolean flag = true;
		int tile = grid[x][y];
		eTiles eTile = eTiles.valueOf(tile);
		if (eTile == eTiles.WALL)
			flag = false;
		else {
			switch (eTile) {
			case B_KEY:
				keys[eColors.BLUE.getValue()]++;
				flag = true;
				break;
			case G_KEY:
				keys[eColors.GREEN.getValue()]++;
				flag = true;
				break;
			case R_KEY:
				keys[eColors.RED.getValue()]++;
				flag = true;
				break;
			case Y_KEY:
				keys[eColors.YELLOW.getValue()]++;
				flag = true;
				break;
			case B_WALL:
				if (keys[eColors.BLUE.getValue()] == 0)
					flag = false;
				break;
			case G_WALL:
				if (keys[eColors.GREEN.getValue()] == 0)
					flag = false;
				break;
			case R_WALL:
				if (keys[eColors.RED.getValue()] == 0)
					flag = false;
				break;
			case Y_WALL:
				if (keys[eColors.YELLOW.getValue()] == 0)
					flag = false;
				break;
			default:
				break;
			}
		}
		return flag;
	}
	
	public ImageView getImageView() {
		return chipImage.getImageView();
	}

	public void updateImage() {
		setChanged();
		notifyObservers();
	}
}
