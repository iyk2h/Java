package linkedList;

public class Node {
    private int elements;
    private Node next = null;

    public Node(int data) {
        this.elements = data;
    }

    public Node add(Node newNode) {
        if (this.next == null) {
            this.next = newNode;
            return this;
        }

        Node nextNode = this.next;
        while (nextNode.next != null) {
            nextNode = next.next;
        }

        nextNode.next = newNode;
        return this;
    }

    public Node add(Node head, Node toAdd, int position) {
        Node nextNode = head;

        for (int i = 0; i < position - 1; i++) {
            if (nextNode.next == null) {
                break;
            }
            nextNode = nextNode.next;
        }

        Node tmp = nextNode.next;
        nextNode.next = toAdd;
        toAdd.next = tmp;

        return this;
    }

    public Node remove(Node head, int position) {
        Node nextNode = head;

        for (int i = 0; i < position - 1; i++) {
            nextNode = nextNode.next;
        }

        Node tmp = nextNode.next;
        nextNode.next = tmp.next;
        tmp = null;

        return this;
    }

    public boolean contains(Node head, Node check) {
        Node nextNode = head;

        if (nextNode.elements == check.elements) {
            return true;
        }
        while (nextNode.next != null) {
            nextNode = nextNode.next;
            if (nextNode.elements == check.elements) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        Node nextNode = this;

        int size = 1;
        while (nextNode.next != null) {
            ++size;
            nextNode = nextNode.next;
        }
        return size;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();

        Node nextNode = this;
        while (nextNode != null) {
            sb.append(nextNode.elements).append(" ");
            nextNode = nextNode.next;
        }
        System.out.println(sb);
        return sb.toString();
    }
}