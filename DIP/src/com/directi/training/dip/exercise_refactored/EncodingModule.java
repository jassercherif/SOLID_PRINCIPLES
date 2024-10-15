package com.directi.training.dip.exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Base64;

public class EncodingModule {
    private final IDataStorage dataStorage;

    // Constructor injection for flexibility
    public EncodingModule(IDataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public void encodeWithFiles() throws IOException {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(
                new FileReader("DIP/src/com/directi/training/dip/exercise/beforeEncryption.txt"));
            writer = new BufferedWriter(
                new FileWriter("DIP/src/com/directi/training/dip/exercise/afterEncryption.txt"));
            String aLine;
            while ((aLine = reader.readLine()) != null) {
                String encodedLine = Base64.getEncoder().encodeToString(aLine.getBytes());
                writer.append(encodedLine);
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (reader != null) {
                reader.close();
            }
        }
    }

    public void encodeBasedOnNetworkAndDatabase() throws IOException {
        URL url = new URL("http", "myfirstappwith.appspot.com", "/index.html");
        InputStream in = url.openStream();
        InputStreamReader reader = new InputStreamReader(in);
        StringBuilder inputString1 = new StringBuilder();
        int c = reader.read();
        while (c != -1) {
            inputString1.append((char) c);
            c = reader.read();
        }
        String inputString = inputString1.toString();
        String encodedString = Base64.getEncoder().encodeToString(inputString.getBytes());
        dataStorage.write(encodedString); // Use the interface to store data
    }
}
