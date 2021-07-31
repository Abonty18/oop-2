package com.fx;

import com.sun.javafx.menu.MenuItemBase;
import com.sun.net.httpserver.Authenticator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

/**
 * JavaFX App
 */
public class App extends Application
{

    private static Scene scene;

    //GUI
    private GridPane gridPane=new GridPane();
    public BorderPane borderPane=new BorderPane();
    Font font=Font.font("Segoe Print",FontWeight.EXTRA_BOLD,24);
    Font font2=Font.font("Showcard Gothic",FontWeight.BOLD,17);
    Font font3=Font.font("Segoe Print",FontWeight.BOLD,17);
    Font font4=Font.font("Permanent Marker",FontWeight.EXTRA_BOLD,40);



    private Button[]btns=new Button[9];
    boolean gameOver=false;
    boolean player=true;
    int AI=1;
    int gameState[]= {3,3,3,3,3,3,3,3,3};
    int winningPosition[][]= {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public int moveCount=0;
    public int c;


    @Override
    public void start(Stage stage) throws IOException
    {

        this.createGUI();
        //this.handleEvent();
        Scene scene=new Scene(borderPane,650,650);
        stage.setScene(scene);
        stage.show();

    }
    //creating GUI
    private void createGUI()
    {
        VBox aiButton =new VBox();
        //Region spacer=new Region();
        //spacer.setMaxSize(10,10);
        VBox theme=new VBox();
        Label title=new Label("Theme");
        theme.setPrefWidth(250);
        theme.setPrefHeight(35);
        theme.setPadding(new Insets(20,0,50,370));

        title.setMinWidth(theme.getPrefWidth());
        title.setMinHeight(theme.getPrefHeight());
        aiButton.setPrefWidth(250);
        aiButton.setPrefHeight(35);
        aiButton.setPadding(new Insets(10,50,50,50));
        aiButton.setSpacing(10);
        Button randomAIButton=new Button("Start With Random AI");
        Button defensiveAIButton=new Button("Start With Defensive AI");
        ToggleGroup group=new ToggleGroup();
        RadioButton classicButton=new RadioButton("Classic");
        classicButton.setToggleGroup(group);
        RadioButton forrestButton=new RadioButton("Forrest");
        forrestButton.setToggleGroup(group);
        RadioButton highContrastButton=new RadioButton("High Contrast");
        highContrastButton.setToggleGroup(group);

        randomAIButton.setMinWidth(aiButton.getPrefWidth());
        randomAIButton.setMinHeight(aiButton.getPrefHeight());
        defensiveAIButton.setMinWidth(aiButton.getPrefWidth());
        defensiveAIButton.setMinHeight(aiButton.getPrefHeight());
        classicButton.setMinWidth(theme.getPrefWidth());
        classicButton.setMinHeight(theme.getPrefHeight());

        forrestButton.setMinWidth(theme.getPrefWidth());
        forrestButton.setMinHeight(theme.getPrefHeight());
        highContrastButton.setMinWidth(theme.getPrefWidth());
        highContrastButton.setMinHeight(theme.getPrefHeight());
        aiButton.getChildren().addAll(randomAIButton,defensiveAIButton);
        theme.getChildren().addAll(title,classicButton,forrestButton,highContrastButton);
        //Creating title;
        title.setFont(font);
        classicButton.setFont(font3);
        forrestButton.setFont(font3);
        highContrastButton.setFont(font3);
        randomAIButton.setFont(font2);
        defensiveAIButton.setFont(font2);
        randomAIButton.setStyle("-fx-base: black");
        defensiveAIButton.setStyle("-fx-base: black");
        /*title.setStyle("-fx-base: black");
        classicButton.setStyle("-fx-base: lightblue");
        forrestButton.setStyle("-fx-base: lightblue");
        highContrastButton.setStyle("-fx-base: lightblue");*/
        theme.setAlignment(Pos.TOP_RIGHT);
        aiButton.setAlignment(Pos.BOTTOM_RIGHT);
        borderPane.setTop(theme);
        borderPane.setBottom(aiButton);
        //borderPane.setRight(right);
        BorderPane.setAlignment(theme, Pos.TOP_RIGHT);
        BorderPane.setAlignment(aiButton,Pos.BOTTOM_RIGHT);
        //borderPane.setPadding(new Insets(10,10,10,10));
        //9 buttons
        int label=0;
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                Button button=new Button();
                button.setId(label+"");
                button.setFont(font4);
                button.setPrefWidth(100);
                button.setPrefHeight(100);
                //button.setPadding(new Insets(100,100,100,100));

                //button.setStyle("-fx-border-color:  #221e41;-fx-border-width: 4px;-fx-background-color: #8cd3ff;");
                //button.setStyle("-fx-background-color: #8cd3ff;");
                gridPane.add(button,j,i);
                gridPane.setAlignment(Pos.CENTER_LEFT);
                //gridPane.setPadding(new Insets(10,10,10,10));
                btns[label]=button;
                label++;

            }
        }

