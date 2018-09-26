package edu.nd.se2018.homework.hwk5.railwaycrossing.model.vehicles;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import edu.nd.se2018.homework.hwk5.railwaycrossing.model.infrastructure.gate.CrossingGate;
import edu.nd.se2018.homework.hwk5.railwaycrossing.view.CarImageSelector;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 * Represents Car object
 * @author jane
 * README.md: Mention the turn Booleans and how it is randomized in constructor.
 *
 */
public class Car extends Observable implements IVehicle, Observer{
	private ImageView ivCar;
	private double currentX = 0;
	private double currentY = 0;
	private double originalY = 0;
	private boolean gateDown = false;
	private double leadCarY = -1;  // Current Y position of car directly infront of this one.
	private double speed = 0.5;
	private Boolean willTurn = false;  // Boolean for turning onto road EastWest randomized at Constructor.
	private Boolean turn = false;      // Boolean for checking if car is at EastWest intersection.

	/**
	 * Constructor
	 * @param x initial x coordinate of car
	 * @param y initial y coordinate of car
	 */
	public Car(int x, int y){
		this.currentX = x;
		this.currentY = y;
		originalY = y;
		ivCar = new ImageView(CarImageSelector.getImage());
		ivCar.setX(getVehicleX());
		ivCar.setY(getVehicleY());
		
		// The percent chance out of 100 to turn onto EastWest highway.
		Random r = new Random();
		int n = r.ints(0, 100).limit(1).findFirst().getAsInt();
		if (n < 25)
			this.willTurn = true;
	}
		
	@Override
	public Node getImageView() {
		return ivCar;
	}
	
	public boolean gateIsClosed(){
		return gateDown;
	}
	
	public double getVehicleX(){
		return currentX;
	}
	public double getVehicleY(){
		return currentY;
	}
	
	public void move(){
		boolean canMove = true; 
		
		// First case.  Car is at the front of the stopping line.
		if (gateDown && getVehicleY() < 430 && getVehicleY()> 390)
			canMove = false;
		
		// Second case. Car is too close too other car.
		if (leadCarY != -1  && getDistanceToLeadCar() < 50)
			canMove = false;
		
		if (canMove){
			if (!turn) { // Moving down.
				currentY+=speed;
				ivCar.setY(currentY);
			} else { // Moving left.
				currentX-=speed;
				ivCar.setX(currentX);
			}
		}
		setChanged();
		notifyObservers();
	}
	
	public void setSpeed(double speed){
		this.speed = speed;
	}
	
	public void setGateDownFlag(boolean gateDown){
		this.gateDown = gateDown;
	}
	
	public boolean offScreen(){
		if (currentY > 1020)
			return true;
		else
			return false;			
	}
		
	public void reset(){
		currentY = originalY;
	}
	
	public double getDistanceToLeadCar(){
		return Math.abs(leadCarY-getVehicleY());
	}
	
	public void removeLeadCar(){
		leadCarY = -1;
	}
	
	// Turn the car onto road EastWest.
	public void setTurn(Boolean flag) {
		turn = flag;
	}
	
	public Boolean getTurn() {
		return turn;
	}
	
	public Boolean getWillTurn() {
		return willTurn;
	}

	@Override
	public void update(Observable o, Object arg1) {
		if (o instanceof Car){
			Car car = (Car)o;
			leadCarY = car.getVehicleY();
			
			// Check if car is out of display or turning, then remove observable.
			if (leadCarY > 1020 || car.getTurn()) { // 1020 is magic number from jane.
				leadCarY = -1;
				car.deleteObserver(this);
			}
		}
			
		if (o instanceof CrossingGate){
			CrossingGate gate = (CrossingGate)o;
			if(gate.getTrafficCommand()=="STOP")			
				gateDown = true;
			else
				gateDown = false;
					
		}				
	}	
}
