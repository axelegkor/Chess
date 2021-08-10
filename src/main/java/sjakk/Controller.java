package sjakk;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Controller {
	
	private int ruter = 8;
	private FileHandler fileHandler = new FileHandler();

	private Rectangle[][] grid;
	private Main game = new Main();
	
	@FXML
	Pane pane;
	
	@FXML
	Text fileNotFound;
	
	@FXML
	Text fileNotValid;

	@FXML
    private Button loadgame;
	
    @FXML
    private Button newgame;

    @FXML
    private Button savegame;
    
    @FXML
    void loadGame(ActionEvent event) {
    	try {
    	fileHandler.loadGame(event, game, pane, grid, "src/main/java/sjakk/filer/fen.txt");
    	fileNotFound.setVisible(false);
    	fileNotValid.setVisible(false);
    	} catch (FileNotFoundException e) {
    		fileNotFound.setVisible(true);
    	} catch (NoSuchElementException f) {
    		fileNotValid.setVisible(true);
    	}
    }
    
    @FXML
    void saveGame(ActionEvent event) {
    	try {
    	fileHandler.saveGame(event, game, "src/main/java/sjakk/filer/fen.txt");
    	} catch (FileNotFoundException e) {
    		fileNotFound.setVisible(true);
    	}
    }
 
	
	@FXML
	public void initialize() {
		game.hideWhiteWonText();
		game.hideBlackWonText();
		fileNotFound.setVisible(false);
		fileNotValid.setVisible(false);
		game = new Main();
		game.fromFENToBoard(game.getCurrentFEN());
		grid = new Rectangle[ruter][ruter];
		game.drawBoard(game, pane, grid);
	}
	
	
}
