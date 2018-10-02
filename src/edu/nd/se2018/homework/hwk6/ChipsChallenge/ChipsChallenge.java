package edu.nd.se2018.homework.hwk6.ChipsChallenge;

import java.util.LinkedList;

import edu.nd.se2018.homework.hwk3.ColumbusGame.OceanMap;
import edu.nd.se2018.homework.hwk3.ColumbusGame.Pirate;
import edu.nd.se2018.homework.hwk3.ColumbusGame.Ship;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.models.Chip;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * 
 * @author Donald Luc
 *
 */

public class ChipsChallenge extends Application {

	// Private Members:
	Pane root;
	Scene scene;
	final int challenges = 2;
	ChallengeMap[challenges] challengeMaps;
	Chip chip;
	

	// Main Function:
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		root = new AnchorPane();
		chip = new Chip();
		
		// Generate Ocean Map:
		challengeMaps[0] = new ChallengeMapOne();
		// challengeMaps[1] = new ChallengeMapTwo();
		challengeMap.drawMap(root.getChildren());

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
		stage.setTitle("Chips Challenge: DLUC");
		stage.setScene(scene);
		stage.show();
		
		// Begin Sailing:
		startChallenge();
	}

	private void startChallenge() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				switch(ke.getCode()) {
					case RIGHT:
						chip.goRight();
						break;
					case LEFT:
						chip.goLeft();
						break;
					case UP:
						chip.goUp();
						break;
					case DOWN:
						chip.goDown();
						break;
					default:
						break;
				}
			}
		});
	}
}
