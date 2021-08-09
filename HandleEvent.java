package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

class HandleEvent {
    private final Main main;
    private Button randomAIButton;
    private Button defensiveAIButton;
    private Label title;
    private RadioButton classicButton;
    private RadioButton forrestButton;
    private RadioButton highContrastButton;
    private Button button;

    public HandleEvent(Main main, Button randomAIButton, Button defensiveAIButton, Label title, RadioButton classicButton, RadioButton forrestButton, RadioButton highContrastButton,Button button) {
        this.main = main;
        this.randomAIButton = randomAIButton;
        this.defensiveAIButton = defensiveAIButton;
        this.title = title;
        this.classicButton = classicButton;
        this.forrestButton = forrestButton;
        this.highContrastButton = highContrastButton;
        this.button=button;
    }

    public void invoke() {
        classicButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Classic button clicked");
                Image image = new Image("file:src/sample/WHITE.jpg");
                main.borderPane.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT,
                        BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT)));
                title.setStyle("-fx-base: white");
                classicButton.setStyle("-fx-text-fill: black;-fx-base: black;");
                forrestButton.setStyle("-fx-text-fill: black;-fx-base: black;");
                highContrastButton.setStyle("-fx-text-fill: black;-fx-base: black;");
                randomAIButton.setStyle("-fx-base: black");
                defensiveAIButton.setStyle("-fx-base: black");
                button.setStyle("-fx-border-color:  #000000;-fx-border-width: 3px;");
                

            }
        });
        forrestButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Forest button clicked");
                Image image = new Image("file:src/sample/FOREST.jpg");
                main.borderPane.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT,
                        BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT)));
                title.setStyle("-fx-text-fill: green;");
                classicButton.setStyle("-fx-text-fill: green;-fx-base: lightgreen;");
                forrestButton.setStyle("-fx-text-fill: green;-fx-base: lightgreen;");
                highContrastButton.setStyle("-fx-text-fill: green;-fx-base: lightgreen;");
                randomAIButton.setStyle("-fx-base: green");
                defensiveAIButton.setStyle("-fx-base: green");

            }
        });
        highContrastButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("High Contrast button clicked");
                Image image = new Image("file:src/sample/HIGHCONTRAST.jpg");
                main.borderPane.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT,
                        BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT)));
                title.setStyle("-fx-base: black");
                classicButton.setStyle("-fx-text-fill: white;-fx-base: white;");
                forrestButton.setStyle("-fx-text-fill: white;-fx-base: white;");
                highContrastButton.setStyle("-fx-text-fill: white;-fx-base: white;");
                randomAIButton.setStyle("-fx-base: white");
                defensiveAIButton.setStyle("-fx-base: white");


            }
        });
        randomAIButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Random AI button clicked");

            }
        });
        defensiveAIButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Defensive AI button clicked");

            }
        });
    }
}
