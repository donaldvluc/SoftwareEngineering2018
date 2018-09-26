package edu.nd.se2018.homework.hwk5.railwaycrossing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.LinkedList;

import edu.nd.se2018.homework.hwk5.railwaycrossing.model.infrastructure.Direction;
import edu.nd.se2018.homework.hwk5.railwaycrossing.model.infrastructure.MapBuilder;
import edu.nd.se2018.homework.hwk5.railwaycrossing.model.infrastructure.RailwayTracks;
import edu.nd.se2018.homework.hwk5.railwaycrossing.model.infrastructure.Road;
import edu.nd.se2018.homework.hwk5.railwaycrossing.model.infrastructure.gate.CrossingGate;
import edu.nd.se2018.homework.hwk5.railwaycrossing.model.vehicles.Car;
import edu.nd.se2018.homework.hwk5.railwaycrossing.model.vehicles.Train;
import edu.nd.se2018.homework.hwk5.railwaycrossing.view.MapDisplay;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Simulation extends Application{
	
	private Pane root;
	private Scene scene;
	private MapBuilder mapBuilder;
	private MapDisplay mapDisplay;
	private List<Train> trains = new ArrayList<>(); // Two trains: Westbound and newly added Eastboud.
	private LinkedList<Car> crossingCars = new LinkedList<>(); // The cars crossing the EastWest highway.
	
	@Override  
	public void start(Stage stage) throws Exception {
		
		root = new Pane();
		
		// Build infrastructure
		mapBuilder = new MapBuilder();
		mapDisplay = new MapDisplay(root, mapBuilder.getRoads(), mapBuilder.getTracks(),mapBuilder.getAllGates());					
		mapDisplay.drawTracks();		
		mapDisplay.drawRoad();
		mapDisplay.drawGate();
		
		scene = new Scene(root,1200,1000);
		stage.setTitle("Railways");
		stage.setScene(scene);
		stage.show();
		
		
		// Create train tracks and trains 
		createTrains(root);
		
		for(CrossingGate gate: mapBuilder.getAllGates()) {
			for(Train train: trains) {
				train.addObserver(gate);
			}
		}	
				
		// Sets up a repetitive loop i.e., in handle that runs the actual simulation
		new AnimationTimer(){

			@Override
			public void handle(long now) {
			
				createCar();
				
				for(Train train: trains)
					train.move();
				
				for(CrossingGate gate: mapBuilder.getAllGates())
					gate.operateGate();
				
				for(Train train: trains) {
					if (train.offScreen())
						train.reset();
				}

				// Randomize car on east road, Skyway, to cross road, EastWest.
				for (Car car: mapBuilder.getRoad("Skyway").getCarFactory().getCars()) {
					// Car is in range of turn so turn if randomized willTurn variable is set to true.
					if (car.getVehicleY() > mapBuilder.getRoad("EastWest").getStartY()-10 && car.getWillTurn()) {
						
						car.setTurn(true);
						if (!crossingCars.contains(car)) {
							if (crossingCars.size() != 0)
								crossingCars.getLast().addObserver(car);
							crossingCars.add(car);
						}

						if (car.getVehicleX() < mapBuilder.getRoad("Western Highway").getStartX()-10)
							car.setTurn(false);
					}
				}

				clearCars();				
			}
		}.start();
	}
	
	// Create two trains "Royal" and "Park".
	private void createTrains(Pane root) {
		// Get railways "Royal" and "Park".
		RailwayTracks trackRoyal = mapBuilder.getTrack("Royal");
		RailwayTracks trackPark = mapBuilder.getTrack("Park");
		
		// Create trains "Royal" and "Park".
		Train trainRoyal = new Train(trackRoyal.getEndX()+100,trackRoyal.getEndY()-25, Direction.WEST); // Train moves east to west.
		Train trainPark = new Train(trackPark.getStartX()-100,trackPark.getStartY()-25, Direction.EAST); // Train moves west to east.
		trains.add(trainRoyal);
		trains.add(trainPark);
		
		// Add trains to the root.
		root.getChildren().add(trainRoyal.getImageView());
		root.getChildren().add(trainPark.getImageView());
	}
	
	
	// Clears cars as they leave the simulation.
	private void clearCars(){
		Collection<Road> roads = mapBuilder.getRoads();
		for(Road road: roads){			
			if (road.getCarFactory()!= null){
				ArrayList<Car> junkCars = road.getCarFactory().removeOffScreenCars();	
				mapDisplay.removeCarImages(junkCars);
			}
		}
	}
	
	// Creates random colored cars onto each road.
	private void createCar(){
		Collection<Road> roads = mapBuilder.getRoads();
		for(Road road: roads){
			if (road.getCarFactory() != null){
				if ((int)(Math.random() * 100) == 15){
					Car car = road.getCarFactory().buildCar();
					if (car != null){
						root.getChildren().add(car.getImageView());
					}
				}
			}
		}
	}
	
	public static void main(String[] args){
		launch(args);
	}
}

