package edu.upc.dsa.Model;

public class EmptyQueueException extends Throwable {

    private String msg = "Empty queue";

    public String getMsg() {
        return msg;
    }
}
