package edu.nd.se2018.homework.homework6;

import java.awt.Point;
import java.util.Observer;

import edu.nd.se2018.homework.homework6.Challenges.Challenge;
import edu.nd.se2018.homework.homework6.Challenges.ChallengeOne;
import edu.nd.se2018.homework.homework6.Challenges.ChallengeTwo;
import edu.nd.se2018.homework.homework6.ChipMVC.Chip;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
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
	final int size = 25; // Keep as 25 for challenge grids.
	final int squared = size * size;
	static Stage stage;
	Pane root;
	ObservableList<Node> children;
	Scene scene = null;
	Chip chip;
	int[][] grid;
	
	int challIndex = 0;
	int nChallenges = 2;
	Challenge[] challenges = new Challenge[nChallenges];
	Challenge challenge;
	
	
	
	// Main Function:
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage s) throws Exception {
		stage = s;
		root = new AnchorPane();
		children = root.getChildren();
		
		// Store Challenges:
		challenges[0] = new ChallengeTwo(this, size);
		challenges[1] = new ChallengeOne(this, size);

		// Create and start challenge instance:
		createChallenge();
		startChallenge();
	}
	
	private void createChallenge() {
		// Get current challenge:
		challenge = challenges[challIndex];
		System.out.println("Chall Index: " + challIndex);
		Point init = challenge.getInit();
		grid = challenge.getGrid();
		
		// Create chip from challenge information:
		chip = new Chip(size, init, grid);
		chip.addObserver((Observer) challenge);
		
		// Create challenge from design:
		challenge.init(children, size);
		children.add(chip.getImageView());
		
		// Create a new scene or reset:
		if (scene == null)
			scene = new Scene(root, squared, squared);
		challenge.setup(stage, scene);
	}


	public void nextChallenge() {
		// Create and start next challenge instance:
		if (challIndex < nChallenges) {
			challIndex++;
			createChallenge();
			startChallenge();
		}
		else
			System.exit(0);
	}


	public ObservableList<Node> getChildren() { return children; }	


	private void startChallenge() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				KeyCode code = ke.getCode();
				switch(code) {
					case UP:
						chip.moveUp(code);
						break;
					case DOWN:
						chip.moveDown(code);
						break;
					case RIGHT:
						chip.moveRight(code);
						break;
					case LEFT:
						chip.moveLeft(code);
						break;
					case ESCAPE:
						System.exit(0);
					default:
						System.out.println(code);
						break;
				}
				chip.updateImage();
			}
		});
	}
}
