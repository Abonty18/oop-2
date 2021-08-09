package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.util.Random;

class GameOnMode {
    private final Main main;
    private Button currentBtn;
    private int idI;
    private Random rand;
    private int aiPos;

    public GameOnMode(Main main, Button currentBtn, int idI, Random rand, int aiPos) {
        this.main = main;
        this.currentBtn = currentBtn;
        this.idI = idI;
        this.rand = rand;
        this.aiPos = aiPos;
    }

    public void invoke() {
        if (!main.gameOver) {
            if (main.gameState[idI] == 3) {
                new SetPlayersID(main, currentBtn, idI).invoke();
                new SetAiID(main, rand, aiPos).invoke();
                System.out.println("mv count" + main.moveCount);
                new CheckForDraw(main).invoke();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setContentText("Place is already occupied! press another button");
                alert.show();
            }
        }
    }
}
