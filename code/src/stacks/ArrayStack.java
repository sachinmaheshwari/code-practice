package stacks;

/**
 * User: sachin
 * Date: 04/08/15
 * Time: 9:31 PM
 */
public class ArrayStack<T> {

    protected int top;
    protected Object array[];

    public ArrayStack(int size) {
        top = -1;
        array = new Object[size];
    }

    public boolean isStackEmpty() {
        return top == -1;

    }

    public boolean isStackFull() {
        return top == getCapacity() - 1;
    }

    private int getCapacity() {
        return array.length;
    }

    public void push(T data) {
        if (isStackFull()) {
            System.out.println("Stack overflow!");
        } else {
            array[++top] = data;
        }
    }

    public T pop() {
        if (isStackEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return (T) array[top--];
    }
}
