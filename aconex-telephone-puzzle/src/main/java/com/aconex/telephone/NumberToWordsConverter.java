package com.aconex.telephone;

import com.aconex.telephone.utility.CombinationHelper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sachin Maheshwari on 9/13/2015.
 */
public class NumberToWordsConverter {

    private final Dictionary dictionary;
    private final CombinationHelper combinationHelper;

    public NumberToWordsConverter(Dictionary dictionary, CombinationHelper combinationHelper) {
        this.dictionary = dictionary;
        this.combinationHelper = combinationHelper;
    }

    /**
     * It will convert the passed number to words. Returned words will be separated by "-". The passed number should contain only numbers.
     *
     * @param number
     * @return
     */
    public List<String> convert(String number) {
        if (numberIsInvalid(number)) {
            throw new IllegalArgumentException("Passed number should contain numbers only. No punctuation or alphabet is allowed.");
        }
        List<String> allCombinations = combinationHelper.getAllCombinations(number);
        List<String> possibleWords = new ArrayList<String>();
        for (String combination: allCombinations){
            String word = getWordForThisCombination(combination);
            if(word!=null){
                possibleWords.add(word);
            }
        }
        return possibleWords;
    }

    private String getWordForThisCombination(String combination) {
        StringBuilder word = new StringBuilder();
        String[] splitNumber = combination.split(Constants.DELIMITER);
        boolean lastWordFound = true;
        for (int i = 0; i < splitNumber.length; i++) {
            String subWord = dictionary.getWordForNumber(splitNumber[i]);

            if(subWord == null && !lastWordFound){
                // Continuously two words were not found it means at least 2 letters are still numbers. We don't have a word for this therefore returning null.
                return null;
            }
            lastWordFound = (subWord != null);

            if(subWord != null){
                word.append(Constants.DELIMITER + subWord);
            } else if(splitNumber[i].length() >= 2){
                // Again more than 2 numbers are not converted hence no word for this number.
                return null;
            } else {
                word.append(Constants.DELIMITER + splitNumber[i]);
            }
        }
        word.deleteCharAt(0);
        return word.toString();
    }

    private boolean numberIsInvalid(String number) {
        try {
            new BigInteger(number);
            return false;
        } catch (NumberFormatException e) {
            // Number is invalid
            return true;
        }
    }


}
