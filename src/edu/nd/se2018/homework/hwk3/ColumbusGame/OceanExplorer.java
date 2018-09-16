package edu.nd.se2018.homework.hwk3.ColumbusGame;

import java.util.LinkedList;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * JavaFX application.
 * Note that you will only be able to run this if you've installed JavaFX!!
 * @author Donald Luc
 *
 */

public class OceanExplorer extends Application {

	// Private Members:
	final int size = 25;
	final int squared = size*size;
	final int nPirates = 2;
	final int nIslands = 10;
	Scene scene;
	OceanMap oceanMap;
	Ship ship;
	List<Pirate> pirates;
	

	// Main Function:
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage oceanStage) throws Exception {
		final Pane root = new AnchorPane();
		
		// Generate Ocean Map:
		oceanMap = new OceanMap(size, nIslands);
		oceanMap.drawMap(root.getChildren(), size);
		oceanMap.randomizeIslands(root.getChildren());

		// Generate Pirates:
		pirates = new LinkedList<Pirate>();
		for (int n = 0; n < nPirates; n++) {
			pirates.add(new Pirate(size, oceanMap));
		}
		
		// Generate Ship:
		ship = new Ship(size, oceanMap);
		root.getChildren().add(ship.getShipImageView());
		
		// Observe CCS and Add Image View:
		for (Pirate p : pirates) {
			root.getChildren().add(p.getPirateImageView());
			ship.addObserver(p);
		}
		
		// Setup:
		scene = new Scene(root,squared,squared);
		oceanStage.setTitle("Christopher Columbus Game (dluc)");
		oceanStage.setScene(scene);
		oceanStage.show();
		
		// Begin Sailing:
		startSailing();
	}
	
	private void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				switch(ke.getCode()) {
					case RIGHT:
						ship.goEast();
						break;
					case LEFT:
						ship.goWest();
						break;
					case UP:
						ship.goNorth();
						break;
					case DOWN:
						ship.goSouth();
						break;
					default:
						break;
				}
				ship.getShipImageView().setX(ship.getPosition().x);
				ship.getShipImageView().setY(ship.getPosition().y);
			}
		});
	}

	

}
