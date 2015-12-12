package fromaman;

/**
 * Created by batraa on 4/19/2015.
 *
 * Pick the middle element make it root and then recursively make left and right child of middle elements
 * of left and right sub arrays
 *
 */
public class SortedArrayToBST {

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        SortedArrayToBST obj = new SortedArrayToBST();
        TreeNode root = obj.convertSortedArrayToBST(arr,0,arr.length-1);
        BST bst = new BST();
        bst.printLevelByLevel(root);
    }



    public TreeNode convertSortedArrayToBST(int [] arr, int lo, int hi) {

        if(lo>hi) {
            return null;
        }

        int mid = (lo+hi)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.setLeftChild(convertSortedArrayToBST(arr,lo,mid-1));
        root.setRightChild(convertSortedArrayToBST(arr, mid + 1, hi));
        return root;
    }
}
