
public class Cat
{
    private Double originWeight;
    private Double weight;
    private Double amountOfFood;

    private Double minWeight;
    private Double maxWeight;
    static Integer count=0;

    public Cat()
    {
        this(1500.0 + 3000.0 * Math.random());
    }

    public Cat(Double weight)
    {
        this.weight = weight;
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        amountOfFood = 0.0;
        count = count + 1;
    }

    public Cat createTwin()
    {
        Cat cat2 = new Cat();
        cat2.weight = weight;
        cat2.originWeight = originWeight;
        return cat2;
    }

    public void meow()
    {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void meow(Double weight)
    {
        this.weight = this.weight - weight;
        System.out.println("Meow");
    }

    public static Double getWeightDifference(Cat cat1, Cat cat2)
    {
        Double difference = Math.abs(cat1.getWeight()-cat2.getWeight());
        return difference;
    }


    public static Integer getCount()
    {
        return count;
    }

    public void feed(Double amount)
    {
        weight = weight + amount;
        amountOfFood = amountOfFood + amount;
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
    }

    public void useTheBathroom()
    {
        weight = weight - 500;
        System.out.println("Used the bathroom");
    }

    public Double getWeight()
    {
        return weight;
    }

    public void setWeight(Double weight)
    {
        this.weight = weight;
        originWeight = weight;
    }

    public Double getAmountOfFood()
    {
        return amountOfFood;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            count = count - 1;
            return "Dead";
        }
        else if(weight > maxWeight) {
            count = count - 1;
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}