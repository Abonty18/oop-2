package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

class AiButtonUI {
    private final Main main;
    private Button randomAIButton;
    private Button defensiveAIButton;

    public AiButtonUI(Main main) {
        this.main = main;
    }

    public Button getRandomAIButton() {
        return randomAIButton;
    }

    public Button getDefensiveAIButton() {
        return defensiveAIButton;
    }

    public AiButtonUI invoke() {
        VBox aiButton = new VBox();
        aiButton.setPrefWidth(240);
        aiButton.setPrefHeight(35);
        aiButton.setPadding(new Insets(10, 50, 50, 50));
        aiButton.setSpacing(10);
        randomAIButton = new Button("Start With Random AI");
        defensiveAIButton = new Button("Start With Defensive AI");
        randomAIButton.setMinWidth(aiButton.getPrefWidth());
        randomAIButton.setMinHeight(aiButton.getPrefHeight());
        defensiveAIButton.setMinWidth(aiButton.getPrefWidth());
        defensiveAIButton.setMinHeight(aiButton.getPrefHeight());
        randomAIButton.setFont(fontStyle.font2);
        defensiveAIButton.setFont(fontStyle.font2);
        randomAIButton.setStyle("-fx-base: black");
        defensiveAIButton.setStyle("-fx-base: black");
        aiButton.setAlignment(Pos.BOTTOM_RIGHT);
        main.borderPane.setBottom(aiButton);
        BorderPane.setAlignment(aiButton, Pos.BOTTOM_RIGHT);
        aiButton.getChildren().addAll(randomAIButton, defensiveAIButton);
        return this;
    }
}
