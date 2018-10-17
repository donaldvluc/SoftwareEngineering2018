package edu.nd.se2018.homework.homework6.Challenges;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class TileImages {

	// Private Members:
	private int size;
	private Image image;
	private ImagePattern imagePattern;

	public TileImages(int s) {
		size = s;
	}
	
	public ImagePattern getImagePattern(int type) {
		String uri = eTiles.stringOf(type);
		image = new Image(uri, size, size, true, true);
		imagePattern = new ImagePattern(image);
		return imagePattern;
	}
	
}
