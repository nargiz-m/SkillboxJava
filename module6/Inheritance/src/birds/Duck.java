package birds;

public class Duck extends FlyingBird
{
    public Duck()
    {
        super(720 + 1000 * Math.random());
    }

    public void swim()
    {
        System.out.println("Swimming");
    }

    public void catchFish()
    {
        System.out.println("Catched fish");
    }

    public void eat()
    {
        catchFish();
        ingest();
        digest();
    }

    @Override
    public void voice()
    {
        System.out.println("Krya-krya! My weight is: " + weight + " gramms");
    }
}
