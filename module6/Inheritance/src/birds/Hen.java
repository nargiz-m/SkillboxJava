package birds;

public class Hen extends FlightlessBird
{
    public Hen()
    {
        super(620 + 5000 * Math.random());
    }

    public void dabGrains()
    {
        System.out.println("Dabbing grains");
    }

    public void eat()
    {
        dabGrains();
        ingest();
        digest();
    }

    @Override
    public void voice()
    {
        System.out.println("Ko-ko-ko! My weight is: " + weight + " gramms");
    }
}
