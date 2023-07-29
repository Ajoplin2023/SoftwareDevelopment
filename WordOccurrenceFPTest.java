package com.example.wordo;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import static java.util.Collections.*;


class WordOccurrenceFPTest {
    @Test
    void main() {
    }

    @Test
    void handle() {
        Scanner txtFile = null;
        try {
            txtFile = new Scanner(new File("C:/Users/aaron/SoftwareDevOne/TheRaven.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        while (txtFile.hasNext()) {
            String word = txtFile.next();
            int count = 1;
            if (map.containsKey(word)) {
                count = map.get(word) + 1;

            }
            map.put(word, count);
        }
    }}

