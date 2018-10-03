package edu.nd.se2018.homework.hwk6.ChipsChallenge.models.maps;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChallengeMapOne extends ChallengeMap {

	public ChallengeMapOne(Pane p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawMap() {
		ObservableList<Node> children = root.getChildren();
		for (int x = 0; x < squared; x++) {
			for (int y = 0; y < squared; y++) {
				Rectangle rect = new Rectangle(x*size,y*size,size,size);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.PALETURQUOISE);
				children.add(rect);
			}
		}
	}
	
	@Override
	public void generateObjects() {}
	
	@Override
	public void setStage(Stage stage) {
		stage.setTitle("Chips Challenge One: DLUC");
		stage.setScene(scene);
		stage.show();
	}
}
