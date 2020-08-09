public class Loader
{
    public static void main(String[] args)
    {
        String text = "I soon noticed a special reasoning power he had, an unusual " +
                "reasoning power. Using it gave him great pleasure. He told me once, " +
                "with a soft and quiet laugh, that most men have windows over their " +
                "hearts; through these he could see into their souls. Then, he surprised " +
                "me by telling what he knew about my own soul; and I found that he " +
                "knew things about me that I had thought only I could possibly know. " +
                "His manner at these moments was cold and distant. His eyes looked " +
                "empty and far away, and his voice became high and nervous. At such " +
                "times it seemed to me that I saw not just Dupin, but two Dupins — " +
                "one who coldly put things together, and another who just as coldly " +
                "took them apart.";

        text = text.replaceAll("[^a-zA-Z ]", "");

        String words[] = text.split("\\s+");

        for (int i = 0; i < words.length; i++)
        {
            System.out.println(words[i]);
        }
    }
}
