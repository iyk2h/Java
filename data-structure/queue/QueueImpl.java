package queue;

public class QueueImpl implements Queue{

    private int[] queue;

    @Override
    public void enqueue(int data) {
        if (queue == null) {
            queue = new int[]{data};
            return;
        }

        int size = queue.length;
        int[] tmp = queue.clone(); // 깊은 복사  '실제 값'을 새로운 메모리 공간에 복사하는 것
        queue = new int[size + 1];
        for (int i = 0; i < size; i++) {
            queue[i] = tmp[i];
        }
        queue[size] = data;
    }

    @Override
    public int dequeue() {
        if (queue == null) {
            throw new IndexOutOfBoundsException();
        }
        if (queue.length == 1) {
            int result = queue[0];
            queue = null;
            return result;
        }

        int size = queue.length;
        int[] tmp = queue.clone();
        queue = new int[size - 1];
        for (int i = 1; i < size; i++) {
            queue[i - 1] = tmp[i];
        }
        return tmp[0];
    }

    public String toString() {
        if (queue == null) {
            return "";
        }

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < queue.length; i++) {
            sb.append(queue[i]).append(" ");
        }

        return sb.substring(0, sb.length() - 1);
    }
}
