package edu.nd.se2018.homework.hwk6.ChipsChallenge.models.maps;

import edu.nd.se2018.homework.hwk6.ChipsChallenge.models.GridObjects.GridObject;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class ChallengeMap {

	// Private Members:
	Pane root;
	Scene scene;
	int size = 25;
	int squared = size*size;
	GridObject[][] grid;

	// Constructor:
	public ChallengeMap(Pane p) {
		root = p;
		scene = new Scene(root,squared,squared);
	}
	
	public void drawMap() {}
	
	public void generateObjects() {}
	
	public void setStage(Stage stage) {}
	
	public Scene getScene() { return scene; }
}
