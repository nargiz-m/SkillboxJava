package birds;

import java.util.Comparator;

public class VertebrataComparator implements Comparator<Animal>
{
    @Override
    public int compare(Animal a1, Animal a2) {
        return Double.compare(a1.weight, a2.weight);
    }
}
