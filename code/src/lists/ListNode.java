package lists;

/**
 * User: sachin
 * Date: 01/08/15
 * Time: 2:09 PM
 */
public class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
