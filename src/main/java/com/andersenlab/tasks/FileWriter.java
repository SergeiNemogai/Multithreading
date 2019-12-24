package com.andersenlab.tasks;

import com.andersenlab.DataBuffer;
import lombok.SneakyThrows;

import java.io.BufferedWriter;

public class FileWriter implements Runnable {
    private final BufferedWriter writer;
    private final DataBuffer dataBuffer;

    public FileWriter(BufferedWriter writer, DataBuffer dataBuffer) {
        this.writer = writer;
        this.dataBuffer = dataBuffer;
    }

    @SneakyThrows
    @Override
    public void run() {
        String result = dataBuffer.getResult();
        if (result != null) {
            writer.write(result);
        }
    }
}