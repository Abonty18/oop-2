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
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
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

    //private Label title=new Label("Theme");
    //private Button Random_AI_Button=new Button("Start With Random AI");


    //private Button Defensive_AI_Button=new Button("Start With Defensive AI");

    //public void getTheme(ActionEvent event);

    Font font=Font.font("Arial",FontWeight.BOLD,24);
    Font font2=Font.font("Arial",FontWeight.BOLD,17);
    Font font3=Font.font("Arial",FontWeight.SEMI_BOLD,15);

    private Button[]btns=new Button[9];


    @Override
    public void start(Stage stage) throws IOException {

        this.createGUI();
        //this.handleEvent();

        //HBox hBox1=new HBox();
        //HBox hBox2=new HBox();

        Scene scene=new Scene(borderPane,850,650);
        stage.setScene(scene);
        stage.show();

    }
    //creating GUI
    private void createGUI() {


        //HBox hBox=new HBox();
        //HBox hBox2=new HBox();
        //VBox main=new VBox();
        VBox right =new VBox();
        Region spacer=new Region();
        spacer.setMaxSize(100,100);
        //VBox up=new VBox();
        Label title=new Label("Theme");
        //VBox.setMargin(up,new Insets(250,250,250,250));
        //VBox.setMargin(right,new Insets(250,250,250,250));
        //up.setPrefWidth(250);
        //up.setPrefHeight(35);
        //up.setPadding(new Insets(20,0,50,370));
        //up.setSpacing(10);
        //title.setMinWidth(right.getPrefWidth());
        //title.setMinHeight(right.getPrefHeight());
        right.setPrefWidth(250);
        right.setPrefHeight(35);
        right.setPadding(new Insets(10,50,50,50));
        right.setSpacing(10);
        Button button1=new Button("Start With Random AI");
        Button button2=new Button("Start With Defensive AI");
        ToggleGroup group=new ToggleGroup();
        RadioButton radioButton1=new RadioButton("Classic");
        radioButton1.setToggleGroup(group);
        RadioButton radioButton2=new RadioButton("Forrest");
        radioButton2.setToggleGroup(group);
        RadioButton radioButton3=new RadioButton("High Contrast");
        radioButton3.setToggleGroup(group);

        button1.setMinWidth(right.getPrefWidth());
        button1.setMinHeight(right.getPrefHeight());
        button2.setMinWidth(right.getPrefWidth());
        button2.setMinHeight(right.getPrefHeight());
        radioButton1.setMinWidth(right.getPrefWidth());
        radioButton1.setMinHeight(right.getPrefHeight());
        radioButton2.setMinWidth(right.getPrefWidth());
        radioButton2.setMinHeight(right.getPrefHeight());
        radioButton3.setMinWidth(right.getPrefWidth());
        radioButton3.setMinHeight(right.getPrefHeight());
        right.getChildren().addAll(title,radioButton1,radioButton2,radioButton3,spacer,button1,button2);
        //up.getChildren().addAll(title,radioButton1,radioButton2,radioButton3);
        //main.getChildren().addAll(up,right);
        //main.setPadding(new Insets(10,20,30,40));

        //hBox2.getChildren().addAll(up,right);
        //hBox.getChildren().addAll(gridPane,main);
        //hBox.setPadding(new Insets(20,20,20,20));
        //hBox2.setPadding(new Insets(20,20,20,20));
        //hBox1.setAlignment(Pos.CENTER_LEFT);
        //hBox2.setAlignment(Pos.CENTER_RIGHT);



        //title.setLayoutX(700);


        //Creating title;
        title.setFont(font);
        radioButton1.setFont(font3);
        radioButton2.setFont(font3);
        radioButton3.setFont(font3);
        button1.setFont(font2);
        button2.setFont(font2);
        button1.setStyle("-fx-base: black");
        button2.setStyle("-fx-base: black");
        //Random_AI_Button.setFont(font);
        //Defensive_AI_Button.setFont(font);
        //up.setAlignment(Pos.TOP_RIGHT);
        right.setAlignment(Pos.CENTER_RIGHT);


        //creating restart button
        //themeButton.setFont(font);
        //borderPane.setTop(up);
        //borderPane.setCenter(Random_AI_Button);
        //Random_AI_Button.setMaxSize(200,20);
        //borderPane.setBottom(Defensive_AI_Button);
        //Defensive_AI_Button.setMaxSize(200,20);

        //borderPane.setPadding(Random_AI_Button);
        borderPane.setBottom(right);
        //borderPane.setRight(right);
        //borderPane.setBottom(Defensive_AI_Button);
        //BorderPane.setAlignment(up, Pos.TOP_RIGHT);
        BorderPane.setAlignment(right,Pos.CENTER_RIGHT);
        //BorderPane.setAlignment(Defensive_AI_Button,Pos.BASELINE_RIGHT);
        //borderPane.setPadding(new Insets(10,10,10,10));
        //9 buttons
        int label=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                Button button=new Button(label+"");
                button.setId(label+"");
                button.setFont(font);
                button.setPrefWidth(100);
                button.setPrefHeight(150);
                gridPane.add(button,j,i);
                gridPane.setAlignment(Pos.CENTER_LEFT);
                //gridPane.setPadding(new Insets(10,10,10,10));
                btns[label]=button;
                label++;



            }
        }
        borderPane.setCenter(gridPane);

    }
    //method for handling events
    /*private void handleEvent()
    {   //button click

        Button.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Random AI button clicked");

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