package birds;

abstract public class Animal implements Vertebrata, Comparable<Animal>
{
    protected double weight;

    public Animal(double w)
    {
        weight = w;
    }

    @Override
    public void move() {
        System.out.println("Moving");
    }

    abstract public void eat();

    @Override
    public int compareTo(Animal animal) {
        return Double.compare(this.weight, animal.weight);
    }

    //==============================================================

    protected final void ingest()
    {
        System.out.println("Ingesting");
    }

    protected final void digest()
    {
        System.out.println("Digesting");
    }
}
