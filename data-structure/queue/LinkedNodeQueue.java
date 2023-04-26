package queue;

public class LinkedNodeQueue implements Queue{
    private ListNode head;
    private int queueSize = 0;

    @Override
    public void enqueue(int data) {
        queueSize++;
        if (head == null) {
            head = new ListNode(data);
            return;
        }

        getNodeAtThePosition(queueSize - 1).next = new ListNode(data);
    }

    @Override
    public int dequeue() {
        int result;
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        if (queueSize == 1) {
            result = head.getData();
            head = null;
            queueSize = 0;
            return result;
        }

        result = getNodeAtThePosition(1).getData();
        head = getNodeAtThePosition(2);
        queueSize--;
        return result;
    }

    public ListNode getNodeAtThePosition(int position) {
        if (position < 1 || position > queueSize) {
            throw new IndexOutOfBoundsException();
        }
        if (position == 1) {
            return head;
        }
        // 일반적인 경우
        ListNode node = head;
        for (int i = 1; i < position; i++) {
            node = node.next;
        }
        return node;
    }

    public String toString(){
        if (head == null) return "";
        StringBuilder result = new StringBuilder();
        for (int i=1;i<=queueSize;i++){
            result.append((getNodeAtThePosition(i).getData())).append(',');
        }
        return result.substring(0,result.length()-1);
    }
}

class ListNode {
    private int data;
    public ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }
}
