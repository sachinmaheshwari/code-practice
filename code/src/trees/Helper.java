package trees;

/**
 * Created by Sachin Maheshwari on 26-Oct-15.
 */
public class Helper {
        static Node<Integer> getSampleTree() {
            Node<Integer> root = new Node<>(1);

            root.setLeft(new Node<>(2));
            root.setRight(new Node<>(3));

            root.getLeft().setLeft(new Node<>(4));
            root.getLeft().setRight(new Node<>(5));

            root.getRight().setLeft(new Node<>(6));
            root.getRight().setRight(new Node<>(7));
            return root;
        }
}
