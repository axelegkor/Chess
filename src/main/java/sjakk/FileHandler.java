package sjakk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class FileHandler implements FileReader{

    public void loadGame(ActionEvent event, Main game, Pane pane, Rectangle[][] grid, String fileName) throws FileNotFoundException {
    	try (Scanner myReader = new Scanner(new File(fileName));){  
		        String FEN = myReader.nextLine();
		        String Player = myReader.nextLine();
		        System.out.println(FEN);
		        System.out.println(Player);
		        game.setCurrentFEN(FEN);
		        game.clearBoard();
		        game.fromFENToBoard(game.getCurrentFEN());
		    	game.drawBoard(game, pane, grid);
		    	game.setCurrentPlayer(Player);
		    	myReader.close();
		    }
    }

    public void saveGame(ActionEvent event, Main game, String fileName) throws FileNotFoundException {
    	try (PrintWriter myWriter = new PrintWriter(fileName)){
		      myWriter.println(game.getCurrentFEN());
		      myWriter.println(game.getCurrentPlayer());
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    }
    }
    
    

}
