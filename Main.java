package sample;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class Main extends mainBoard implements fontStyle {

    boolean gameOver=false;
    boolean player=true;
    int gameState[]= {3,3,3,3,3,3,3,3,3};
    int winningPosition[][]= {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public int moveCount=0;

    @Override
    public void start(Stage stage) throws IOException
    {
        this.createGUI();
        Scene scene=new Scene(borderPane,650,650);
        stage.setScene(scene);
        stage.show();
    }
    private void createGUI()
    {
        new GameUI(this).invoke();
    }

    public static void checkForWinner(Main main)
    {
        if(!main.gameOver)
        {
            new WinningLogic(main).invoke();
        }

    }
    public static void main(String[] args)
    {
        launch();
    }

}
