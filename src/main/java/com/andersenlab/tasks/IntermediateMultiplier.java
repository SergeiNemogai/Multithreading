package com.andersenlab.tasks;

import com.andersenlab.DataBuffer;

import java.math.BigInteger;

public class IntermediateMultiplier implements Runnable {
    private final DataBuffer dataBuffer;
    private int countOfFinishedThreads = 0;
    private final int countOfThreads;
    private BigInteger mul = BigInteger.ONE;

    public IntermediateMultiplier(DataBuffer dataBuffer, int countOfThreads) {
        this.dataBuffer = dataBuffer;
        this.countOfThreads = countOfThreads;
    }

    @Override
    public void run() {
        String data;
        while (!dataBuffer.isInsertionFinished() || !dataBuffer.isEmpty()) {
            data = dataBuffer.get();
            if (data != null) {
                synchronized (this) {
                    mul = mul.multiply(BigInteger.valueOf(Long.parseLong(data)));
                }
            }
        }
        synchronized (this) {
            if (countOfFinishedThreads == countOfThreads - 1) {
                dataBuffer.setResult(mul.toString());
            } else {
                countOfFinishedThreads++;
            }
        }
    }
}