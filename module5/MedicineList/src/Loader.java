import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Loader {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<String> meds = new TreeSet<>();
        for (;;) {
            System.out.println("Please, type command or next medicine:");
            String command = reader.readLine().trim();
            if (command.equals("LIST")){
                for (String item : meds){
                    System.out.println(item);
                }
            }
            else {
                meds.add(command);
            }
        }
    }
}
