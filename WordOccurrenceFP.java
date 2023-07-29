package com.example.wordo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
//word occur imports
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.sql.*;


public class WordOccurrenceFP extends Application {
    public static void main(String[] args) {
        launch();
    }

    /**
     * staging to set javafx box with title and button with action event
     * scanner named text file for file path to read in/ loop through counting words and placing into aa hashmap
     * Then they are sorted with the compare to method in order of most frequency.
     * Establishing connection the mysql database named wordoccurences through the local host.
     * the words will be printed out in order.
     * Program has been completed
     */
    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("The Raven Word Occurrence");
        Button btn = new Button();
        btn.setText("Raven Word Count 'Click Here!'");
        btn.setOnAction(event -> {
            Scanner txtFile;
            try {
                txtFile = new Scanner(new File("C:/Users/aaron/SoftwareDevOne/TheRaven.txt"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Map<String, Integer> map = new HashMap<>();
            while (txtFile.hasNext()) {
                String word = txtFile.next();
                int count = 1;
                if (map.containsKey(word)) {
                    count = map.get(word) + 1;

                }
                map.put(word, count);
            }
            Set<Map.Entry<String, Integer>> set = map.entrySet();
            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(set);
            sortedList.sort((a, b) -> (b.getValue()).compareTo(a.getValue()));
            //Connecting to Database
            try {

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    try {
                        throw new Exception("Database Not Found. ");
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
                Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/wordoccurences", "root", "1234");
                String insertquery = "INSERT INTO word (words, id) VALUES(?, ?)";
                System.out.println("My SQL Connection Successful");
//Prepared Statement
                PreparedStatement ps = connect.prepareStatement(insertquery);
                for (Map.Entry<String, Integer> i : sortedList) {
                    String word = i.getKey();
                    int id = i.getValue();
                    ps.setString(1, word);
                    ps.setInt(2, id);
                    ps.executeUpdate();
                    int counter = ps.executeUpdate();
                    if (counter != 0)
                        System.out.println("Words inserted successfully");
                    System.out.println("Statement Created Successfully");
                    System.out.println(" There is an Error");
                }
                connect.close();
//old printout to be used without database
                txtFile.close();
                //System.out.println("WORDS " + " | " + "FREQUENCY");
                //for (Map.Entry<String, Integer> i : sortedList) {
                //System.out.println(i.getKey() + " = " + i.getValue());
                //System.out.println("\n");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    });
            StackPane root = new StackPane();
            root.getChildren().add(btn);
            stage.setTitle("Word Counter");
            Scene scene = new Scene(root, 320, 240);
            //scene size set
            stage.setScene(scene);
            //Stage the Scene set inside javaFx show(window)
            stage.show();
            //the javafx window
        }
        public static class getHelloApplication {
            public getHelloApplication(String testFile) {
            }

        }
    }