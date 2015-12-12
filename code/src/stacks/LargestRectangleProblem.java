package stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 * User: sachin
 * Date: 22/08/15
 * Time: 6:59 PM
 */
public class LargestRectangleProblem {


    public static void main(String[] args) {
        System.out.println(findMaxRectangleArea(new int[]{3,2,5,6,1,4,4,1}));
    }

    private static int findMaxRectangleArea(int[] sizes) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] areaWidth = new int[sizes.length];
        Arrays.fill(areaWidth, 1);

        for (int i = 0; i < sizes.length; i++) {

            while(!stack.empty() && )


            if (stack.empty()) {
                // all left one are bigger
                areaWidth[i]+= i;
            } else if(sizes[stack.peek()] <= sizes[i]) {
                // stack is of low size pop all elements
                areaWidth[i] = 1;
                while (!stack.isEmpty()){
                    if(stack.peek() >= sizes[i]) {
                        stack.pop();
                        areaWidth[i]++;
                    } else
                        break;
                }
            }
            stack.push(sizes[i]);
        }

        System.out.println(Arrays.toString(areaWidth));
        return 0;
    }
}
