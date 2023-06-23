package com.example.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.IOException;
import javafx.scene.control.Button;
//word occur imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;


public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("The Raven Word Occurence");
        Button btn = new Button();
        btn = new Button();
        btn.setText("Raven Word Count 'Click Here!'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                    Scanner txtFile = null;
                    try {
                        txtFile = new Scanner(new File("C:/Users/aaron/SoftwareDevOne/TheRaven.txt"));
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    Map<String, Integer> map = new HashMap<String, Integer>();
                    while (txtFile.hasNext()) {
                        String word = txtFile.next();
                        //if (EXCLUDEWORDS.contains(word))
                        //continue;
                        int count = 1;
                        if (map.containsKey(word)) {
                            count = map.get(word) + 1;

                        }
                        map.put(word, count);
                    }
                    Set<Map.Entry<String, Integer>> set = map.entrySet();
                    List<Map.Entry<String, Integer>> sortedList = new ArrayList<Map.Entry<String, Integer>>(set);
                    Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer>>() {
                        public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                            return (b.getValue()).compareTo(a.getValue());
                        }

                    });
                    //txtFile.close();
                    System.out.println("WORDS " + " | " + "FREQUENCY");
                    for (Map.Entry<String, Integer> i : sortedList) {
                        System.out.println(i.getKey() + " = " + i.getValue());

                    }
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


}