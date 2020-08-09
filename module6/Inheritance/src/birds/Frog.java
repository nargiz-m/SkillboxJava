package birds;

public class Frog extends Animal
{
    public Frog()
    {
        super(100 + (500 * Math.random()));
    }

    public void catchInsects()
    {
        System.out.println("Catched insect");
    }

    @Override
    public void eat()
    {
        catchInsects();
        ingest();
        digest();
    }

    public void jump() {
        System.out.println("Jumping");
    }

    @Override
    public void voice() {
        System.out.println("Kva-kva-kva! My weight is: " + weight + " gramms");
    }
}
