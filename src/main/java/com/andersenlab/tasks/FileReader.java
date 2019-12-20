package com.andersenlab.tasks;

import com.andersenlab.DataBuffer;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReader implements Runnable {
    private final BufferedReader reader;
    private final DataBuffer dataBuffer;

    public FileReader(BufferedReader reader, DataBuffer dataBuffer) {
        this.reader = reader;
        this.dataBuffer = dataBuffer;
    }

    @Override
    public void run() {
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                dataBuffer.add(line.split("\t"));
            }
            dataBuffer.setInsertionFinished();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}