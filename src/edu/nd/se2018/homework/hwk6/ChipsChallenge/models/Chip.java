package edu.nd.se2018.homework.hwk6.ChipsChallenge.models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Chip implements iMovement {

	// Private Members:
	private int x = 1;
	private int y = 1;
	private int size;
	private int chips;
	private ImageView imageView;
//	private int[4] keys

	public Chip(int s){
		size = s;
		imageView = new ImageView(new Image("edu\\nd\\se2018\\homework\\hwk6\\textures\\chipUp.PNG", 25, 25, true, true));
	}
	
	@Override
	public int getX() { return x; }

	@Override
	public int getY() { return y; }

	@Override
	public void moveUp() {
		y = y - size;
		imageView.setImage(new Image("edu\\nd\\se2018\\homework\\hwk6\\textures\\chipUp.PNG", 25, 25, true, true));
	}

	@Override
	public void moveDown() {
		y = y + size;
		imageView.setImage(new Image("edu\\nd\\se2018\\homework\\hwk6\\textures\\chipDown.PNG", 25, 25, true, true));
	}

	@Override
	public void moveLeft() {
		x = x - size;
		imageView.setImage(new Image("edu\\nd\\se2018\\homework\\hwk6\\textures\\chipLeft.PNG", 25, 25, true, true));
	}

	@Override
	public void moveRight() {
		x = x + size;
		imageView.setImage(new Image("edu\\nd\\se2018\\homework\\hwk6\\textures\\chipRight.PNG", 25, 25, true, true));
	}
	
	public ImageView getImageView() {
		return imageView;
	}
	
	public void updateImageView() {
		imageView.setX(getX());
		imageView.setY(getY());
	}

}
