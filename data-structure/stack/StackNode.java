package stack;

import linkedList.Node;

public class StackNode {

    static int top = -1;
    Node node = null;

    public StackNode() {
        top = -1;
    }

    public void push(int data) {
        if (node == null) {
            node = new Node(data);
            top = 1;
        } else {
            node.add(new Node(data));
            top++;
        }
    }

    public int pop() throws Exception {
        if (top == 0) {
            System.out.println("Stack is empty");
            throw new Exception("Stack is empty");
        }

        if (top == 1) {
            int value = node.elements;
            node = null;
            top--;
            return value;
        }

        Node nextNode = node;
        Node preNode = null;

        while (nextNode.next != null) {
            preNode = nextNode;
            nextNode = nextNode.next;
        }

        System.out.println();

        int value = nextNode.elements;

        preNode.next = null;
        nextNode = null;
        top--;

        return value;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();

        Node nextNode = node;

        while (nextNode != null) {
            sb.append(nextNode.elements).append(" ");
            nextNode = nextNode.next;
        }

        System.out.println(sb);
    }
}
