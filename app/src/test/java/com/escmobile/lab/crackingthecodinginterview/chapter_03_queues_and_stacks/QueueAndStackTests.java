package com.escmobile.lab.crackingthecodinginterview.chapter_03_queues_and_stacks;

import com.escmobile.lab.crackingthecodinginterview.NodeG;
import com.escmobile.lab.crackingthecodinginterview.Queue;

import org.junit.Before;
import org.junit.Test;

public class QueueAndStackTests {

    private Queue<Integer> sampleQueue;

    @Before
    public void setup() {
        sampleQueue = new Queue<Integer>();
        sampleQueue.queue(new NodeG(1));
        sampleQueue.queue(new NodeG(2));
        sampleQueue.queue(new NodeG(3));
        sampleQueue.queue(new NodeG(4));
        sampleQueue.queue(new NodeG(5));
    }

    @Test
    public void createQueueTest() {

        assert (sampleQueue.peek() != null && sampleQueue.peek().data.equals(1));

        NodeG node = sampleQueue.dequeue();
        assert (node.data.equals(1));

        NodeG nodeNext = sampleQueue.dequeue();
        assert (nodeNext.data.equals(2));
    }
}
