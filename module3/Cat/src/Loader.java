
public class Loader
{
    public static void main(String[] args)
    {
        System.out.println("Count: " + Cat.getCount());

        Cat liza = new Cat();
        Cat harry = new Cat();
        Cat meg = new Cat();
        Cat will = new Cat();
        Cat kate = new Cat();

        System.out.println("Count: " + Cat.getCount());

        System.out.println("Liza's weight: " + liza.getWeight());
        System.out.println("Harry's weight: " + harry.getWeight());
        System.out.println("Meg's weight: " + meg.getWeight());
        System.out.println("Will's weight: " + will.getWeight());
        System.out.println("Kate's weight: " + kate.getWeight());

        liza.feed(50.0);
        System.out.println("Liza's new weight: " + liza.getWeight());

        harry.drink(50.0);
        System.out.println("Harry's new weight: " + harry.getWeight());

        will.feed(7500.0);
        System.out.println("Will's new weight: " + will.getWeight());
        System.out.println("Will's status: " + will.getStatus());

        for (Integer i=0;i<3500;i++)
        {
            kate.meow();
        }

        System.out.println("Kate's new weight: " + kate.getWeight());
        System.out.println("Kate's status: " + kate.getStatus());

        System.out.println("Liza ate: " + liza.getAmountOfFood());
        System.out.println("Kate ate: " + kate.getAmountOfFood());

        meg.useTheBathroom();
        System.out.println("Meg's new weight: " + meg.getWeight());

        meg.meow(50.0);
        System.out.println("Meg's new weight: " + meg.getWeight());

        System.out.println("Liza's weight: " + liza.getWeight());
        System.out.println("Harry's weight: " + harry.getWeight());
        System.out.println("Difference: " + Cat.getWeightDifference(liza,harry));

        System.out.println("Count: " + Cat.getCount());

        Cat philip = new Cat(3000.0);
        System.out.println("Philip's weight: " + philip.getWeight());
        System.out.println("Count: " + Cat.getCount());


        System.out.println("Kitten's weight: " + getKitten().getWeight());

        Cat diana = new Cat();
        diana.setWeight(liza.getWeight());
        System.out.println("Count: " + Cat.getCount());

        System.out.println("Liza's weight: " + liza.getWeight());
        System.out.println("Diana's weight: " + diana.getWeight());

        diana.feed(10000.0);

        System.out.println("Liza's status: " + liza.getStatus());
        System.out.println("Diana's status: " + diana.getStatus());

        Cat ann = liza.createTwin();
        System.out.println("Ann's weight: " + ann.getWeight());
    }

    public static Cat getKitten()
    {
        Cat kitten = new Cat(100+100*Math.random());
        return kitten;
    }
}