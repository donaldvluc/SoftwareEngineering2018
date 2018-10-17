package edu.nd.se2018.homework.homework6.ChipMVC;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChipImage implements Observer {

	// Private Members:
	private int size;
	private Image chipUp;
	private Image chipDown;
	private Image chipLeft;
	private Image chipRight;
	private ImageView imageView;
	
	// Constructor:
	public ChipImage(int s, Point p) {
		size = s;
		chipUp = new Image("images\\chipUp.PNG", size, size, true, true);
		chipDown = new Image("images\\chipDown.PNG", size, size, true, true);
		chipLeft = new Image("images\\chipLeft.PNG", size, size, true, true);
		chipRight = new Image("images\\chipRight.PNG", size, size, true, true);
		imageView = new ImageView(chipUp);
		imageView.setX(p.x*size);
		imageView.setY(p.y*size);
	}
	
	
	public ImageView getImageView() { return imageView; }
	
	
	@Override
	public void update(Observable o, Object arg1) {
		if (o instanceof Chip) {
			Chip chip = (Chip)o;
			imageView.setX(chip.getX()*size);
			imageView.setY(chip.getY()*size);
			switch (chip.getDir()) {
			case UP:
				imageView.setImage(chipUp);
				break;
			case DOWN:
				imageView.setImage(chipDown);
				break;
			case LEFT:
				imageView.setImage(chipLeft);
				break;
			case RIGHT:
				imageView.setImage(chipRight);
				break;
			default:
				break;
			}
		}
	}

}
