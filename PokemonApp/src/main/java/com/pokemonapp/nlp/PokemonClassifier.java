package com.pokemonapp.nlp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.bson.BsonValue;
import com.pokemonapp.pokemon.Pokemon;

public class PokemonClassifier {
    private Processor processor;
    private HashSet<String> vocabulary = new HashSet<>();

    private int numNormalType = 0;
    private int numFireType = 0;
    private int numFightingType = 0;
    private int numWaterType = 0;
    private int numFlyingType = 0;
    private int numGrassType = 0;
    private int numPoisonType = 0;
    private int numElectricType = 0;
    private int numGroundType = 0;
    private int numPsychicType = 0;
    private int numRockType = 0;
    private int numIceType = 0;
    private int numBugType = 0;
    private int numDragonType = 0;
    private int numGhostType = 0;
    private int numDarkType = 0;
    private int numSteelType = 0;
    private int numFairyType = 0;
    private int totalPokemon = 0;

    private HashMap<String, Integer> normalTypeWordCount = new HashMap<>();
    private HashMap<String, Integer> fireTypeWordCount = new HashMap<>();
    private HashMap<String, Integer> fightingTypeWordCount = new HashMap<>();
    private HashMap<String, Integer> waterTypeWordCount = new HashMap<>();
    private HashMap<String, Integer> flyingTypeWordCount = new HashMap<>();
    private HashMap<String, Integer> grassTypeWordCount = new HashMap<>();
    private HashMap<String, Integer> poisonTypeWordCount = new HashMap<>();
    private HashMap<String, Integer> electricTypeWordCount = new HashMap<>();
    private HashMap<String, Integer> groundTypeWordCount = new HashMap<>();
    private HashMap<String, Integer> psychicTypeWordCount = new HashMap<>();
    private HashMap<String, Integer> rockTypeWordCount = new HashMap<>();
    private HashMap<String, Integer> iceTypeWordCount = new HashMap<>();
    private HashMap<String, Integer> bugTypeWordCount = new HashMap<>();
    private HashMap<String, Integer> dragonTypeWordCount = new HashMap<>();
    private HashMap<String, Integer> ghostTypeWordCount = new HashMap<>();
    private HashMap<String, Integer> darkTypeWordCount = new HashMap<>();
    private HashMap<String, Integer> steelTypeWordCount = new HashMap<>();
    private HashMap<String, Integer> fairyTypeWordCount = new HashMap<>();

    private HashMap<String, Double> normalTypeProbabilities = new HashMap<>();
    private HashMap<String, Double> fireTypeProbabilities = new HashMap<>();
    private HashMap<String, Double> fightingTypeProbabilities = new HashMap<>();
    private HashMap<String, Double> waterTypeProbabilities = new HashMap<>();
    private HashMap<String, Double> flyingTypeProbabilities = new HashMap<>();
    private HashMap<String, Double> grassTypeProbabilities = new HashMap<>();
    private HashMap<String, Double> poisonTypeProbabilities = new HashMap<>();
    private HashMap<String, Double> electricTypeProbabilities = new HashMap<>();
    private HashMap<String, Double> groundTypeProbabilities = new HashMap<>();
    private HashMap<String, Double> psychicTypeProbabilities = new HashMap<>();
    private HashMap<String, Double> rockTypeProbabilities = new HashMap<>();
    private HashMap<String, Double> iceTypeProbabilities = new HashMap<>();
    private HashMap<String, Double> bugTypeProbabilities = new HashMap<>();
    private HashMap<String, Double> dragonTypeProbabilities = new HashMap<>();
    private HashMap<String, Double> ghostTypeProbabilities = new HashMap<>();
    private HashMap<String, Double> darkTypeProbabilities = new HashMap<>();
    private HashMap<String, Double> steelTypeProbabilities = new HashMap<>();
    private HashMap<String, Double> fairyTypeProbabilities = new HashMap<>();

    public PokemonClassifier(Processor processor) {
        this.processor = processor;
    }
    
