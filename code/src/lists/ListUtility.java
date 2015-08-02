package lists;

/**
 * User: sachin
 * Date: 01/08/15
 * Time: 2:11 PM
 */
public class ListUtility {

    public static ListNode getList(int... data){
        ListNode head = null;
        ListNode current;
        ListNode previous = null;
        for (int i = data.length -1; i >= 0; i--) {
            current = new ListNode(data[i], previous);
            head = current;
            previous = current;
        }

        return head;
    }

    public static void printList(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.printf("[%d]", current.getData());
            current = current.getNext();
        }
        System.out.println("");
    }
}
