package birds;

import java.util.Comparator;

public class BirdsComparator implements Comparator<Bird>
{
    @Override
    public int compare(Bird b1, Bird b2) {
        return Double.compare(b1.weight, b2.weight);
    }
}
