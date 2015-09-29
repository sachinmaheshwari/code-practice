package com.aconex.telephone;

import com.aconex.telephone.words.WordHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sachin Maheshwari on 9/13/2015.
 */
public class Dictionary {

    private final WordHelper wordHelper;
    private final HashMap<String, String> numberToWordMap;

    /**
     * This constructor can be used if dictionary file is packaged inside jar.
     * @param inputStreamForDictionaryFile
     * @param wordHelper
     */
    Dictionary(InputStream inputStreamForDictionaryFile, WordHelper wordHelper) {
        this.wordHelper = wordHelper;
        numberToWordMap = new HashMap<String, String>();
        try {
            readFileIntoHashMap(inputStreamForDictionaryFile);
        } finally {
            try {
                inputStreamForDictionaryFile.close();
            } catch (IOException e) {
                // Error came while closing the dictionary file. We can ignore it.
            }
        }
    }

    public Dictionary(File dictionaryFile, WordHelper wordHelper) throws IOException {
        this.wordHelper = wordHelper;
        numberToWordMap = new HashMap<String, String>();
        if (dictionaryFile == null || !dictionaryFile.exists()) {
            throw new FileNotFoundException("Dictionary file not found. Path that was checked: " + (dictionaryFile == null ? null : dictionaryFile.getAbsolutePath()));
        }
        readFileIntoHashMap(dictionaryFile);
    }

    private void readFileIntoHashMap(File dictionaryFile) throws IOException {
        List<String> allLines = Files.readAllLines(Paths.get(dictionaryFile.toURI()), Charset.forName("utf-8"));
        putWordsIntoMap(allLines);
    }

    private void putWordsIntoMap(List<String> allLines) {
        for (String word : allLines) {
            word = word.trim();
            String sanitizeWord = wordHelper.sanitizeWord(word);
            numberToWordMap.put(wordHelper.getNumberFromWord(sanitizeWord), sanitizeWord);
        }
    }

    private void readFileIntoHashMap(InputStream inputStreamForDictionaryFile) {
        List<String> allLines = new ArrayList<String>();
        Scanner scanner = new Scanner(inputStreamForDictionaryFile);
        while (scanner.hasNext()) {
            allLines.add(scanner.next());
        }
        putWordsIntoMap(allLines);
    }

    public String getWordForNumber(String number) {
        return numberToWordMap.get(number);
    }

    public int getSize() {
        return numberToWordMap.size();
    }
}
