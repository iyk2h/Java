package stack;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StackNodeTest {

    @Test
    @DisplayName("Stack Node Test")
    void Stack_Node_Test() throws Exception {
        StackNode stack = new StackNode();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.print();

        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());

        Exception exception = assertThrows(Exception.class, () -> stack.pop());
        assertEquals("Stack is empty", exception.getMessage());
    }
}
