package sjakk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

public class FileHandlerTest {
	
	private Main game;
	private Main game2;
	private FileHandler fileHandler;
	ActionEvent event;
	Pane pane = new Pane();
	Rectangle[][] grid = new Rectangle[8][8];
	
	
	@BeforeEach
	public void setup() {
		game = new Main();
		game.setCurrentFEN("Q5n1/8/2n5/4Nk2/2K5/2N5/5q2/8");
		game.setCurrentPlayer("white");
		game2 = new Main();
		fileHandler = new FileHandler();
	}
	
	@Test
	public void testWorkingFile() {
		
		try {
			fileHandler.saveGame(event, game, "src/main/java/sjakk/filer/tmp.txt");
		}catch (FileNotFoundException e) {
			fail("Could not save file");
		}
		
		try {
		fileHandler.loadGame(event, game2, pane, grid, "src/main/java/sjakk/filer/tmp.txt");
		} catch (FileNotFoundException e) {
			fail("Could not load file");
		}
		
		assertEquals(game2.getCurrentFEN(), (game.getCurrentFEN()));
		assertEquals(game2.getCurrentPlayer(), game.getCurrentPlayer());
		
	}
	
	@Test
	public void testLoadFileNotExists() {
		assertThrows(
				FileNotFoundException.class,
				() -> fileHandler.loadGame(event, game, pane, grid, "dsadfsf"),
				"sdff"
				);
	}
	
	
	
	
	
	
}
