package edu.nd.se2018.homework.homework6;

import edu.nd.se2018.homework.homework6.Challenges.Challenge;
import edu.nd.se2018.homework.homework6.Challenges.ChallengeOne;
import edu.nd.se2018.homework.homework6.ChipMVC.Chip;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * 
 * @author Donald Luc
 *
 */

public class ChipsChallenge extends Application {

	// Private Members:
	final int size = 25;
	final int squared = size * size;
	static Stage stage;
	Pane root;
	ObservableList<Node> children;
	Scene scene;
	Chip chip;
	
	
	// Main Function:
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage s) throws Exception {
		stage = s;
		root = new AnchorPane();
		children = root.getChildren();
		chip = new Chip(size, 2); // 2 Chips
		
		Challenge challenge = new ChallengeOne();
		challenge.init(children, size);
		children.add(chip.getImageView());
		scene = new Scene(root, squared, squared);
		challenge.setup(stage, scene);
//		scene = new Scene(root, squared, squared);
//		stage.setScene(scene);
//		stage.show();

		// Draw Challenge:
//		loadChallenge(root.getChildren());
		
//		loadSetup();


		// Start Challenge:
		startChallenge();
	}
	
	private void loadChallenge(ObservableList<Node> c) {
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				Rectangle rect = new Rectangle(x*size,y*size,size,size);
				Image image = new Image("images\\blankTile.PNG", size, size, true, true);
				ImagePattern imagePattern = new ImagePattern(image);
				rect.setFill(imagePattern);
				c.add(rect);
			}
		}
		
		c.add(chip.getImageView());
	}
	
	private void loadSetup() {
		scene = new Scene(root, squared, squared);
		stage.setTitle("Chips Challenge One: DLUC");
		stage.setScene(scene);
		stage.show();
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
					default:
						break;
				}
				chip.updateImage();

				// TODO Handle Completed Challenge:
				if (chip.isDone()) {
					System.out.println("FOUND");
//					root.getChildren().clear();
//					chip.reset();
//					loadChallenge(root.getChildren());
//					loadSetup();
				}
			}
		});
	}
}
