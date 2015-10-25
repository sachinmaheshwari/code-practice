package trees;

/**
 * Created by Sachin Maheshwari on 25-Oct-15.
 */
public class Node<T> {

    private Node<T> left;
    private Node<T> right;
    private Object data;

    public Node(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public T getData() {
        return (T) data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
