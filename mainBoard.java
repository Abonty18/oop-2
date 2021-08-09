package sample;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public abstract class mainBoard extends Application {
    public GridPane gridPane=new GridPane();
    public BorderPane borderPane=new BorderPane();
    public Button[]btns=new Button[9];
}
