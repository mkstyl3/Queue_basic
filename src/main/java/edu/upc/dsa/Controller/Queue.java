package edu.upc.dsa.Controller;

import edu.upc.dsa.Model.EmptyQueueException;
import edu.upc.dsa.Model.FullQueueException;

//Api definition

public interface Queue <E> {
    void push (E e) throws FullQueueException;
    E pop () throws EmptyQueueException;
    int size();

}
