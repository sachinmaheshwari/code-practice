package recursions;

import java.util.Arrays;

/**
 * User: sachin
 * Date: 01/08/15
 * Time: 1:39 PM
 */
public class AllBinaryNumbersOfNBits {

    private static int[] A;

    public static void main(String[] args) {
        System.out.println("It will generate all binary numbers of n bits");
        final int numberOfBits = 2;
        A = new int[numberOfBits];
        solve(numberOfBits);
    }

    private static void solve(int i) {
        if(i < 1){
            System.out.println(Arrays.toString(A));
        } else{
            for(int j = 0; j < 2; j++){
                A[i-1] = j;
                solve(i-1);
            }
            //A[i-1]= 0;   // First start with zero
            //solve(i-1);  // Get all combinations for previous bit
            //A[i-1] = 1;  // Now with one
            //solve(i-1);  // Get all combinations for previous bit
        }
    }


}
