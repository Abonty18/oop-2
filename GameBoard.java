package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

class GameBoard {
    private final Main main;
    public static Button button;

    public GameBoard(Main main) {
        this.main = main;
    }
    public static Button getButton(Button button) {return button;}

    public void invoke() {
        int label = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button();
                button.setId(label + "");
                button.setFont(fontStyle.font4);
                button.setPrefWidth(110);
                button.setPrefHeight(150);
                //button.setPadding(new Insets(100,100,100,100));

                //button.setStyle("-fx-border-color:  #000000;-fx-border-width: 4px;");
                //button.setStyle("-fx-background-color: #8cd3ff;");
                main.gridPane.add(button, j, i);
                main.gridPane.setAlignment(Pos.CENTER_LEFT);
                //gridPane.setPadding(new Insets(10,10,10,10));
                main.btns[label] = button;
                label++;

            }
        }
    }
}
