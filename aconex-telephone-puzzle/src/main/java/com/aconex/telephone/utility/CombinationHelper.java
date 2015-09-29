package com.aconex.telephone.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.aconex.telephone.Constants.DELIMITER;

/**
 * Created by Sachin Maheshwari on 9/13/2015.
 */
public class CombinationHelper {


    public List<String> getAllCombinations(String number) {
        List<String> allCombinations = new ArrayList<String>();
        allCombinations.add(number);
        for (int i = 1; i < number.length(); i++) {
            List<String> allSubCombinations = getAllCombinations(number.substring(i, number.length()));
            for (Iterator<String> iterator = allSubCombinations.iterator(); iterator.hasNext(); ) {
                String next = iterator.next();
                allCombinations.add(number.substring(0, i) + DELIMITER + next);
            }
        }
        return allCombinations;
    }
}