        for(Button btn:btns)
        {
            btn.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent actionEvent)
                {
                    //System.out.println("Number button clicked");
                    //int moveCount=0;
                    Button currentBtn = (Button) actionEvent.getSource();
                    String idS = currentBtn.getId();
                    int idI = Integer.parseInt(idS);//ids is button id

                    System.out.println("Button clicked of id "+idI);

                    Random rand=new Random();
                    int aiPos=rand.nextInt(8)+0;
                    System.out.println("Button clicked of id "+aiPos);
                    /*if (gameOver)
                    {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setContentText("Game Over!!");
                        alert.show();
                    }*/
                    if(!gameOver)
                    {

                        if (gameState[idI] == 3)

                        {
                            if(moveCount<9)
                            {



                                currentBtn.setText("O");

                                gameState[idI] = 0;
                                checkForWinner();
                                //draw();
                                player =false;
                                moveCount++;
                                System.out.println("mv count"+moveCount);
                            }
                            if(moveCount<9&& !(gameOver))
                            {
                                while(gameState[aiPos]!=3)

                                    aiPos= rand.nextInt(8)+0;
                                idI=aiPos;
                                gameState[idI] = 1;
                                currentBtn=btns[aiPos];
                                checkForWinner();

                                currentBtn.setText("X");


                                player =true;
                                moveCount++;
                                System.out.println("mv count"+moveCount);
                            }

                            c=moveCount;
                            System.out.println("mv count"+c);
                            if(moveCount==9 && !gameOver)
                            {Alert alert1 = new Alert(Alert.AlertType.NONE);
                                alert1.setTitle("Success Message");
                                alert1.setContentText("It's a draw");
                                alert1.show();
                                gameOver=true;}


                        }

                        else
                        {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Error Message");
                            alert.setContentText("Place is already occupied! press another button");
                            alert.show();


                        }
                    }

                }


            });
        }
        borderPane.setCenter(gridPane);

        classicButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                System.out.println("Classic button clicked");
                Image image=new Image("file:src/main/resources/img/classic.jpg");
                borderPane.setBackground(new Background(new BackgroundImage(image,BackgroundRepeat.REPEAT,
                                                                 BackgroundRepeat.REPEAT,
                        BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT)));
                title.setStyle("-fx-base: black");
                classicButton.setStyle("-fx-text-fill: lightblue;");
                forrestButton.setStyle("-fx-text-fill: lightblue;");
                highContrastButton.setStyle("-fx-text-fill: lightblue;");
                randomAIButton.setStyle("-fx-base: black");
                defensiveAIButton.setStyle("-fx-base: black");
                //button.setStyle("-fx-border-color:  #221e41;-fx-border-width: 4px;-fx-background-color: #8cd3ff;");
                /*classicButton.setStyle("-fx-base: lightblue");
                forrestButton.setStyle("-fx-base: lightblue");
                highContrastButton.setStyle("-fx-base: lightblue");*/




            }
        });
        forrestButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                System.out.println("Forest button clicked");
                Image image=new Image("file:src/main/resources/img/forrest.jpg");
                borderPane.setBackground(new Background(new BackgroundImage(image,BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT,
                        BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT)));
                title.setStyle("-fx-base: black");
                classicButton.setStyle("-fx-text-fill: white;");
                forrestButton.setStyle("-fx-text-fill: white;");
                highContrastButton.setStyle("-fx-text-fill: white;");
                randomAIButton.setStyle("-fx-base: green");
                defensiveAIButton.setStyle("-fx-base: green");

            }
        });
        highContrastButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                System.out.println("High Contrast button clicked");
                Image image=new Image("file:src/main/resources/img/highcontrast.jpg");
                borderPane.setBackground(new Background(new BackgroundImage(image,BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT,
                        BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT)));
                title.setStyle("-fx-base: black");
                classicButton.setStyle("-fx-text-fill: lightgreen;");
                forrestButton.setStyle("-fx-text-fill: lightgreen;");
                highContrastButton.setStyle("-fx-text-fill: lightgreen;");
                randomAIButton.setStyle("-fx-base: lightblue");
                defensiveAIButton.setStyle("-fx-base: lightblue");

            }
        });
        randomAIButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                System.out.println("Random AI button clicked");

            }
        });
        defensiveAIButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                System.out.println("Defensive AI button clicked");

            }
        });

    }

    //checks for winner
    private void checkForWinner()
    {
        if(!gameOver)
        {
            for(int wp[]:winningPosition)
            {
                //0,1,2
                if(gameState[wp[0]]==gameState[wp[1]]&&gameState[wp[1]]==gameState[wp[2]]&&gameState[wp[1]]!=3)
                {
                    //player is the winner
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setTitle("Success Message");
                    //alert1.setTitle("Gameover! Try to restart");
                    if (player)
                    {

                        alert.setContentText("Player won the game");
                        btns[wp[0]].setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN,CornerRadii.EMPTY,Insets.EMPTY)));
                        btns[wp[1]].setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN,CornerRadii.EMPTY,Insets.EMPTY)));
                        btns[wp[2]].setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN,CornerRadii.EMPTY,Insets.EMPTY)));
                        alert.show();
                        gameOver=true;
                        break;
                    }
                    else //if(!player)
                    {

                        alert.setContentText("Computer won the game");
                        btns[wp[0]].setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,CornerRadii.EMPTY,Insets.EMPTY)));
                        btns[wp[1]].setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,CornerRadii.EMPTY,Insets.EMPTY)));
                        btns[wp[2]].setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,CornerRadii.EMPTY,Insets.EMPTY)));
                        alert.show();
                        gameOver=true;
                        break;
                    }

                }


            }
        }
       /* else if(c==9&&!gameOver)
        {   Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setContentText("It's a draw");
            alert.show();
            //gameOver=true;
            //break;
        }*/
        //else
        //{Alert alert1 = new Alert(Alert.AlertType.NONE);
        //  alert1.setTitle("Gameover! Try to restart");}
    }
    /*private void draw()
    {
        if(c==9 && !gameOver)
        {Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Success Message");
            alert1.setContentText("It's a draw");
            alert1.show();
            gameOver=true;
        }
    }*/

    //method for handling events
    /*private void handleEvent()
    {   //button click
        button1.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Random AI button clicked");
            }
        });
    /*for(Button btn:btns)
    {
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Number button clicked");
                Button currentBtn=(Button)actionEvent.getSource();
                String idS=currentBtn.getId();
                int idI=Integer.parseInt(idS);//ids is button id
                System.out.println("Button clicked of id "+idI);
            }
        });
    }
    }*/
    public static void main(String[] args)
    {
        launch();
    }



}