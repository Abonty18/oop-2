package sample;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

class AiUIafterWinning {
    private final WinningLogic winningLogic;
    private int[] wp;

    public AiUIafterWinning(WinningLogic winningLogic, int... wp) {
        this.winningLogic = winningLogic;
        this.wp = wp;
    }

    public void invoke() {
        winningLogic.main.btns[wp[0]].setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        winningLogic.main.btns[wp[1]].setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        winningLogic.main.btns[wp[2]].setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
