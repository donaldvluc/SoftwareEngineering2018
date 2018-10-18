package edu.nd.se2018.homework.homework6.Challenges;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.homework6.ChipsChallenge;
import edu.nd.se2018.homework.homework6.ChipMVC.Chip;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Challenge implements Observer {

	// Private Members:
	ChipsChallenge challenge;
	int[][] grid;
	int size;
	int nChips;
	int nKeys = 4;
	int totPoints = 0;
	TileImages tiles;
	Point init;
	Point target;
	Text chipText;
	Text scoreText;
	Text keysText;

	public Challenge(ChipsChallenge cc, int s, Grid g) {
		challenge = cc;
		size = s;
		tiles = new TileImages(size);
		grid = g.getGrid();
		nChips = g.getChips();
		init = g.getInit();
		target = g.getTarget();
	}

	public void init(ObservableList<Node> nodes, int size) {
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				int tile = grid[x][y];
				ImagePattern imagePattern = tiles.getImagePattern(tile);
				Rectangle rect = new Rectangle(x*size,y*size,size,size);
				rect.setFill(imagePattern);
				nodes.add(rect);
			}
		}
	}

	public void setup(Stage stage, Scene scene) {
		setUI();
		stage.setTitle("Chips Challenge One: DLUC");
		stage.setScene(scene);
		stage.show();
	}

	public Boolean isDone(Point p) {
		return null;
	}

	public void update(Observable o, Object arg1) {
		if (o instanceof Chip) {
			Boolean changed = false;
			Chip chip = (Chip)o;
			int x = chip.getX();
			int y = chip.getY();
			int tile = grid[x][y];
			eTiles eTile = eTiles.valueOf(tile);
			
			switch (eTile) {
			case B_KEY:
			case G_KEY:
			case R_KEY:
			case Y_KEY:
				nKeys--;
				turnBlank(x, y);
				changed = true;
				break;
			case B_WALL:
			case G_WALL:
			case R_WALL:
			case Y_WALL:
				turnBlank(x, y);
				changed = true;
				break;
			case CHIP:
				nChips--;
				totPoints += 100;
				turnBlank(x, y);
				changed = true;
				break;
			case PORTAL:
				challenge.nextChallenge();
				break;
			default:
				break;
			}
			if (changed)
				updateUI();
		}
	}

	private void turnBlank(int x, int y) {
		// Make key tile blank.
		grid[x][y] = 0;
		ObservableList<Node> children = challenge.getChildren();
		int index = x*size + y;
		Rectangle r = (Rectangle)children.get(index);
		ImagePattern blank = tiles.getImagePattern(eTiles.BLANK.getValue());
		r.setFill(blank);
	}

	public Point getInit() { return init; }

	public Point getTarget() { return target; }

	public int[][] getGrid() { return grid; }

	private void setUI() {
		double width = (double)(size * size);

		chipText = new Text();
		chipText.setX(10);
		chipText.setY(width + 20);
		chipText.setFont(new Font("Arial", 20.0));
		chipText.setText("Chips: " + nChips);
		challenge.getChildren().add(chipText);

		scoreText = new Text();
		scoreText.setX(width*3/7);
		scoreText.setY(width + 20);
		scoreText.setFont(new Font("Arial", 20.0));
		scoreText.setText("Score: " + totPoints);
		challenge.getChildren().add(scoreText);

		keysText = new Text();
		keysText.setX(width - 100);
		keysText.setY(width + 20);
		keysText.setFont(new Font("Arial", 20.0));
		keysText.setText("Keys: " + nKeys);
		challenge.getChildren().add(keysText);
	}

	private void updateUI() {
		chipText.setText("Chips: " + nChips);
		scoreText.setText("Score: " + totPoints);
		keysText.setText("Keys: " + nKeys);
	}
}
