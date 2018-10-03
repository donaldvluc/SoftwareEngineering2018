package edu.nd.se2018.homework.hwk6.ChipsChallenge;

import java.util.LinkedList;

import edu.nd.se2018.homework.hwk3.ColumbusGame.OceanMap;
import edu.nd.se2018.homework.hwk3.ColumbusGame.Pirate;
import edu.nd.se2018.homework.hwk3.ColumbusGame.Ship;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.models.Chip;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.models.maps.ChallengeMap;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.models.maps.ChallengeMapOne;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * 
 * @author Donald Luc
 *
 */

public class ChipsChallenge extends Application {

	// Private Members:
	Pane root;
	final int challenges = 2;
	ArrayList<ChallengeMap> challengeMaps = new ArrayList<ChallengeMap>();
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
		challengeMaps.add(new ChallengeMapOne(root));
		// challengeMaps[1] = new ChallengeMapTwo();

		for (ChallengeMap challenge: challengeMaps) {
			challenge.drawMap();
//			challenge.generateObjects();
			challenge.setStage(stage);
			startChallenge(challenge.getScene());
		}
	}

	private void startChallenge(Scene scene) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				switch(ke.getCode()) {
					case UP:
						chip.moveUp();
						break;
					case DOWN:
						chip.moveDown();
						break;
					case RIGHT:
						chip.moveRight();
						break;
					case LEFT:
						chip.moveLeft();
						break;
					default:
						break;
				}
			}
		});
	}
}
