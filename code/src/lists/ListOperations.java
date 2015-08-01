package lists;


/**
 * User: sachin
 * Date: 01/08/15
 * Time: 2:16 PM
 */
public class ListOperations {

    public static void main(String[] args) {
        final ListNode head = ListUtility.getList(1, 2, 3, 4, 5, 6);
        printList(head);
        System.out.println(findLength(head));
        final ListNode newHead = insertInList(head, 2, 9999);
        printList(newHead);
        printList(reverseList(newHead));
    }

    private static ListNode reverseList(ListNode head) {
        ListNode temp = null, nextNode;
        while(head != null){
            nextNode = head.getNext();
            head.setNext(temp);
            temp = head;
            head = nextNode;
        }

        return temp;
    }

    private static ListNode insertInList(ListNode head, int position, int data) {
        ListNode newNode = new ListNode(data, null);
        int currentPosition = 0;
        ListNode current = head;

        if(position == 0){
            //its the new head
            newNode.setNext(head);
            return newNode;
        }
        while(currentPosition < position - 1){
            current = current.getNext();
            currentPosition++;
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);

        return head;
    }

    private static int findLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while(current != null){
            length++;
            current = current.getNext();
        }
        return length;
    }

    private static void printList(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.printf("[%d]", current.getData());
            current = current.getNext();
        }
        System.out.println("");
    }

}
