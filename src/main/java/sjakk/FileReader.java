package sjakk;

import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public interface FileReader {
	void loadGame(ActionEvent event, Main game, Pane pane, Rectangle[][] grid, String fileName) throws FileNotFoundException;
	void saveGame(ActionEvent event, Main game, String fileName) throws FileNotFoundException;
}
