package com.aconex.telephone.words;

import com.aconex.telephone.words.WordHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by Sachin Maheshwari on 9/13/2015.
 */
public class WordHelperTest {

    private WordHelper wordHelper;

    @BeforeMethod
    public void setUp() throws Exception {
        wordHelper = new WordHelper();
    }

    @Test
    public void testGetNumberFromWord() throws Exception {
        String numberFromWord = wordHelper.getNumberFromWord("call");
        assertThat(numberFromWord).isEqualTo("2255");
    }

    @Test(dataProvider = "wordToSanitizedWordData")
    public void testSanitizeWord(String word, String expectedSanitizedWord){
        assertThat(wordHelper.sanitizeWord(word)).isEqualTo(expectedSanitizedWord);
    }

    @DataProvider
    public Object[][] wordToSanitizedWordData(){
        return new Object[][]{
                {"call", "CALL"},
                {"ab-ove", "ABOVE"},
                {"123", ""},
                {"eRRoR", "ERROR"}
        };
    }

    @Test(dataProvider = "numberToSanitizedWordData")
    public void testSanitizeNumber(String number, String expectedSanitizedNumber){
        assertThat(wordHelper.sanitizeNumber(number)).isEqualTo(expectedSanitizedNumber);
    }

    @DataProvider
    public Object[][] numberToSanitizedWordData(){
        return new Object[][]{
                {"1-2-3", "123"},
                {"abb1234", "1234"},
                {"abc", ""},
                {"a1234567890b", "1234567890"}
        };
    }



    @Test(dataProvider = "charToNumberData")
    public void testCharToNumberConversion(char character, String expectedNumber){
        String numberFromChar = wordHelper.getNumberFromChar(character);
        assertThat(numberFromChar).isEqualTo(expectedNumber);
    }



    @DataProvider
    public Object[][] charToNumberData(){
        return new Object[][]{
                {'A', "2"},
                {'B', "2"},
                {'C', "2"},
                {'D', "3"},
                {'E', "3"},
                {'F', "3"},
                {'G', "4"},
                {'H', "4"},
                {'I', "4"},
                {'J', "5"},
                {'K', "5"},
                {'L', "5"},
                {'M', "6"},
                {'N', "6"},
                {'O', "6"},
                {'P', "7"},
                {'Q', "7"},
                {'R', "7"},
                {'S', "7"},
                {'T', "8"},
                {'U', "8"},
                {'V', "8"},
                {'W', "9"},
                {'X', "9"},
                {'Y', "9"},
                {'Z', "9"},

        };
    }
}