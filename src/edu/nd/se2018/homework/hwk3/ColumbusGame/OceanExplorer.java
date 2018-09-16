package edu.nd.se2018.homework.hwk3.ColumbusGame;

import java.awt.Point;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.util.LinkedList;


/**
 * JavaFX application.
 * Note that you will only be able to run this if you've installed JavaFX!!
 * @author Donald Luc
 *
 */

public class OceanExplorer extends Application {

	// Private Members:
	final int size = 25;
	Scene scene;
	OceanMap oceanMap;
	Ship ship;
	ImageView shipImageView;
	
//	List<Pirate> pirates;
//	Ship ship;
	

	// Main Function:
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage oceanStage) throws Exception {
		final Pane root = new AnchorPane();
		
		// Generate Ocean Map:
		oceanMap = new OceanMap(size);
		oceanMap.drawMap(root.getChildren(), size);
		oceanMap.randomizeIslands(root.getChildren());
		
		// Generate Ship:
		ship = new Ship(size, oceanMap);
		Image shipImage = new Image("images\\ColumbusShip.png",size,size,true,true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(ship.getPosition().x);
		shipImageView.setY(ship.getPosition().y);
		root.getChildren().add(shipImageView);
		
		// Setup:
		scene = new Scene(root,size*size,size*size);
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
				shipImageView.setX(ship.getPosition().x);
				shipImageView.setY(ship.getPosition().y);
			}
		});
	}

	

}
