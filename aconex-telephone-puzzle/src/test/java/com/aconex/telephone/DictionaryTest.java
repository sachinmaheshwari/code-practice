package com.aconex.telephone;

import com.aconex.telephone.words.WordHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Sachin Maheshwari on 9/13/2015.
 */
public class DictionaryTest {

    private static final String TEST_DICTIONARY_FILE_NAME = "test-dictionary.txt";
    private Dictionary dictionary;

    @BeforeMethod
    public void setUp() throws Exception {
        dictionary = new Dictionary(new File(String.valueOf(ClassLoader.getSystemResource(TEST_DICTIONARY_FILE_NAME).getPath())), new WordHelper());
    }

    @Test(expectedExceptions = {FileNotFoundException.class})
    public void testDictionaryConfiguration() throws IOException {
        dictionary = new Dictionary(new File(""), new WordHelper());
    }

    @Test(expectedExceptions = {FileNotFoundException.class})
    public void testDictionaryConfigurationForNonExistentFile() throws IOException {
        dictionary = new Dictionary(new File("abc.txt"), new WordHelper());
    }

    @Test
    public void testDictionaryLoading(){
        assertThat(dictionary.getSize()).isEqualTo(5);
    }

    @Test
    public void testDictionaryLoadingForInputStream() {
        dictionary = new Dictionary(ClassLoader.getSystemResourceAsStream(TEST_DICTIONARY_FILE_NAME), new WordHelper());
        assertThat(dictionary.getSize()).isEqualTo(5);
    }


    @Test(dataProvider = "wordToNumberMapping")
    public void testGetWordForNumber(String number, String expectedWord) throws Exception {
        String wordForNumber = dictionary.getWordForNumber(number);
        assertThat(wordForNumber).isEqualTo(expectedWord);
    }


    @DataProvider
    public Object[][] wordToNumberMapping(){
        return new Object[][]{
                {"2255", "CALL"},
                {"63", "ME"},
                {"24368", "AGENT"},
                {"37767", "ERROR"},
                {"22683", "ABOVE"}
        };
    }


    @Test
    public void testWordToNumber() {
    }





}