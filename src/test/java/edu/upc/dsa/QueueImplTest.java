package edu.upc.dsa;

import edu.upc.dsa.Controller.*;
import edu.upc.dsa.Model.*;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;



public class QueueImplTest
{
    final static Logger logger = Logger.getLogger(QueueImplTest.class);
    private QueueImpl <Object> queue;
    private TestDummy obj_1;
    private TestDummy obj_2;
    private TestDummy obj_3;
    private TestDummy obj_4;

    @Before
    public void setUp() {

        logger.info("setUp: initialising testing objects queue and obj_1 and obj_2...");

        queue = new QueueImpl<Object>(4);
        obj_1 = new TestDummy(1);
        obj_2 = new TestDummy(2);
        obj_3 = new TestDummy(3);
        obj_4 = new TestDummy(4);

        logger.info("setUp: done");
    }

    @Rule // Necessary to test exceptions
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void pushTest () throws FullQueueException, EmptyQueueException, NoSuchMethodException {

        logger.info("pushTest: beginning pushTest...");

        queue.push(obj_1);
        queue.push(obj_2);
        queue.push(obj_3);
        queue.push(obj_4);

        TestDummy pushDummy_1 = (TestDummy)queue.getElems()[0];
        TestDummy pushDummy_2 = (TestDummy)queue.getElems()[1];
        TestDummy pushDummy_3 = (TestDummy)queue.getElems()[2];
        TestDummy pushDummy_4 = (TestDummy)queue.getElems()[3];

        Assert.assertEquals(queue.size(),4);
        Assert.assertEquals(pushDummy_1.getId(),1  );
        Assert.assertEquals(pushDummy_2.getId(),2  );
        Assert.assertEquals(pushDummy_3.getId(),3  );
        Assert.assertEquals(pushDummy_4.getId(),4  );

        logger.info("pushTest: obj_1 pushed and closing pushTest");

    }

    @Test
    public void popTest () throws EmptyQueueException, FullQueueException {

        logger.info("popTest: Starting...");

        queue.push(obj_1);
        queue.push(obj_2);
        queue.push(obj_3);
        queue.push(obj_4);

        logger.info("popTest: pushed all 4 objects...");

        logger.info("popTest: first pop...");

        Assert.assertEquals(queue.size(),4);
        TestDummy popDummy_1 = (TestDummy)queue.pop();

        logger.info("popTest: second pop...");

        TestDummy popDummy_2 = (TestDummy)queue.pop();

        logger.info("popTest: thirst pop...");

        TestDummy popDummy_3 = (TestDummy)queue.pop();

        logger.info("popTest: fourth pop...");

        TestDummy popDummy_4 = (TestDummy)queue.pop();

        Assert.assertEquals(popDummy_1.getId(),1);
        Assert.assertEquals(popDummy_2.getId(),2);
        Assert.assertEquals(popDummy_3.getId(),3);
        Assert.assertEquals(popDummy_4.getId(),4);

        logger.info("popTest: fiveth pop is gonna throws EmptyException ...");

        thrown.expect(EmptyQueueException.class);
        queue.pop();

        logger.info("popTest: closing popTest");

    }
}
