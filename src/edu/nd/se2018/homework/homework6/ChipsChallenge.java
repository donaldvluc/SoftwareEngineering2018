package edu.nd.se2018.homework.homework6;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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
	
	// Main Function:
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Pane root = new AnchorPane();
		
//		challengeMap = new ChallengeMap()
		
		// Draw Challenge:
		ObservableList<Node> c = root.getChildren();
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				Rectangle rect = new Rectangle(x*size,y*size,size,size);
				Image image = new Image("images\\blankTile.PNG", size, size, true, true);
				ImagePattern imagePattern = new ImagePattern(image);
				rect.setStroke(Color.BLACK);
				rect.setFill(imagePattern);
				c.add(rect);
			}
		}
		
		// Setup:
		Scene scene = new Scene(root, squared, squared);
		stage.setTitle("Chips Challenge One: DLUC");
		stage.setScene(scene);
		stage.show();

		// Start Challenge:
		startChallenge();
		
	}

	private void startChallenge() {
		
		
	}
}
