package edu.nd.se2018.homework.homework6.Challenges;

import java.awt.Point;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChallengeOne implements Challenge {

	public ChallengeOne() {
		
	}

	@Override
	public void init(ObservableList<Node> nodes, int size) {
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				Rectangle rect = new Rectangle(x*size,y*size,size,size);
				Image image = new Image("images\\blankTile.PNG", size, size, true, true);
				ImagePattern imagePattern = new ImagePattern(image);
				rect.setFill(imagePattern);
				nodes.add(rect);
			}
		}

	}

	@Override
	public void setup(Stage stage, Scene scene) {
		stage.setTitle("Chips Challenge One: DLUC");
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public Boolean isDone(Point p) {
		// TODO Auto-generated method stub
		return null;
	}

}