    public void addSample(BsonValue id, Pokemon pokemon) {
        String[] words = processor.processText(pokemon.getType1());
        if (pokemon.getType1().equals("normal")) {
            updateWordCount(normalTypeWordCount, words);
            numNormalType++;
        }
        else if (pokemon.getType1().equals("fire")) {
            updateWordCount(fireTypeWordCount, words);
            numFireType++;
        }
        else if (pokemon.getType1().equals("fighting")) {
            updateWordCount(fightingTypeWordCount, words);
            numFightingType++;
        }
        else if (pokemon.getType1().equals("water")) {
            updateWordCount(waterTypeWordCount, words);
            numWaterType++;
        }
        else if (pokemon.getType1().equals("flying")) {
            updateWordCount(flyingTypeWordCount, words);
            numFlyingType++;
        }
        else if (pokemon.getType1().equals("grass")) {
            updateWordCount(grassTypeWordCount, words);
            numGrassType++;
        }   
        else if (pokemon.getType1().equals("poison")) {
            updateWordCount(poisonTypeWordCount, words);
            numPoisonType++;
        }
        else if (pokemon.getType1().equals("electric")) {
            updateWordCount(electricTypeWordCount, words);
            numElectricType++;
        }
        else if (pokemon.getType1().equals("ground")) {
            updateWordCount(groundTypeWordCount, words);
            numGroundType++;
        }
        else if (pokemon.getType1().equals("psychic")) {
            updateWordCount(psychicTypeWordCount, words);
            numPsychicType++;
        }
        else if (pokemon.getType1().equals("rock")) {
            updateWordCount(rockTypeWordCount, words);
            numRockType++;
        }
        else if (pokemon.getType1().equals("ice")) {
            updateWordCount(iceTypeWordCount, words);
            numIceType++;
        }
        else if (pokemon.getType1().equals("bug")) {
            updateWordCount(bugTypeWordCount, words);
            numBugType++;
        }
        else if (pokemon.getType1().equals("dragon")) {
            updateWordCount(dragonTypeWordCount, words);
            numDragonType++;
        }
        else if (pokemon.getType1().equals("ghost")) {
            updateWordCount(ghostTypeWordCount, words);
            numGhostType++;
        }
        else if (pokemon.getType1().equals("dark")) {
            updateWordCount(darkTypeWordCount, words);
            numDarkType++;
        }
        else if (pokemon.getType1().equals("steel")) {
            updateWordCount(steelTypeWordCount, words);
            numSteelType++;
        }
        else if (pokemon.getType1().equals("fairy")) {
            updateWordCount(fairyTypeWordCount, words);
            numFairyType++;
        }
        totalPokemon++;
    }

