package sample;

import javafx.scene.control.Alert;

class WinningLogic {
    public final Main main;

    public WinningLogic(Main main) {
        this.main = main;
    }

    public void invoke() {
        for (int wp[] : main.winningPosition) {
            //0,1,2
            if (main.gameState[wp[0]] == main.gameState[wp[1]] && main.gameState[wp[1]] == main.gameState[wp[2]] && main.gameState[wp[1]] != 3) {
                //player is the winner
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("Success Message");
                if (main.player) {
                    alert.setContentText("Player won the game");
                    new PlayersUIafterWinning(this, wp).invoke();
                    alert.show();
                    main.gameOver = true;
                    break;
                } else {
                    alert.setContentText("Computer won the game");
                    new AiUIafterWinning(this, wp).invoke();
                    alert.show();
                    main.gameOver = true;
                    break;
                }

            }


        }
    }

}
