package ezetap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Sachin Maheshwari on 8/8/2015.
 */
class CheapestPalindrome {

    private static final String A = "a";
    private static final String B = "b";
    private static final String SLASH = "/";
    private final int aCost;
    private final int bCost;

    public CheapestPalindrome(int aCost, int bCost) {
        this.aCost = aCost;
        this.bCost = bCost;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            int aCost = Integer.parseInt(br.readLine());
            int bCost = Integer.parseInt(br.readLine());
            System.out.println(new CheapestPalindrome(aCost, bCost).findCheapestPalindrome(input));
        }


    }

    private int findCheapestPalindrome(String palindrome) {
        int totalCost = 0;
        String[] palindromeInput = palindrome.split("");

        int length = palindromeInput.length;
        for (int i = 1, j = length - 1; i <= length / 2 && j >= length / 2; i++, j--) {
            if (palindromeInput[i].equals(A)) {
                if (palindromeInput[j].equals(A)) {
                    //already matches no need to do any thing
                } else if (palindromeInput[j].equals(B)) {
                    return -1; // not possible to create a palindrome
                } else {
                    totalCost += aCost;
                }
            } else if (palindromeInput[i].equals(B)) {
                if (palindromeInput[j].equals(B)) {
                    //already matches no need to do any thing
                } else if (palindromeInput[j].equals(A)) {
                    return -1; // not possible to create a palindrome
                } else {
                    totalCost += bCost;
                }
            } else if (palindromeInput[i].equals(SLASH)) {
                if (palindromeInput[j].equals(B)) {
                    totalCost += bCost;
                } else if (palindromeInput[j].equals(A)) {
                    totalCost += aCost;
                } else {
                    if (bCost > aCost) {
                        totalCost += aCost + aCost;
                    } else {
                        totalCost += bCost + bCost;
                    }
                }
            }
        }


        return totalCost;
    }


}
