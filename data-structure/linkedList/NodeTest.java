package linkedList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NodeTest {

    static Node list;

    @BeforeEach
    void beforeInit() {
        list = new Node(10);
        list.add(new Node(20));
        list.add(new Node(30));
        list.add(new Node(40));
    }

    @Test
    @DisplayName("LinkedList print")
    void nodePrint() {
        assertTrue(list.print().contains("10 20 30 40 "));
    }

    @Test
    @DisplayName("LinkedList addTest")
    void nodeAddTest() {
        list.add(list, new Node(100), 3);

        assertTrue(list.print().contains("10 20 30 100 40 "));
    }

    @Test
    @DisplayName("Remove Test")
    void nodeRemoveTest() {
        list.remove(list, 2);

        assertTrue(list.print().contains("10 20 40 "));
    }

    @Test
    @DisplayName("Contains Test")
    void nodeContainsTest() {
        assertAll(
                () -> assertTrue(list.contains(list, new Node(30))),
                () -> assertTrue(list.contains(list, new Node(40))),
                () -> assertFalse(list.contains(list, new Node(50)))
        );
    }

    @Test
    @DisplayName("Size test")
    void nodeSizeTest() {
        assertEquals(4, list.size());
    }
}