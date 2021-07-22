package com.fx;

import com.sun.javafx.menu.MenuItemBase;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;


    //GUI
    private GridPane gridPane=new GridPane();
    private BorderPane borderPane=new BorderPane();
    private Label title=new Label("Theme");
    //private Button Random_AI_Button=new Button("Start With Random AI");


    //private Button Defensive_AI_Button=new Button("Start With Defensive AI");

    //public void getTheme(ActionEvent event);

    Font font=Font.font("Arial",FontWeight.BOLD,25);

    private Button[]btns=new Button[9];


    @Override
    public void start(Stage stage) throws IOException {

        this.createGUI();
        //this.handleEvent();


        Scene scene=new Scene(borderPane,850,650);
        stage.setScene(scene);
        stage.show();

    }
    //creating GUI
    private void createGUI() {
        VBox right =new VBox();
        right.setPrefWidth(250);
        right.setPrefHeight(35);
        right.setPadding(new Insets(10,50,50,50));
        right.setSpacing(10);
        Button button1=new Button("Start With Random AI");
        Button button2=new Button("Start With Defensive AI");
        button1.setMinWidth(right.getPrefWidth());
        button1.setMinHeight(right.getPrefHeight());
        button2.setMinWidth(right.getPrefWidth());
        button2.setMinHeight(right.getPrefHeight());
        right.getChildren().addAll(button1,button2);
        //title.setLayoutX(700);


        //Creating title;
        title.setFont(font);
        //Random_AI_Button.setFont(font);
        //Defensive_AI_Button.setFont(font);
        title.setAlignment(Pos.TOP_RIGHT);
        right.setAlignment(Pos.BOTTOM_RIGHT);


        //creating restart button
        //themeButton.setFont(font);
        borderPane.setTop(title);
        //borderPane.setCenter(Random_AI_Button);
        //Random_AI_Button.setMaxSize(200,20);
        //borderPane.setBottom(Defensive_AI_Button);
        //Defensive_AI_Button.setMaxSize(200,20);

        //borderPane.setPadding(Random_AI_Button);
        borderPane.setBottom(right);
       // borderPane.setRight(right);
        //borderPane.setBottom(Defensive_AI_Button);
        BorderPane.setAlignment(title, Pos.TOP_RIGHT);
        BorderPane.setAlignment(right,Pos.BOTTOM_RIGHT);
        //BorderPane.setAlignment(Defensive_AI_Button,Pos.BASELINE_RIGHT);
        borderPane.setPadding(new Insets(15,15,15,15));
        //9 buttons
        int label=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                Button button=new Button(label+"");
                button.setId(label+"");
                button.setFont(font);
                button.setPrefWidth(150);
                button.setPrefHeight(150);
                gridPane.add(button,j,i);
                gridPane.setAlignment(Pos.CENTER_LEFT);
                btns[label]=button;
                label++;


            }
        }
        borderPane.setCenter(gridPane);

    }
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
        ButtonBase button2;
        button2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Defensive AI button clicked");

            }
        });

        /*Random_AI_Button.setLayoutX(500);
        Random_AI_Button.setLayoutY(530);
        borderPane.getChildren().add(Random_AI_Button);
        Defensive_AI_Button.setLayoutX(500);
        Defensive_AI_Button.setLayoutY(630);
        borderPane.getChildren().add(Defensive_AI_Button);*/



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


    public static void main(String[] args) {
        launch();
    }

}