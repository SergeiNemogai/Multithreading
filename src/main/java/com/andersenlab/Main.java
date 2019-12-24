package com.andersenlab;

import com.andersenlab.tasks.IntermediateMultiplier;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new FileReader("in.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("out2.txt"));

        int numberOfThreads = 8;
        DataBuffer dataBuffer = new DataBuffer();

        com.andersenlab.tasks.FileReader fileReader = new com.andersenlab.tasks.FileReader(reader, dataBuffer);
        IntermediateMultiplier multiplier = new IntermediateMultiplier(dataBuffer, numberOfThreads);
        com.andersenlab.tasks.FileWriter fileWriter = new com.andersenlab.tasks.FileWriter(writer, dataBuffer);

        long time = System.currentTimeMillis();

        Thread[] threads = new Thread[numberOfThreads + 1];
        Thread thread1 = new Thread(fileWriter);

        for (int i = 0; i < numberOfThreads + 1; i++) {
            if (i < 1) {
                threads[i] = new Thread(fileReader);
            } else {
                threads[i] = new Thread(multiplier);
            }
            threads[i].start();
        }

        for(Thread thread : threads) {
            thread.join();
        }

        thread1.start();
        thread1.join();

        writer.write("\n" + (double) (System.currentTimeMillis() - time) / 1000);
        /*writer.newLine();

        Multiply multiply = new Multiply();
        multiply.run(writer);*/

        try {
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}