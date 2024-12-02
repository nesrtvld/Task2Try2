package com.example.task2try2;

import org.junit.Test;
import static org.junit.Assert.*;

public class TextCounterTest {

    @Test
    public void testGetCharsCount() {
        String input = "Hello World!";
        int expected = 12;
        int result = TextCounter.getCharsCount(input);
        assertEquals(expected, result);
    }

    @Test
    public void testGetWordsCount() {
        TextCounter counter = new TextCounter();
        String input = "Hello, World! This is a test.";
        int expected = 6;
        int result = counter.getWordsCount(input);
        assertEquals(expected, result);
    }

    @Test
    public void testGetWordsCount_EmptyInput() {
        TextCounter counter = new TextCounter();
        String input = "";
        int expected = 0;
        int result = counter.getWordsCount(input);
        assertEquals(expected, result);
    }

    @Test
    public void testGetWordsCount_NullInput() {
        TextCounter counter = new TextCounter();
        String input = null;
        int expected = 0;
        int result = counter.getWordsCount(input);
        assertEquals(expected, result);
    }

    @Test
    public void testGetCharsCount_LongString() {
        String input = "Very very very very very very very very very very very very very very very long text.";
        int expected = input.length();
        int result = TextCounter.getCharsCount(input);
        assertEquals(expected, result);
    }

    @Test
    public void testGetWordsCount_DifferentDelimiters() {
        TextCounter counter = new TextCounter();
        String input = "Hello, world! This; is: a test.";
        int expected = 6;

        int result = counter.getWordsCount(input);

        assertEquals(expected, result);
    }

}
