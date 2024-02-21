package test.main.java;

import main.java.stacksAndQueues.QueueStack;
import main.java.stacksAndQueues.Queues;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueStackTest {
    private QueueStack queueStack;

    @BeforeEach
    void setUp() {
        queueStack = new QueueStack();
    }

    @Test
    @DisplayName("Queue Stack")
    void queueStackTest() throws Exception {
        queueStack.push(1);
        queueStack.push(2);
        queueStack.push(3);
        assertEquals(3, queueStack.peek());
        assertEquals(3, queueStack.pop());
        assertEquals(2, queueStack.pop());
        assertEquals(1, queueStack.pop());
    }
}