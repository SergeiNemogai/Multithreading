package com.andersenlab.tasks;

import com.andersenlab.DataBuffer;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter implements Runnable {
    private final BufferedWriter writer;
    private final DataBuffer dataBuffer;

    public FileWriter(BufferedWriter writer, DataBuffer dataBuffer) {
        this.writer = writer;
        this.dataBuffer = dataBuffer;
    }

    @Override
    public void run() {
        String result = dataBuffer.getResult();
        try {
            if (result != null) {
                writer.write(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}