package com.aconex.telephone;

import com.aconex.telephone.utility.CombinationHelper;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by Sachin Maheshwari on 9/13/2015.
 */
public class NumberToWordsConverterTest {

    @Mock
    private Dictionary dictionary;
    private NumberToWordsConverter numberToWordsConverter;

    @BeforeMethod
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        when(dictionary.getWordForNumber("2255")).thenReturn("CALL");
        when(dictionary.getWordForNumber("63")).thenReturn("ME");
        numberToWordsConverter = new NumberToWordsConverter(dictionary, new CombinationHelper());
    }

    @Test(dataProvider = "numberToWordMapping")
    public void testNumberToWordConversion(String number, String expectedWord){
        List<String> words = numberToWordsConverter.convert(number);
        assertThat(words).hasSize(1).contains(expectedWord);
        verify(dictionary,atLeastOnce()).getWordForNumber(anyString());
    }

    @DataProvider
    public Object[][] numberToWordMapping(){
        return new Object[][]{
                {"225563", "CALL-ME"},
                {"2255", "CALL"},
                {"63", "ME"},
                {"22556", "CALL-6"},
                {"163", "1-ME"}
        };
    }



    @Test(dataProvider = "invalidNumbers", expectedExceptions = {IllegalArgumentException.class})
    public void testNumberIsValidatedBeforeConversion(String invalidNumber){
        numberToWordsConverter.convert(invalidNumber);
    }

    @DataProvider
    public Object[][] invalidNumbers() {
        return new Object[][]{
                {"ABC"},
                {"12-3"},
                {"12.0"}
        };
    }


}

