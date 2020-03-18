import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Otrezki {

    public static class Interval {
        public final int from;
        public final int to;
        public final String name;

        public Interval(int from, int to, String name) {
            this.from = from;
            this.to = to;
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("[%2d-%2d] (%s)", from, to, name);
        }
    }

    public static void main(String[] args) {
        String str =
           "     a-----a\n"             +
           "  b-----b\n"                +
           "          c-----c\n"        +
           "                   d-d\n"   +
           "e---------------------e\n"  +
           "                          f---f\n";
        List<Interval> intervals = Arrays.stream(str.split("\n"))
                .map(Otrezki::fromRow)
                .collect(Collectors.toList());

        System.out.println("Имеются отрезки:");
        intervals.forEach(System.out::println);

        System.out.println("");
        System.out.println("Из них пересекаются:");
        findIntersections(intervals).forEach(group -> {
            System.out.printf(" - %s",
                    group.stream().map(i -> i.name).collect(Collectors.joining(",")));
            System.out.println();
        });

        // Для примера выше:
        // Из них пересекаются (вариант ответа 1):
        // a,b
        // a,e
        // a,c
        // b,a
        // b,e
        // c,e
        // d,e

        // Из них пересекаются (вариант ответа 2):
        // a,b,e
        // a,c,e
        // d,e
    }

    public static List<List<Interval>> findIntersections(List<Interval> intervals) {
        List<List<Interval>> intersections = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            for(int j = i + 1; j < intervals.size(); j++) {
                if(isIntersect(intervals.get(i), intervals.get(j))) {
                    intersections.add(new ArrayList<>(Arrays.asList(intervals.get(i), intervals.get(j))));
                }
            }
        }
        return intersections;
    }


    public static boolean isIntersect(Interval i1, Interval i2) {
        return !(i1.from >= i2.to || i2.from >= i1.to);
    }

    public static Interval fromRow(String str) {
        var firstSymbol = Pattern.compile("^\\s*([a-z])").matcher(str);
        var lastSymbol = Pattern.compile("^(.*[a-z])\\s*$").matcher(str);
        if (firstSymbol.find() && lastSymbol.find()) {
            return new Interval(
                    firstSymbol.group().length() - 1,
                    lastSymbol.group(1).length() - 1,
                    firstSymbol.group(1));
        }
        throw new RuntimeException("Bad format of string: " + str);
    }
}
