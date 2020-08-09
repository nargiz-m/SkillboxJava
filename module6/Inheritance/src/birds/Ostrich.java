package birds;

public class Ostrich extends FlightlessBird
{
    public Ostrich()
    {
        super(55000 + 100000 * Math.random());
    }

    public void tearOffLeaves()
    {
        System.out.println("Tearinq off leaves");
    }

    public void eat()
    {
        tearOffLeaves();
        ingest();
        digest();
    }

    @Override
    public void voice()
    {
        System.out.println("Boom-boom! My weight is: " + weight + " gramms");
    }

}
