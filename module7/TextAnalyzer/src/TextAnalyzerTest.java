import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextAnalyzerTest
{
    @Test
    public void analyzer_will_return_list_of_1_word()
    {
        List<String> actualWords = new TextAnalyzer("hello").getWords();
        List<String> expectedWords = Arrays.asList("hello");
        Assert.assertEquals(expectedWords, actualWords);
    }

    @Test
    public void analyzer_will_return_list_of_4_words()
    {
        List<String> actualWords = new TextAnalyzer("Hello, my friend, hello!").getWords();
        List<String> expectedWords = Arrays.asList("hello","my","friend","hello");
        Assert.assertEquals(expectedWords, actualWords);
    }

    @Test
    public void analyzer_will_return_list_words()
    {
        List<String> actualWords = new TextAnalyzer("Hey 123 hi 345").getWords();
        List<String> expectedWords = Arrays.asList("hey","hi");
        Assert.assertEquals(expectedWords, actualWords);
    }

    @Test
    public void analyzer_will_return_empty_list()
    {
        ArrayList<String> actualWords = new TextAnalyzer(null).getWords();
        ArrayList<String> expectedWords = new ArrayList<>();
        Assert.assertEquals(expectedWords, actualWords);
    }

    @Test
    public void analyzer_will_return_empty_list_for_empty_string()
    {
        ArrayList<String> actualWords = new TextAnalyzer("").getWords();
        ArrayList<String> expectedWords = new ArrayList<>();
        Assert.assertEquals(expectedWords, actualWords);
    }

    @Test
    public void analyzer_will_return_null()
    {
        String actualWord = new TextAnalyzer(null).getMostFrequentWord();
        Assert.assertEquals(null, actualWord);
    }

    @Test
    public void analyzer_will_return_null_instead_of_empty_string()
    {
        String actualWord = new TextAnalyzer("").getMostFrequentWord();
        Assert.assertEquals(null, actualWord);
    }

    @Test
    public void analyzer_will_return_only_word()
    {
        String actualWord = new TextAnalyzer("hello").getMostFrequentWord();
        Assert.assertEquals("hello", actualWord);
    }

    @Test
    public void analyzer_will_return_word()
    {
        String actualWord = new TextAnalyzer("123 hey 123").getMostFrequentWord();
        Assert.assertEquals("hey", actualWord);
    }

    @Test
    public void analyzer_will_return_most_frequent_word_out_of_4()
    {
        String actualWord = new TextAnalyzer("Hello, my friend, hello!").getMostFrequentWord();
        Assert.assertEquals("hello", actualWord);
    }

    @Test
    public void analyzer_will_return_first_word_if_even_numbers() {
        String actualWord = new TextAnalyzer("My friend, hello!").getMostFrequentWord();
        Assert.assertEquals("my", actualWord);
    }

    @Test
    public void analyzer_will_return_first_word_of_even_frequent() {
        String actualWord = new TextAnalyzer("Hello, my friend, hello! Friend").getMostFrequentWord();
        Assert.assertEquals("hello", actualWord);
    }
}
