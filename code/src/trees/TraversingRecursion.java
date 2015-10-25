package trees;

/**
 * Created by Sachin Maheshwari on 25-Oct-15.
 */
public class TraversingRecursion<T> {


    public static void main(String[] args) {
        // Create aa tree;
        /*
        *           1
        *        2       3
        *      4   5   6   7
        * */
        Node<Integer> root = Helper.getSampleTree();

        System.out.println("Pre-Order");
        TraversingRecursion<Integer> recursion = new TraversingRecursion<>();
        recursion.preOrder(root);
        System.out.println(System.lineSeparator() + "In Order");
        recursion.inOrder(root);
    }


    public void preOrder(Node<T> root){
        if(root != null)
            System.out.print(root.getData() + " ");
        else
            System.out.println(null + " ");

        if(root.getLeft() != null){
            preOrder(root.getLeft());
        }

        if(root.getRight()!=null){
            preOrder(root.getRight());
        }
    }


    public void inOrder(Node<T> root){
        if(root.getLeft() != null){
            inOrder(root.getLeft());
        }
        System.out.print(root.getData() + " ");
        if(root.getRight() != null){
            inOrder(root.getRight());
        }

    }

}
