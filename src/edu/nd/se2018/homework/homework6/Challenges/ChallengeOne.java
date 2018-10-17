package edu.nd.se2018.homework.homework6.Challenges;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.homework6.ChipMVC.Chip;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChallengeOne implements Challenge, Observer {

	int[][] grid;
	int chips = 8;
	TileImages tiles;
	Point init = new Point(1, 1);
	Point target = new Point (13, 11); // Change if portal (#7) on grid changes.
	

	public ChallengeOne(int size) {
		tiles = new TileImages(size);
		grid = new int[][] {
		//                               Left Side
		//  { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24}
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, //  0
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4}, //  1
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4}, //  2
			{ 4, 0, 0, 4, 4, 4, 4, 4, 4, 4, 0, 0, 4, 0, 0, 4, 4, 4, 4, 4, 4, 4, 0, 0, 4}, //  3
			{ 4, 0, 0, 4, 0, 0, 4, 0, 0, 4, 0, 0, 4, 0, 0, 4, 0, 0, 4, 8, 0, 0, 0, 0, 4}, //  4
			{ 4, 0, 0, 4, 0, 4, 1, 4, 0, 4, 0, 0, 2, 0, 0, 4, 0, 0, 4, 4, 0, 0, 0, 0, 4}, //  5
			{ 4, 0, 0, 0, 4, 4, 0, 4, 4, 0, 0, 0, 4, 0, 0, 0, 4, 4, 0, 0, 4, 4, 0, 0, 4}, //  6
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4}, //  7
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4}, //  8
			{ 4, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 4}, //  9
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4}, // 10
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4}, // 11
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 9, 4, 4, 4, 4, 4}, // 12 
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 7, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4}, // 13
			{ 4, 0, 3, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4}, // 14
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 4}, // 15
			{ 4, 0, 0, 0, 4, 4, 4, 4, 4, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 4}, // 16
			{ 4, 0, 0, 4, 0, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 4, 3, 0, 0, 0, 0, 0, 4}, // 17
			{ 4, 0, 0, 4, 0, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0,11, 4, 4, 4, 4, 0, 0, 4}, // 18
			{ 4, 0, 0, 4, 0, 3, 0, 4, 0, 4, 0, 0,12, 0, 0, 0, 0, 4, 3, 0, 0, 0, 0, 0, 4}, // 19
			{ 4, 0, 0, 4, 0, 0, 0, 4, 5, 4, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 4}, // 20
			{ 4, 0, 0, 0, 0, 0, 0, 4, 4, 0, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 4}, // 21
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4}, // 22
			{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4}, // 23
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, // 24
		//                                  Right Side
		};
	}

	@Override
	public void init(ObservableList<Node> nodes, int size) {
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
//				Image image = new Image("images\\blankTile.PNG", size, size, true, true);
				int tile = grid[x][y];
				ImagePattern imagePattern = tiles.getImagePattern(tile); //new ImagePattern(image);
				Rectangle rect = new Rectangle(x*size,y*size,size,size);
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
		return null;
	}

	@Override
	public void update(Observable o, Object arg1) {
		if (o instanceof Chip) {
			Chip chip = (Chip)o;
			int x = chip.getX();
			int y = chip.getY();
			if (grid[x][y] != eTiles.BLANK.getType()) {
				System.out.println("NOT BLANK: " + x + ", " + y);
				if (target.x == x && target.y == y) {
					System.out.println("COMPLETE");
				}
			}
		}
		
	}

	@Override
	public Point getInit() { return init; }

	@Override
	public Point getTarget() { return target; }

	@Override
	public int[][] getGrid() { return grid; }

}
