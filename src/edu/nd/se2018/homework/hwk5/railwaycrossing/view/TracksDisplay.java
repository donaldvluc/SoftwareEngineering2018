package edu.nd.se2018.homework.hwk5.railwaycrossing.view;

import java.util.Collection;

import edu.nd.se2018.homework.hwk5.railwaycrossing.model.infrastructure.RailwayTracks;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;


/** 
 * Draws a track
 * @author jane
 *
 */
public class TracksDisplay implements IDisplay {
	Pane root;
	Collection<RailwayTracks> tracks;
	
	public TracksDisplay(Collection<RailwayTracks> tracks, Pane root){
		this.root = root;
		this.tracks = tracks;
	}
	
	@Override
	public void draw() {
		for(RailwayTracks track: tracks){
			int size = track.getSize();
			root.getChildren().add(new Line(track.getStartX(),track.getStartY()-size,track.getEndX(),track.getEndY()-size));
			root.getChildren().add(new Line(track.getStartX(),track.getStartY()+size,track.getEndX(),track.getEndY()+size));
			for(int j = track.getStartX()+(size/2); j < track.getEndX(); j+=size){
				root.getChildren().add(new Line(j,track.getStartY()-size - 2,j,track.getEndY()+size+2));
			}
		}
	}
}
