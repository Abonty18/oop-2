package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.Random;

class TrackButtonID {
    private final Main main;

    public TrackButtonID(Main main) {
        this.main = main;
    }

    public void invoke() {
        for (Button btn : main.btns) {
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Button currentBtn = (Button) actionEvent.getSource();
                    String idS = currentBtn.getId();
                    int idI = Integer.parseInt(idS);//ids is button id
                    System.out.println("Button clicked of id " + idI);
                    Random rand = new Random();
                    int aiPos = rand.nextInt(8) + 0;
                    System.out.println("Button clicked of id " + aiPos);
                    /*if (gameOver)
                    {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setContentText("Game Over!!");
                        alert.show();
                    }*/
                    new GameOnMode(main, currentBtn, idI, rand, aiPos).invoke();

                }
            });
        }
    }
}
