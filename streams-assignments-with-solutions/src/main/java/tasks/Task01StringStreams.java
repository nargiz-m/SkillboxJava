package tasks;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Task01StringStreams {

    /**
     * Функция должна вернуть число строчных символов в строке.
     *
     * Пример:
     *  "abcDE" -> 3
     *  "ABC" -> 0
     */
    static long countLowercaseLetters(String str) {
        try {
            int count = 0;
            for (int i = 0; i < str.length(); i++){
                if(Character.isLowerCase(str.charAt(i))) {
                    count++;
                }
            }
            return count;
        } catch (Exception e) {
            throw new PleaseImplementMeException();
        }
    }


    /**
     * Функция должна заменить каждое слово в строке его длинной.
     *
     * Слова разделяются одним или более пробелами.
     *
     * Пример:
     *   "a b cd" -> "1 1 2"
     *   "one two   three" -> "3 3 5"
     *
     * Тут подойдут эти методы:
     *    - String::split
     *    - Stream::map
     *    - Stream::collect
     *    - Collectors.joining
     */
    static String replaceWordsOnLength(String str) {
        try {
            Stream<String> wordStream = Arrays.stream(str.split("\\s+")).map(x -> Integer.toString(x.length()));
            return wordStream.collect(Collectors.joining(" "));
        } catch (Exception e) {
            throw new PleaseImplementMeException();
        }
    }
}