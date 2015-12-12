package fromaman;

/**
 * Created by batraa on 1/17/2015.
 */
public class GenericBST<Key extends Comparable<Key>, Value> {

    class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int count;
    }


    public void put(Node x, Key key, Value val) {

    }



    public void deleteMin() {

    }


    public int rank(Node x) {

        return 0;
    }

    public int rangeCount(Key x, Key y) {

        return 0;
    }




    public int size(Node x) {
        return 0;
    }


    public void inOrderTraversal(Node x) {

    }

    public void deleteMax() {

    }

    public void delete(Key key) {

    }
}

