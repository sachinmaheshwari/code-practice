package trees;

import java.util.Stack;

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

}
