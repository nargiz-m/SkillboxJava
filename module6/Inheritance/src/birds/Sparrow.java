package birds;

public class Sparrow extends FlyingBird
{
    public Sparrow()
    {
        super(100 + 300 * Math.random());
    }

    public void catchSmallInsect()
    {
        System.out.println("Catched small insect");
    }

    public void eat()
    {
        catchSmallInsect();
        ingest();
        digest();
    }

    @Override
    public void voice()
    {
        System.out.println("Chirp-Chirp! My weight is: " + weight + " gramms");
    }
}
