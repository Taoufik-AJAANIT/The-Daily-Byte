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
    void checkIfIsPalindromeWithRemovalRecursive() throws Exception {
        assertEquals(1, queues.ping(1));
        assertEquals(2, queues.ping(300));
        assertEquals(3, queues.ping(3000));
        assertEquals(1, queues.ping(7000));
    }
}