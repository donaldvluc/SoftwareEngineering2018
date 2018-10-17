package edu.nd.se2018.homework.homework6.Challenges;

import java.awt.Point;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public interface Challenge {
	public void init(ObservableList<Node> nodes, int size);
	public void setup(Stage stage, Scene scene);
	public Boolean isDone(Point p);
}
