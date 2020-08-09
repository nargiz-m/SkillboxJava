package birds;

abstract public class Bird extends Animal
{
    public int legCount = 2;

    public Bird(double w) {
        super(w);
    }

    public void walk()
    {
        System.out.println("Walking");
    }

    public void run()
    {
        System.out.println("Running");
    }
}
