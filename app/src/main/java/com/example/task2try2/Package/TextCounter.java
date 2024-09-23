package com.example.task2try2.Package;

public class TextCounter {
    public static int getCharsCount(String userPhrase){
        return userPhrase.length();
    }
    public int getWordsCount(String input){
        if(input == null || input.trim().isEmpty()){

            return 0;
        }
        String[] words = input.trim().split("[\\s,.]+");
        return words.length;
    }

}
