package test.main.java;

import main.java.stacksAndQueues.QueueStack;
import main.java.stacksAndQueues.StackQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackQueueTest {
    private StackQueue stackQueue;

    @BeforeEach
    void setUp() {
        stackQueue = new StackQueue();
    }

    @Test
    @DisplayName("Stack Queue")
    void queueStackTest() throws Exception {
        stackQueue.push(1);
        stackQueue.push(2);
        stackQueue.push(3);
        assertEquals(1, stackQueue.peek());
        assertEquals(1, stackQueue.pop());
        assertEquals(2, stackQueue.pop());
        assertEquals(3, stackQueue.pop());
    }
}