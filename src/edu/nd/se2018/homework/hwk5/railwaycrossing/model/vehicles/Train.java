package edu.nd.se2018.homework.hwk5.railwaycrossing.model.vehicles;

import java.util.Observable;

import edu.nd.se2018.homework.hwk5.railwaycrossing.model.infrastructure.Direction;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents the train entity object
 * @author jane
 *
 */
public class Train extends Observable implements IVehicle{
	private double currentX = 0;
	private double currentY = 0;
	private double originalX = 0;
	private Image img;
	private ImageView imgView;
	private int trainLength = 35;
	private Direction dir;
	
	public Train(int x, int y, Direction d){
		this.currentX = x;
		this.currentY = y;
		this.dir = d;
		originalX = x;
		img = new Image("images\\Train.PNG",120,trainLength,false,false);
		imgView = new ImageView(img);
		if (dir == Direction.EAST)
			imgView.setScaleX(-1); // Else train moving west is not reversed.
		imgView.setX(currentX);
		imgView.setY(currentY);
	}
	
	public double getVehicleX(){
		return currentX;
	}
	
	public double getVehicleY(){
		return currentY;
	}
	
	public Direction getDirection() {
		return dir;
	}
	
	public void move(){
		if (dir == Direction.WEST)
			currentX-=2;
		else
			currentX+=2;
		imgView.setX(currentX);
		setChanged();
		notifyObservers();
	}
	
	public boolean offScreen(){
		if (dir == Direction.WEST) {
			if (currentX < -200)
				return true;
			else
				return false;	
		}
		else {
			if (currentX > 1400)
				return true;
			else
				return false;	
		}			
	}
	
	public void reset(){
		currentX = originalX;
	}

	//@Override
	public Node getImageView() {
		return imgView;
	}
}