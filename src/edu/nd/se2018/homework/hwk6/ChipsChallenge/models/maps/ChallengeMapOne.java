package edu.nd.se2018.homework.hwk6.ChipsChallenge.models.maps;

import edu.nd.se2018.homework.hwk6.ChipsChallenge.models.Chip;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChallengeMapOne extends ChallengeMap {

	public ChallengeMapOne(Pane p, int s) {
		super(p, s);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawMap() {
		ObservableList<Node> children = root.getChildren();
		for (int x = 0; x < squared; x++) {
			for (int y = 0; y < squared; y++) {
				Rectangle rect = new Rectangle(x*size,y*size,size,size);
//				Image image = new Image("images\\blankTile.PNG", size, size, true, true);
				Image image = new Image("edu\\nd\\se2018\\homework\\hwk6\\textures\\portal.PNG", size, size, true, true);
				ImagePattern imagePattern = new ImagePattern(image);
				rect.setStroke(Color.BLACK);
//				rect.setFill(imagePattern);
				rect.setFill(Color.TURQUOISE);
				children.add(rect);
			}
		}
	}
	
	@Override
	public void generateObjects(Chip chip) {
		root.getChildren().add(chip.getImageView());
		Rectangle portal = new Rectangle(2*size,4*size,size,size);
		portal.setFill(new ImagePattern(new Image("edu\\nd\\se2018\\homework\\hwk6\\textures\\portal.PNG", size, size, true, true)));;
		root.getChildren().add(portal);
		Rectangle greenKey = new Rectangle(5*size,9*size,size,size);
		greenKey.setFill(new ImagePattern(new Image("edu\\nd\\se2018\\homework\\hwk6\\textures\\greenKey.PNG", size, size, true, true)));;
		root.getChildren().add(greenKey);
	}
	
	@Override
	public void setStage(Stage stage) {
		stage.setTitle("Chips Challenge One: DLUC");
		stage.setScene(scene);
		stage.show();
	}
}
