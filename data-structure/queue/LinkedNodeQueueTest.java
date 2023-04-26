package queue;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LinkedNodeQueueTest {

    LinkedNodeQueue queue;

    @BeforeAll
    void init() {
        queue = new LinkedNodeQueue();
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(5);
    }

    @Test
    @DisplayName("노드 큐 요소 삽입 테스트")
    @Order(1)
    void enqueueTest() {
        assertEquals("1,3,5", queue.toString());
    }

    @Test
    @DisplayName("노드 큐 요소 삭제 및 오류 테스트")
    @Order(2)
    void dequeueTest() {
        assertAll(
                () -> {
                    queue.dequeue();
                    queue.dequeue();
                    queue.dequeue();
                    assertEquals("", queue.toString());
                },
                () -> {//빈 큐에서 pop 시도
                    Exception exception = assertThrows(IndexOutOfBoundsException.class, () ->
                            queue.dequeue());
                }
        );

    }

}