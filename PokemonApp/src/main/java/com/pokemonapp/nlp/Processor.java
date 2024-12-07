package com.pokemonapp.nlp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Processor {
    private Set<String> stopWords;

        public Processor(String stopWordsFilePath) {
        stopWords = new HashSet<>();
        loadStopWords(stopWordsFilePath);
        }

        private void loadStopWords(String stopWordsFilePath) {
            try (BufferedReader br = new BufferedReader(new FileReader(stopWordsFilePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    stopWords.add(line.trim());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String lowerAllCases(String text) {
            return text.toLowerCase();
        }   

        public String removePunctuation(String text) {
            return text.replaceAll("[^a-zA-Z0-9]", " ");
        }
    
        public String[] tokenizeWords(String text) {
            return text.split("\\s+");
        }
    
}