    private void updateWordCount(HashMap<String, Integer> wordCount, String[] words) {
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
            vocabulary.add(word) ;
        }
    }


    public void train() {
        int totalNormalWords = normalTypeWordCount.values().stream().mapToInt(Integer::intValue).sum();
        int totalFireWords = fireTypeWordCount.values().stream().mapToInt(Integer::intValue).sum();
        int totalFightinglWords = fightingTypeWordCount.values().stream().mapToInt(Integer::intValue).sum();
        int totalWaterWords = waterTypeWordCount.values().stream().mapToInt(Integer::intValue).sum();
        int totalFlyingWords = flyingTypeWordCount.values().stream().mapToInt(Integer::intValue).sum();
        int totalGrassWords = grassTypeWordCount.values().stream().mapToInt(Integer::intValue).sum();
        int totalPoisonWords = poisonTypeWordCount.values().stream().mapToInt(Integer::intValue).sum();
        int totalElectricWords = electricTypeWordCount.values().stream().mapToInt(Integer::intValue).sum();
        int totalGroundWords = groundTypeWordCount.values().stream().mapToInt(Integer::intValue).sum();
        int totalPsychicWords = psychicTypeWordCount.values().stream().mapToInt(Integer::intValue).sum();
        int totalRockWords = rockTypeWordCount.values().stream().mapToInt(Integer::intValue).sum();
        int totalIceWords = iceTypeWordCount.values().stream().mapToInt(Integer::intValue).sum();
        int totalBugWords = bugTypeWordCount.values().stream().mapToInt(Integer::intValue).sum();
        int totalDragonWords = dragonTypeWordCount.values().stream().mapToInt(Integer::intValue).sum();
        int totalGhostWords = ghostTypeWordCount.values().stream().mapToInt(Integer::intValue).sum();
        int totalDarkWords = darkTypeWordCount.values().stream().mapToInt(Integer::intValue).sum();
        int totalSteelWords = steelTypeWordCount.values().stream().mapToInt(Integer::intValue).sum();
        int totalFairyWords = fairyTypeWordCount.values().stream().mapToInt(Integer::intValue).sum();

        for (String word: vocabulary) {
            double normalProbability = calculateProbability(word, normalTypeWordCount, totalNormalWords);
            double fireProbability = calculateProbability(word, fireTypeWordCount, totalFireWords);
            double fightingProbability = calculateProbability(word, fightingTypeWordCount, totalFightinglWords);
            double waterProbability = calculateProbability(word, waterTypeWordCount, totalWaterWords);
            double flyingProbability = calculateProbability(word, flyingTypeWordCount, totalFlyingWords);
            double grassProbability = calculateProbability(word, grassTypeWordCount, totalGrassWords);
            double poisonProbability = calculateProbability(word, poisonTypeWordCount, totalPoisonWords);
            double electricProbability = calculateProbability(word, electricTypeWordCount, totalElectricWords);
            double groundProbability = calculateProbability(word, groundTypeWordCount, totalGroundWords);
            double psychicProbability = calculateProbability(word, psychicTypeWordCount, totalPsychicWords);
            double rockProbability = calculateProbability(word, rockTypeWordCount, totalRockWords);
            double iceProbability = calculateProbability(word, iceTypeWordCount, totalIceWords);
            double bugProbability = calculateProbability(word, bugTypeWordCount, totalBugWords);
            double dragonProbability = calculateProbability(word, dragonTypeWordCount, totalDragonWords);
            double ghsotProbability = calculateProbability(word, ghostTypeWordCount, totalGhostWords);
            double darkProbability = calculateProbability(word, darkTypeWordCount, totalDarkWords);
            double steelProbability = calculateProbability(word, steelTypeWordCount, totalSteelWords);
            double fairyProbability = calculateProbability(word, fairyTypeWordCount, totalFairyWords);

            normalTypeProbabilities.put(word, normalProbability);
            fireTypeProbabilities.put(word, fireProbability);
            fightingTypeProbabilities.put(word, fightingProbability);
            waterTypeProbabilities.put(word, waterProbability);
            flyingTypeProbabilities.put(word, flyingProbability);
            grassTypeProbabilities.put(word, grassProbability);
            poisonTypeProbabilities.put(word, poisonProbability);
            electricTypeProbabilities.put(word, electricProbability);
            groundTypeProbabilities.put(word, groundProbability);
            psychicTypeProbabilities.put(word, psychicProbability);
            rockTypeProbabilities.put(word, rockProbability);
            iceTypeProbabilities.put(word, iceProbability);
            bugTypeProbabilities.put(word, bugProbability);
            dragonTypeProbabilities.put(word, dragonProbability);
            ghostTypeProbabilities.put(word, ghsotProbability);
            darkTypeProbabilities.put(word, darkProbability);
            steelTypeProbabilities.put(word, steelProbability);
            fairyTypeProbabilities.put(word, fairyProbability);
        }
    }

    private double calculateProbability(String word, HashMap<String, Integer> wordCount, int totalWords) {
        if (wordCount.containsKey(word)) {
            return (double) wordCount.get(word) / totalWords;
        } else {
            return 1.0 / (totalWords + vocabulary.size());
        }
    }


    public String classify(String description) {
        String[] words = processor.processText(description);
        double normalScore = Math.log((double) numNormalType / totalPokemon);
        double fireScore = Math.log((double) numFireType / totalPokemon);
        double fightingScore = Math.log((double) numFightingType / totalPokemon);
        double waterScore = Math.log((double) numWaterType / totalPokemon);
        double flyingScore = Math.log((double) numFlyingType / totalPokemon);
        double grassScore = Math.log((double) numGrassType / totalPokemon);
        double poisonScore = Math.log((double) numPoisonType / totalPokemon);
        double electricScore = Math.log((double) numElectricType / totalPokemon);
        double groundScore = Math.log((double) numGroundType / totalPokemon);
        double psychicScore = Math.log((double) numPsychicType / totalPokemon);
        double rockScore = Math.log((double) numRockType / totalPokemon);
        double iceScore = Math.log((double) numIceType / totalPokemon);
        double bugScore = Math.log((double) numBugType / totalPokemon);
        double dragonScore = Math.log((double) numDragonType / totalPokemon);
        double ghostScore = Math.log((double) numGhostType / totalPokemon);
        double darkScore = Math.log((double) numDarkType / totalPokemon);
        double steelScore = Math.log((double) numSteelType / totalPokemon);
        double fairyScore = Math.log((double) numFairyType / totalPokemon);

        for (String word : words) {
            normalScore += Math.log(normalTypeProbabilities.getOrDefault(word, 1.0 / (normalTypeWordCount.size() + vocabulary.size())));
            fireScore += Math.log(fireTypeProbabilities.getOrDefault(word, 1.0 / (fireTypeWordCount.size() + vocabulary.size())));
            fightingScore += Math.log(fightingTypeProbabilities.getOrDefault(word, 1.0 / (fightingTypeWordCount.size() + vocabulary.size())));
            waterScore += Math.log(waterTypeProbabilities.getOrDefault(word, 1.0 / (waterTypeWordCount.size() + vocabulary.size())));
            flyingScore += Math.log(flyingTypeProbabilities.getOrDefault(word, 1.0 / (flyingTypeWordCount.size() + vocabulary.size())));
            grassScore += Math.log(grassTypeProbabilities.getOrDefault(word, 1.0 / (grassTypeWordCount.size() + vocabulary.size())));
            poisonScore += Math.log(poisonTypeProbabilities.getOrDefault(word, 1.0 / (poisonTypeWordCount.size() + vocabulary.size())));
            electricScore += Math.log(electricTypeProbabilities.getOrDefault(word, 1.0 / (electricTypeWordCount.size() + vocabulary.size())));
            groundScore += Math.log(groundTypeProbabilities.getOrDefault(word, 1.0 / (groundTypeWordCount.size() + vocabulary.size())));
            psychicScore += Math.log(poisonTypeProbabilities.getOrDefault(word, 1.0 / (psychicTypeWordCount.size() + vocabulary.size())));
            rockScore += Math.log(rockTypeProbabilities.getOrDefault(word, 1.0 / (rockTypeWordCount.size() + vocabulary.size())));
            iceScore += Math.log(iceTypeProbabilities.getOrDefault(word, 1.0 / (iceTypeWordCount.size() + vocabulary.size())));
            bugScore += Math.log(bugTypeProbabilities.getOrDefault(word, 1.0 / (bugTypeWordCount.size() + vocabulary.size())));
            dragonScore += Math.log(dragonTypeProbabilities.getOrDefault(word, 1.0 / (dragonTypeWordCount.size() + vocabulary.size())));
            ghostScore += Math.log(ghostTypeProbabilities.getOrDefault(word, 1.0 / (ghostTypeWordCount.size() + vocabulary.size())));
            darkScore += Math.log(darkTypeProbabilities.getOrDefault(word, 1.0 / (darkTypeWordCount.size() + vocabulary.size())));
            steelScore += Math.log(steelTypeProbabilities.getOrDefault(word, 1.0 / (steelTypeWordCount.size() + vocabulary.size())));
            fairyScore += Math.log(fairyTypeProbabilities.getOrDefault(word, 1.0 / (fairyTypeWordCount.size() + vocabulary.size())));
        }
    
        List<Double> scores = Arrays.asList(normalScore, fireScore, fightingScore, waterScore, flyingScore, grassScore, poisonScore, electricScore, groundScore, psychicScore, rockScore, iceScore, bugScore, dragonScore, ghostScore, darkScore, steelScore, fairyScore);

        if (normalScore > Collections.max(scores)){
            return "normal";
        }
        else if (fireScore > Collections.max(scores)) {
            return "fire";
        }
        else if (fightingScore > Collections.max(scores)) {
            return "fighting";
        }
        else if (waterScore > Collections.max(scores)) {
            return "water";
        }
        else if (flyingScore > Collections.max(scores)) {
            return "flying";
        }
        else if (grassScore > Collections.max(scores)) {
            return "grass";
        }
        else if (poisonScore > Collections.max(scores)) {
            return "poison";
        }
        else if (electricScore > Collections.max(scores)) {
            return "electric";
        }
        else if (groundScore > Collections.max(scores)) {
            return "ground";
        }
        else if (psychicScore > Collections.max(scores)) {
            return "psychic";
        }
        else if (rockScore > Collections.max(scores)) {
            return "rock";
        }
        else if (iceScore > Collections.max(scores)) {
            return "ice";
        }
        else if (bugScore > Collections.max(scores)) {
            return "bug";
        }
        else if (dragonScore > Collections.max(scores)) {
            return "dragon";
        }
        else if (ghostScore > Collections.max(scores)) {
            return "ghost";
        }
        else if (darkScore > Collections.max(scores)) {
            return "dark";
        }
        else if (steelScore > Collections.max(scores)) {
            return "steel";
        }
        else if (fairyScore > Collections.max(scores)) {
            return "fairy";
        }
        else{
            return "Failed to find Data";
        }
    }

}
