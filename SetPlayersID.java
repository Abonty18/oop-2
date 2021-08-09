package sample;

import javafx.scene.control.Button;

class SetPlayersID {
    private final Main main;
    private Button currentBtn;
    private int idI;

    public SetPlayersID(Main main, Button currentBtn, int idI) {
        this.main = main;
        this.currentBtn = currentBtn;
        this.idI = idI;
    }

    public void invoke() {
        if (main.moveCount < 9) {
            currentBtn.setText("O");
            main.gameState[idI] = 0;
            Main.checkForWinner(main);
            main.player = false;
            main.moveCount++;
            System.out.println("mv count" + main.moveCount);
        }
    }
}
