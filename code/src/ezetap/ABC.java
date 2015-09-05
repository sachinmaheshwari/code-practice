package ezetap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Sachin Maheshwari on 8/8/2015.
 */
class ABC {


    public static void main(String[] args) throws IOException {
        System.out.println(solve(100));
    }

    private static double solve(double lengthOfString) {

        if(lengthOfString < lengthOfString){
            return 0;
        } else {
            return   3 * ( Math.pow(3,lengthOfString - 1) - Math.pow(2, lengthOfString) + 1);

        }

    }
}
