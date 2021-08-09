package sample;

import javafx.scene.control.Button;

import java.util.Random;

class SetAiID {
    private final Main main;
    private Random rand;
    private int aiPos;

    public SetAiID(Main main, Random rand, int aiPos) {
        this.main = main;
        this.rand = rand;
        this.aiPos = aiPos;
    }

    public void invoke() {
        int idI;
        Button currentBtn;
        if (main.moveCount < 9 && !(main.gameOver)) {
            while (main.gameState[aiPos] != 3)

                aiPos = rand.nextInt(8) + 0;
            idI = aiPos;
            main.gameState[idI] = 1;
            currentBtn = main.btns[aiPos];
            Main.checkForWinner(main);
            currentBtn.setText("X");
            main.player = true;
            main.moveCount++;
            System.out.println("mv count" + main.moveCount);
        }
    }
}
