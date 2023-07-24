package com.example.javafxclientserver;

import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ServerSD extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

// Text area for displaying contents
        TextArea textarea = new TextArea();

// Create a scene and place it in the stage

        Scene scene = new Scene(new ScrollPane(textarea), 450, 200);
        primaryStage.setTitle("Server"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        new Thread(() -> {
            try{
                // Create a server socket
                ServerSocket serverSocket = new ServerSocket(3306);

                textarea.appendText("Server started at " + new Date());


                // Listen for a connection request
                Socket socket = serverSocket.accept();
                // Create data input and output streams
                DataInputStream inputFromClient = new DataInputStream(
                        socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(
                        socket.getOutputStream());
                // Receive num from the client
                int number = inputFromClient.readInt();
                // Write isPrime result to output stream
                outputToClient.writeUTF(isPrime(number));

                textarea.appendText("\nNumber received from client: " + number);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private String isPrime(int number) {
        if (number < 2) {
            return "No";
        }
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) {
                return "No";
            }
        }
        return "Yes";
    }
}
