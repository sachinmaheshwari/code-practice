package trees;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Sachin Maheshwari on 25-Oct-15.
 */
public class TraversingNonRecursive<T> {

    public static void main(String[] args) {
        // Create aa tree;
        /*
        *           1
        *        2       3
        *      4   5   6   7
        * */
        Node<Integer> root = Helper.getSampleTree();

        System.out.println("Pre-Order");
        TraversingNonRecursive<Integer> nonRecursive = new TraversingNonRecursive<>();
        nonRecursive.preOrder(root);
        System.out.println(System.lineSeparator() + "In Order");
        nonRecursive.inOrder(root);
        System.out.println(System.lineSeparator() + "Post order");
        nonRecursive.postOrder(root);
        System.out.println(System.lineSeparator() + "Level order");
        nonRecursive.levelOrder(root);
    }


    private void postOrder(Node<T> root){
        Stack<Node<T>> stack = new Stack<>();

        Node<T> current = root;
        Node<T> lastVisited = null;
        while (true){
            if(current!=null){
                stack.push(current);
                current = current.getLeft();
            } else {
                if(stack.isEmpty()){
                    break;
                }
                current = stack.pop();
                if(current.getRight() == null){
                    System.out.print(current.getData() + " ");
                    lastVisited = current;
                    current = null;
                } else if(lastVisited != current.getRight()){
                    stack.push(current);
                    current = current.getRight();
                } else {
                    System.out.print(current.getData() + " ");
                    lastVisited = current;
                    current = null;
                }

            }

        }



    }

    private void inOrder(Node<T> root) {
        //LDR
        Stack<Node<T>> stack = new Stack<>();
        Node<T> current = root;
        while (true){
            if (current!=null){
                stack.push(current);
                current = current.getLeft();
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                current = stack.pop();
                System.out.print(current.getData() + " ");
                current = current.getRight();
            }
        }


    }


    public void preOrder(Node<T> root){
        // DLR
        Stack<Node<T>> stack = new Stack<>();
        Node<T> localRoot = root;
        while(true){
            while(localRoot!=null) {
                System.out.print(localRoot.getData() + " ");
                stack.push(localRoot);
                localRoot = localRoot.getLeft();
            }
            if(stack.isEmpty()){
                break;
            }

            localRoot = stack.pop();
            localRoot = localRoot.getRight();
        }

    }


    public void levelOrder(Node<T> root) {
        Queue<Node<T>> queue = new ArrayBlockingQueue<Node<T>>(10);

        if(root != null){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            Node<T> current = queue.poll();
            System.out.print(current.getData() + " ");

            if(current.getLeft() != null){
                queue.add(current.getLeft());
            }

            if(current.getRight()!=null){
                queue.add(current.getRight());
            }

        }

    }

}
