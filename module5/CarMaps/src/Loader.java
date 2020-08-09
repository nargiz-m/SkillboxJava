import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Loader
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, String> carNumbers = new TreeMap<>();
        for (;;)
        {
            System.out.println("Please, type car number:");
            String carNumber =  reader.readLine().trim();

            String carOwner = carNumbers.get(carNumber);
            if (carOwner == null) {
                System.out.println("Please, type owner");
                carOwner = reader.readLine().trim();
                carNumbers.put(carNumber, carOwner);
            }
            System.out.println(carNumber + " is a car of " + carNumbers.get(carNumber));
        }
    }
}
