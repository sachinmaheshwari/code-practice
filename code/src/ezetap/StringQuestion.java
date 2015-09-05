package ezetap;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class StringQuestion {

    public static void main(String args[]) throws Exception {
        /*
         * Read input from stdin and provide input before running
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        System.out.println(calculateDashes(line));
    }


    public static int calculateDashes(String numbers) {
        int sumOfDashes = 0;
        for (int i = 0; i < numbers.length(); i++) {
            int number = Integer.parseInt(String.valueOf(numbers.charAt(i)));
            sumOfDashes += findDashesFor(number);
        }

        return sumOfDashes;
    }

    private static int findDashesFor(int number) {
        switch (number) {
            case 0:
                return 6;
            case 1:
                return 2;
            case 2:
                return 5;
            case 3:
                return 5;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 4;
            case 8:
                return 7;
            case 9:
                return 6;
        }
        return 0;
    }


}
