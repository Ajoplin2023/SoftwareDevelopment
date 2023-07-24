package com.example.javafxclientserver;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.IOException;

public class ClientSD extends Application {
    public void start(Stage stage) {
        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setPadding(new Insets(5, 5, 5, 5));
        paneForTextField.setStyle("-fx-border-color: red");
        paneForTextField.setLeft(new Label("Enter a Prime Number: "));
        TextField myTextField = new TextField();
        myTextField.setAlignment(Pos.BOTTOM_RIGHT);
        paneForTextField.setCenter(myTextField);
        BorderPane mainPane = new BorderPane();
// Text area to display contents
        TextArea myTextarea = new TextArea();
        mainPane.setCenter(new ScrollPane(myTextarea));
        mainPane.setTop(paneForTextField);
// Create a scene and place it in the stage
        Scene scene = new Scene(mainPane, 450, 200);
        stage.setTitle("Client"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage

        myTextField.setOnAction(e -> {
            int number;

            Scanner scan = new Scanner(System.in);
            //connect to server via local host port
            try {

                Socket s = new Socket("localhost", 3306);
                DataInputStream fromServer = new DataInputStream(s.getInputStream());
                DataOutputStream toServer = new DataOutputStream(s.getOutputStream());

// TAKING USER INPUT
                number = Integer.parseInt(myTextField.getText());
// WRITING INTEGER TO SERVER
                toServer.writeInt(number);
                toServer.flush();
                //String answer = fromServer.readUTF();
                boolean servBool = fromServer.readBoolean();
                myTextarea.appendText("\nYou Entered the number " + number );
                myTextarea.appendText(" Is the number " + number + " Prime?:  "

                        + servBool + '\n');

                toServer.close();
                s.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }


        });}}
