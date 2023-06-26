package com.example.test;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static com.example.test.HelloApplication.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HelloApplicationTest {

    @Test
    void main() {
    }

    @Test
    void start () {
        }
    @Test
    void handle(){
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
    }

    @Test
    void compare() {
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
    }}