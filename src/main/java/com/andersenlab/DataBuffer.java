package com.andersenlab;

import java.util.LinkedList;
import java.util.Queue;

public class DataBuffer {
    private final Queue<String> data = new LinkedList<>();
    private boolean insertionFinished = false;
    private String result = null;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isInsertionFinished() {
        return insertionFinished;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    // is it necessary to use synchronized statement here?
    public void setInsertionFinished() {
        insertionFinished = true;
    }

    public void add(String[] numbers) {
        synchronized (this) {
            for(String element : numbers) {
                data.offer(element);
            }
        }
    }

    public String get() {
        synchronized (this) {
            return data.poll();
        }
    }
}