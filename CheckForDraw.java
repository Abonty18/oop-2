package sample;

import javafx.scene.control.Alert;

class CheckForDraw {
    private final Main main;

    public CheckForDraw(Main main) {
        this.main = main;
    }

    public void invoke() {
        if (main.moveCount == 9 && !main.gameOver) {
            Alert alert1 = new Alert(Alert.AlertType.NONE);
            alert1.setTitle("Success Message");
            alert1.setContentText("It's a draw");
            alert1.show();
            main.gameOver = true;
        }
    }
}
