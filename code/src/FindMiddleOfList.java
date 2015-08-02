import lists.ListNode;
import lists.ListUtility;

/**
 * User: sachin
 * Date: 02/08/15
 * Time: 7:56 PM
 */
public class FindMiddleOfList {

    public static void main(String[] args) {
        final ListNode head = ListUtility.getList(1, 2, 3 );
        System.out.println(getMiddleOfTheList(head).getData());
    }

    private static ListNode getMiddleOfTheList(ListNode head) {
        ListNode pointerOne = head;
        ListNode pointerTwo = head;

        while(pointerTwo != null && pointerTwo.getNext() != null){
            pointerOne = pointerOne.getNext();
            pointerTwo = pointerTwo.getNext();
            pointerTwo = pointerTwo.getNext();
        }

        return pointerOne;
    }
}
