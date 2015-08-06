package stacks;

import javax.sound.midi.Soundbank;

/**
 * User: sachin
 * Date: 04/08/15
 * Time: 9:38 PM
 */
public class StackTest {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.pop(); // Should not work.
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);  // Should not work.

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("Using dynamic array!");
        DynamicArrayStack dynamicArrayStack = new DynamicArrayStack(1);
        dynamicArrayStack.push(1);
        dynamicArrayStack.push(2);
        dynamicArrayStack.push(3);
        dynamicArrayStack.push(4);
        System.out.println(dynamicArrayStack.pop());
        System.out.println(dynamicArrayStack.pop());
        System.out.println(dynamicArrayStack.pop());
        System.out.println(dynamicArrayStack.pop());
        System.out.println(dynamicArrayStack.pop());

    }
}
