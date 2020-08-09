import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Loader {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<String> airplaneStop = new ArrayDeque<>();

        for (;;)
        {
            System.out.println("Please, type number of airplane or command");
            String input = reader.readLine().trim();
            if (input.equals("exitAll")) {
                while(airplaneStop.size()>0) {
                    System.out.println("Exits the parking space: " + airplaneStop.pop());
                }
            }
            else if (input.equals("exitLast")) {
                System.out.println("Exits the parking space: " + airplaneStop.pop());
            }
            else {
                if (airplaneStop.size()<5) {
                    airplaneStop.push(input);
                }
                else {
                    System.out.println("No space left");
                }
            }
        }
    }
}
