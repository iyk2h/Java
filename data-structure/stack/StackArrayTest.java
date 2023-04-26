package stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackArrayTest {

    @Test
    void stackTest() throws Exception {
        StackArray stackNode = new StackArray();

        stackNode.push(-3);
        stackNode.push(41232);
        stackNode.push(5);
        stackNode.push(6);

        assertAll(
                () -> assertEquals(6, stackNode.pop()),
                () -> assertEquals(5, stackNode.pop())
        );

        stackNode.pop();
        stackNode.pop();

        Exception exception = assertThrows(Exception.class, () -> stackNode.pop());
        assertEquals("Stack is empty", exception.getMessage());
    }
}