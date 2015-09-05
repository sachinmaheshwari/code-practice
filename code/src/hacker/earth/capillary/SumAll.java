package hacker.earth.capillary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by Sachin Maheshwari on 8/29/2015.
 */
public class SumAll {

    public static void main(String[] args) throws IOException {
        // Read input from stdin and provide input before running

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        // So s[0] contains i and s[1] contains j.
        // Parse s[0] and s[1] and proceed with your logic
        System.out.println(findSum(new BigInteger(s[0]), new BigInteger(s[1])));


    }

    private static BigInteger findSum(BigInteger start, BigInteger end) {

        // I;m using this formula to calculate the sum n*(n+1)/2 if we solve it to find the sum between two numbers we get (a+b)*(b-a+1)/2 where b is the end and a is start
        return start.add(end).multiply(end.subtract(start).add(new BigInteger("1"))).divide(new BigInteger("2"));
    }


}
