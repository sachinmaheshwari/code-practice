package stacks;

/**
 * User: sachin
 * Date: 04/08/15
 * Time: 9:56 PM
 */
public class DynamicArrayStack<T> extends ArrayStack<T> {

    public DynamicArrayStack(int size) {
        super(size);
    }


    @Override
    public void push(T number) {
        if(isStackFull()){
            Object[] newArray = new Object[array.length*2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;

        }
        super.push(number);
    }
}
