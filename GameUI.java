package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

class GameUI {
    private final Main main;

    public GameUI(Main main) {
        this.main = main;
    }

    public void invoke() {
        AiButtonUI aiButtonUI = new AiButtonUI(main).invoke();
        Button randomAIButton = aiButtonUI.getRandomAIButton();
        Button defensiveAIButton = aiButtonUI.getDefensiveAIButton();
        ThemeUI themeUI = new ThemeUI(main).invoke();
        Label title = themeUI.getTitle();
        RadioButton classicButton = themeUI.getClassicButton();
        RadioButton forrestButton = themeUI.getForrestButton();
        RadioButton highContrastButton = themeUI.getHighContrastButton();
        Button button= GameBoard.getButton(GameBoard.button);
        new GameBoard(main).invoke();
        new TrackButtonID(main).invoke();
        main.borderPane.setCenter(main.gridPane);
        new HandleEvent(main, randomAIButton, defensiveAIButton, title, classicButton, forrestButton, highContrastButton,button).invoke();
    }
}
