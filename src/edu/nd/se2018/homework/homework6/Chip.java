package edu.nd.se2018.homework.homework6;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Chip {
	
	// Private Members:
	private Point pos;
	private int size;
	private int chips;

	private Image chipUp;
	private Image chipDown;
	private Image chipLeft;
	private Image chipRight;
	private ImageView imageView;
	
	// Constructor:
	public Chip(int s, int c){
		size = s;
		chips = c;
		pos = new Point(0, 0);
		
		chipUp = new Image("images\\chipUp.PNG", size, size, true, true);
		chipDown = new Image("images\\chipDown.PNG", size, size, true, true);
		chipLeft = new Image("images\\chipLeft.PNG", size, size, true, true);
		chipRight = new Image("images\\chipRight.PNG", size, size, true, true);
		imageView = new ImageView(chipUp);
		imageView.setX(pos.x);
		imageView.setY(pos.y);
	}

	public int getX() { return pos.x; }

	public int getY() { return pos.y; }

	public void moveUp() {
		pos.y -= 1;
		imageView.setImage(chipUp);
	}

	public void moveDown() {
		pos.y += 1;
		imageView.setImage(chipDown);
	}

	public void moveLeft() {
		pos.x -= 1;
		imageView.setImage(chipLeft);
	}

	public void moveRight() {
		pos.x += 1;
		imageView.setImage(chipRight);
	}
	
	public ImageView getImageView() {
		return imageView;
	}

	public void updateImageView() {
		imageView.setX(getX()*size);
		imageView.setY(getY()*size);
	}
}
