package com.aconex.telephone;

import com.aconex.telephone.utility.CombinationHelper;
import com.aconex.telephone.words.WordHelper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sachin Maheshwari on 9/13/2015.
 */
public class Application {

    private static final WordHelper wordHelper = new WordHelper();

    public static void main(String[] args) {

        List<String> numbersFromFile = new ArrayList<String>();
        Dictionary dictionary = null;

        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-d")) {
                //Dictionary flag is passed we expect it will have a file name along with it.
                String fileName = args[i].replace("-d", "");
                dictionary = getDictionary(fileName);
            } else {
                // This could be the file containing numbers.
                String numbersFilePath = args[i];
                numbersFromFile = getNumbersFromFile(numbersFilePath);
            }
        }


        if (dictionary == null) {
            // Dictionary Was not initialized hence getting it from inbuilt.
            dictionary = getInbuiltDictionary();
        }

        NumberToWordsConverter numberToWordsConverter = new NumberToWordsConverter(dictionary, new CombinationHelper());

        // First do for numbers from files
        for (String number : numbersFromFile) {
            printWordsForNumber(numberToWordsConverter, number);
        }

        System.out.println("Please enter the number that you want to convert to word..");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String number = scanner.next();
            printWordsForNumber(numberToWordsConverter, number);
        }
    }

    private static void printWordsForNumber(NumberToWordsConverter numberToWordsConverter, String number) {
        String sanitizedNumber = wordHelper.sanitizeNumber(number);
        if (sanitizedNumber.length() > 0) {
            List<String> wordsCombinations = numberToWordsConverter.convert(sanitizedNumber);
            for (String wordFound : wordsCombinations) {
                System.out.println(wordFound);
            }
        } else {
            System.out.println("Please enter valid number");
        }
    }

    private static List<String> getNumbersFromFile(String numbersFilePath) {
        File numberFile = new File(numbersFilePath);
        List<String> numbersFromFile = new ArrayList<String>();
        if (numberFile.exists() && numberFile.isFile()) {
            try {
                numbersFromFile = Files.readAllLines(Paths.get(numberFile.toURI()), Charset.forName("utf-8"));
            } catch (IOException e) {
                System.out.println("Reading numbers from file failed. " + e.getMessage());
            }
        } else {
            System.out.println("File name was passed but was incorrect.");
        }
        return numbersFromFile;
    }


    private static Dictionary getDictionary(String fileName) {
        Dictionary dictionary = null;
        try {
            dictionary = new Dictionary(new File(fileName), wordHelper);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Now using inbuilt dictionary..");
            return getInbuiltDictionary();
        }
        return dictionary;
    }

    private static Dictionary getInbuiltDictionary() {
        return new Dictionary(ClassLoader.getSystemResourceAsStream("sample-word-list.txt"), wordHelper);
    }
}
