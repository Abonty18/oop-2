package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

class ThemeUI {
    private final Main main;
    private Label title;
    private RadioButton classicButton;
    private RadioButton forrestButton;
    private RadioButton highContrastButton;

    public ThemeUI(Main main) {
        this.main = main;
    }

    public Label getTitle() {
        return title;
    }

    public RadioButton getClassicButton() {
        return classicButton;
    }

    public RadioButton getForrestButton() {
        return forrestButton;
    }

    public RadioButton getHighContrastButton() {
        return highContrastButton;
    }

    public ThemeUI invoke() {
        VBox theme = new VBox();
        title = new Label("Theme");
        theme.setPrefWidth(240);
        theme.setPrefHeight(35);
        theme.setPadding(new Insets(20, 0, 50, 370));
        title.setMinWidth(theme.getPrefWidth());
        title.setMinHeight(theme.getPrefHeight());
        ToggleGroup group = new ToggleGroup();
        classicButton = new RadioButton("Classic");
        classicButton.setToggleGroup(group);
        forrestButton = new RadioButton("Forrest");
        forrestButton.setToggleGroup(group);
        highContrastButton = new RadioButton("High Contrast");
        highContrastButton.setToggleGroup(group);
        classicButton.setMinWidth(theme.getPrefWidth());
        classicButton.setMinHeight(theme.getPrefHeight());
        forrestButton.setMinWidth(theme.getPrefWidth());
        forrestButton.setMinHeight(theme.getPrefHeight());
        highContrastButton.setMinWidth(theme.getPrefWidth());
        highContrastButton.setMinHeight(theme.getPrefHeight());
        title.setFont(fontStyle.font);
        classicButton.setFont(fontStyle.font3);
        forrestButton.setFont(fontStyle.font3);
        highContrastButton.setFont(fontStyle.font3);
        theme.setAlignment(Pos.TOP_RIGHT);
        main.borderPane.setTop(theme);
        BorderPane.setAlignment(theme, Pos.TOP_RIGHT);
        theme.getChildren().addAll(title, classicButton, forrestButton, highContrastButton);
        return this;
    }
}
