package test.main.java;

import main.java.stacksAndQueues.Queues;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueuesTest {
    private Queues queues;

    @BeforeEach
    void setUp() {
        queues = new Queues();
    }

    @Test
    @DisplayName("Call Counter")
    void callCounter() throws Exception {
        assertEquals(1, queues.ping(1));
        assertEquals(2, queues.ping(300));
        assertEquals(3, queues.ping(3000));
        assertEquals(1, queues.ping(7000));
    }

    @Test
    @DisplayName("Moving Average")
    void averageFromDataStream() throws Exception {
        assertEquals(3, queues.next(3));
        assertEquals(4, queues.next(5));
        assertEquals(5, queues.next(7));
        assertEquals(6, queues.next(6));
    }

    @Test
    @DisplayName("Moving Average with array and modulo")
    void averageFromDataStreamWithArray() throws Exception {
        assertEquals(3, queues.next1(3));
        assertEquals(4, queues.next1(5));
        assertEquals(5, queues.next1(7));
        assertEquals(6, queues.next1(6));
    }
}