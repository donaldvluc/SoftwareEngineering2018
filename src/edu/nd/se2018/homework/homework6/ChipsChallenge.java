package edu.nd.se2018.homework.homework6;

import java.awt.Point;
import java.util.Observer;

import edu.nd.se2018.homework.homework6.Challenges.Challenge;
import edu.nd.se2018.homework.homework6.Challenges.ChallengeOne;
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
	final int size = 25; // MUST STAY 25
	final int squared = size * size;
	static Stage stage;
	Pane root;
	ObservableList<Node> children;
	Scene scene;
	Chip chip;
	Challenge challenge;
	int[][] grid;
	
	
	// Main Function:
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage s) throws Exception {
		stage = s;
		root = new AnchorPane();
		children = root.getChildren();
		
		// Create Challenge:
		challenge = new ChallengeOne(size);
		Point init = challenge.getInit();
		grid = challenge.getGrid();
		chip = new Chip(size, init, grid);
		
		chip.addObserver((Observer) challenge);
		
		challenge.init(children, size);
		children.add(chip.getImageView());
		scene = new Scene(root, squared, squared);
		challenge.setup(stage, scene);

		// Start Challenge:
		startChallenge();
	}


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
