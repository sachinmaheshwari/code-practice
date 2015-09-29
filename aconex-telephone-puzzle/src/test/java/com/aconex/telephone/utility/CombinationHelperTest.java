package com.aconex.telephone.utility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

/**
 * Created by Sachin Maheshwari on 9/13/2015.
 */
public class CombinationHelperTest {

    private CombinationHelper combinationHelper;

    @BeforeMethod
    public void setUp(){
        combinationHelper = new CombinationHelper();
    }

    @Test
    public void testGetCombinationsSimpleCase(){
        List<String> allCombinations = combinationHelper.getAllCombinations("sachin");
        assertThat(allCombinations).contains("sachin", "sac-hin", "sa-ch-in", "sa-chin", "sach-in");
    }

    @Test
    public void testGetCombinationsActualNumberCase(){
        List<String> allCombinations = combinationHelper.getAllCombinations("225563");
        assertThat(allCombinations).contains("2255-63");
    }


    @Test
    public void testGetCombincationsForOneLengthNumber(){
        List<String> allCombinations = combinationHelper.getAllCombinations("a");
        assertThat(allCombinations).hasSize(1).contains("a");
    }

    @Test
    public void testGetCombincationsForThreeLengthNumber(){
        List<String> allCombinations = combinationHelper.getAllCombinations("abc");
        assertThat(allCombinations).hasSize(4).contains("ab-c", "abc", "a-bc", "a-b-c");
    }


}