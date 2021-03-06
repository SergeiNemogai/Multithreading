package com.andersenlab;

import java.io.*;
import java.math.BigInteger;

public class Multiply {
    public void run(BufferedWriter writer) {
        long time = System.currentTimeMillis();
        BigInteger mul = BigInteger.ONE;
        String result = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("in.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                mul = mul.multiply(mulOfArray(line.split("\t")));
            }
            result = mul.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (result != null) {
                writer.write(result + "\n" + (double) (System.currentTimeMillis() - time) / 1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BigInteger mulOfArray(String[] array) {
        BigInteger mul = BigInteger.ONE;
        for (String element : array) {
            mul = mul.multiply(BigInteger.valueOf(Long.parseLong(element)));
        }
        return mul;
    }
}