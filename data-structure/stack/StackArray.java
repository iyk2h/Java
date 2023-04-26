package stack;

public class StackArray {

    final private int LENGTH_INTERVAL = 1;

    private int[] elements;
    private int top = 0;

    public StackArray() {
        elements = new int[0];
        this.top = -1;
    }

    public void push(int value) {
        this.top += 1;
        if (elements.length == this.top) {
            int[] tmp = new int[elements.length + LENGTH_INTERVAL];
            for (int i = 0; i < elements.length; i++) {
                tmp[i] = elements[i];
            }
            tmp[this.top] = value;
            this.elements = tmp;
        } else {
            this.elements[this.top] = value;
        }
    }

    public int pop() throws Exception{
        if (this.top == -1) {
            System.out.println("Stack is empty");
            throw new Exception("Stack is empty");
        } else {
            return this.elements[this.top--];
        }
    }

    public void print() {
        System.out.println("stack print");
    }
}
