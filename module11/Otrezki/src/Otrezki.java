import java.util.regex.Pattern;

public class Otrezki {

    public static class Interval {
        public final int from;
        public final int to;

        public Interval(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return String.format("[%d-%d]", from, to);
        }
    }
    public static void main(String[] args) {
        String str1 = "a-----b";
        String str2 = "   c-----d";

        Interval i1 = Otrezki.fromRow(str1);
        Interval i2 = Otrezki.fromRow(str2);

        System.out.println("i1: " + str1);
        System.out.println("i2: " + str2);
        System.out.println("intersect? " + isIntersect(i1, i2));
    }


    public static boolean isIntersect(Interval i1, Interval i2) {
        return i1.from < i2.from && i2.from < i1.to; // TODO
    }

    public static Interval fromRow(String str) {
        var firstSymbol = Pattern.compile("^(\\s*[a-z])").matcher(str);
        var lastSymbol = Pattern.compile("^(.*[a-z])\\s*$").matcher(str);
        if (firstSymbol.find() && lastSymbol.find()) {
            return new Interval(firstSymbol.group().length() - 1, lastSymbol.group(1).length() - 1);
        }
        throw new RuntimeException("Bad format of string: " + str);
    }
}
