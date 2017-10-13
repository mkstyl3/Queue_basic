package edu.upc.dsa.Controller;

import edu.upc.dsa.Model.EmptyQueueException;
import edu.upc.dsa.Model.FullQueueException;
import org.apache.log4j.Logger;

//Api implementation

public class QueueImpl <E> implements Queue <E> {

    final static Logger logger = Logger.getLogger(QueueImpl.class);

    private E[] elems;
    private int p = 0;
    private int p_max = 0;

    public QueueImpl (int p_max)
    {
        this.elems = (E[])new Object[p_max];
        this.p_max = p_max;
    }

    public E[] getElems() {
        return elems;
    }

    public void push(E e) throws FullQueueException {

        logger.info("push: enqueueing...");
        if (p == p_max) {
            logger.warn("push: queue is full");
            throw new FullQueueException();
        }
        this.elems[this.p++]=e;
        logger.info("push: enqueued, p increased");
    }

    public E pop() throws EmptyQueueException {
        logger.info("pop: retreiving oldest element...");
        if (p == 0) {
            logger.info("pop: empty queue");
            throw new EmptyQueueException();
        }

        else {
            E e = this.elems[0];
            positionShift();
            this.elems[p] = null;
            logger.info("pop: got it");
            return e;
        }
    }

    public int size() {
        logger.info("size: Max size is...");
        return this.p;
    }

    private void positionShift () {
        logger.info("positionShift: shifting vector elements to the left...");
        for (int i=0; i<elems.length -1; i++) {
            elems[i] = elems[i+1];
        }
        logger.info("positionShift: shifting p to the left (p is at: "+ p +")");
        p--;
    }

}
