package edu.nd.se2018.homework.hwk5.railwaycrossing.model.infrastructure.gate;

import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.hwk5.railwaycrossing.model.infrastructure.Direction;
import edu.nd.se2018.homework.hwk5.railwaycrossing.model.vehicles.Train;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Context class for Crossing Gate
 * @author jane
 *
 */
public class CrossingGate extends Observable implements Observer{
	
	// Crossing Gate location and its trigger & exit points
	private int anchorX;
	private int anchorY;
	private int movingX;
	private int movingY;
	private int triggerPoint;
	private int exitPoint;

	private IGateState gateClosed;
	private IGateState gateOpen;
	private IGateState gateClosing;
	private IGateState gateOpening;
	private IGateState currentGateState;
	private Line line; 
	private Pane root;
	private Direction dir;
	private int delta = 200;
	
	String gateName;
	
	public CrossingGate(){}
	
	public CrossingGate(int xPosition, int yPosition, String crossingGate, Direction d){		
		anchorX = xPosition;
		anchorY = yPosition;
		movingX = anchorX;
		movingY = anchorY-60;
		dir = d; // Either East or West Gate.
		triggerPoint = anchorX; // Used with delta in update().
		exitPoint = anchorX; // Used with delta in update().
		// Gate elements
		line = new Line(anchorX, anchorY,movingX,movingY);
		line.setStroke(Color.RED);
	    line.setStrokeWidth(10);
		
		// Gate States
		gateClosed = new GateClosed(this);
		gateOpen = new GateOpen(this);
		gateOpening = new GateOpening(this);
		gateClosing = new GateClosing(this);
		currentGateState = gateOpen;
		gateName = crossingGate;
	}
	
	public Line getGateLine(){
		return line;
	}
	
	public void operateGate(){
		currentGateState.operate();
	}
	
	public void close(){
		if (movingY<anchorY){		
		    movingX+=1;
		    movingY+=1;
			line.setStartX(anchorX);
			line.setStartY(anchorY);
			line.setEndX(movingX);
			line.setEndY(movingY);
		} else {
			currentGateState.gateFinishedOpening();
		}
	}
	
	public void open(){
		if (movingX>anchorX){
			movingX-=1;
			movingY-=1;		
			line.setStartX(anchorX);
			line.setStartY(anchorY);
			line.setEndX(movingX);
			line.setEndY(movingY);
		}  else {
			currentGateState.gateFinishedOpening();
		}
	}
	
	// State getters and setters
	public IGateState getGateClosedState(){
		return gateClosed;
	}
	public IGateState getGateOpenState(){
		return gateOpen;
	}
	public IGateState getGateClosingState(){
		return gateClosing;
	}
	public IGateState getGateOpeningState(){
		return gateOpening;
	}
	
	public void setGateState(IGateState newState){
		currentGateState = newState;
		setChanged();
		notifyObservers();
	}
	
	public String getTrafficCommand(){
		return currentGateState.getTrafficAction();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Train){
			Train train = (Train)o;
			
			// Calculate exit and trigger points based on train direction.
			int exit = this.exitPoint;
			int trigger = this.triggerPoint;
			int leftBound = exit; // The bound to the left of exit.
			int rightBound = trigger; // The bound to the right of trigger.
			if (train.getDirection() == Direction.WEST) { // Westbound train.
				exit -= delta/2;
				trigger += delta;
				leftBound = exit-delta/4;
				rightBound = trigger-delta/4;
			} else { // Eastbound train.
				exit += delta/2;
				trigger -= delta;
				leftBound = exit+delta/4;
				rightBound = trigger+delta/4;
			}
			
			// Check direction of train and if train is within |exit-leftBound| and |trigger-rightBound| for state change.
			if (train.getDirection() == Direction.WEST) {
				if (train.getVehicleX() < exit && train.getVehicleX() > leftBound)
					currentGateState.leaveStation();
				else if(train.getVehicleX() < trigger && train.getVehicleX() > rightBound)
					currentGateState.approachStation();
			} else { // Eastbound train.
				if (train.getVehicleX() > exit && train.getVehicleX() < leftBound)
					currentGateState.leaveStation();
				else if(train.getVehicleX() > trigger && train.getVehicleX() < rightBound)
					currentGateState.approachStation();
			}
		}
	}
}
