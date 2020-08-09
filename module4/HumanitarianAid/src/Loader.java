import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader
{
    public static void main(String[] args) throws IOException
    {
        int maxContainers = 12;
        int maxBoxes = 27;

        int vehicleNumber = 0;
        int containerNumber = 0;

        int boxesForHelp = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());

        for (int i=1; i<=boxesForHelp; i++)
        {
            if ((i-1) % maxBoxes == 0 || i == 1)
            {
                containerNumber++;

                if ((containerNumber-1) % maxContainers == 0 || containerNumber == 1)
                {
                    vehicleNumber++;
                    System.out.println("Truck " + vehicleNumber + ":");
                }

                System.out.println("Container " + containerNumber + ":");
            }

            System.out.println("Box " + i);
        }
    }
}
