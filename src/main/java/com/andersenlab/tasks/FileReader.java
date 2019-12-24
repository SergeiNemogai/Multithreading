package com.andersenlab.tasks;

import com.andersenlab.DataBuffer;
import lombok.SneakyThrows;

import java.io.BufferedReader;

public class FileReader implements Runnable {
    private final BufferedReader reader;
    private final DataBuffer dataBuffer;

    public FileReader(BufferedReader reader, DataBuffer dataBuffer) {
        this.reader = reader;
        this.dataBuffer = dataBuffer;
    }

    @SneakyThrows
    @Override
    public void run() {
        String line;
        while ((line = reader.readLine()) != null) {
            dataBuffer.add(line.split("\t"));
        }
        dataBuffer.setInsertionFinished();
    }
}