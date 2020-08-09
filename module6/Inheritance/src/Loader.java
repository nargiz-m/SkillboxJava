import birds.*;

import java.util.ArrayList;
import java.util.Collections;

public class Loader
{
    public static void main(String[] args)
    {
        ArrayList<Animal> animals = new ArrayList<>();
        addAnimals(animals);

        Collections.sort(animals, new VertebrataComparator());
        //Collections.sort(animals);
        for (Animal animal : animals)
        {
            animal.voice();
        }
    }

    public static void addAnimals(ArrayList<Animal> animals)
    {
        animals.add(new Duck());
        animals.add(new Duck());
        animals.add(new Hen());
        animals.add(new Hen());
        animals.add(new Duck());
        animals.add(new Ostrich());
        animals.add(new Sparrow());
        animals.add(new Frog());
        animals.add(new Frog());
        animals.add(new Sparrow());
        animals.add(new Ostrich());
        animals.add(new Hen());
        animals.add(new Duck());
    }
}
