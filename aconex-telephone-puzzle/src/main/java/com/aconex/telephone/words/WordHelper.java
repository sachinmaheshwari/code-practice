package com.aconex.telephone.words;

/**
 * Created by Sachin Maheshwari on 9/13/2015.
 */
public class WordHelper {

    /**
     * It will return the number in string corresponding to the word passed to it. Each word will have one unique number always. It will also ignore any punctuation mark or anything.
     * @param word
     * @return
     */
    public String getNumberFromWord(String word){
        word = word.toUpperCase();
        char[] chars = word.toCharArray();


        StringBuilder number = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            number.append(getNumberFromChar(aChar));
        }
        return number.toString();
    }

    public String sanitizeWord(String word){
        word = word.toUpperCase();
        char[] chars = word.toCharArray();
        StringBuilder sanitizedWord = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            sanitizedWord.append(sanitizeChar(aChar));
        }
        return sanitizedWord.toString();
    }



    private String sanitizeChar(char aChar) {
        switch (aChar){
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                return Character.toString(aChar);
            default:
                return "";
        }

    }


    String getNumberFromChar(char aChar) {
        switch (aChar){
            case 'A':
            case 'B':
            case 'C':
                return "2";
            case 'D':
            case 'E':
            case 'F':
                return "3";
            case 'G':
            case 'H':
            case 'I':
                return "4";
            case 'J':
            case 'K':
            case 'L':
                return "5";
            case 'M':
            case 'N':
            case 'O':
                return "6";
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
                return "7";
            case 'T':
            case 'U':
            case 'V':
                return "8";
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                return "9";
            default:
                return "";
        }
    }


    public String sanitizeNumber(String number) {
        char[] chars = number.toCharArray();
        StringBuilder sanitizedNumber = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            sanitizedNumber.append(sanitizeNumberChar(aChar));
        }
        return sanitizedNumber.toString();
    }

    private String sanitizeNumberChar(char aChar) {
        switch (aChar){
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case '0':
                return Character.toString(aChar);
            default:
                return "";
        }
    }
}
