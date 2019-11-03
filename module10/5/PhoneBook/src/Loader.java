import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String,String> phoneBook = new TreeMap<>();
        for (;;)
        {
            System.out.println("Please, type command, name or number(starting with 79):");
            String command = reader.readLine().trim();
            if (command.equals("LIST")){
                for (String name : phoneBook.keySet()){
                    System.out.println(name + ": " + phoneBook.get(name));
                }
            } else if(command.equals("EXPORT")) {
                System.out.println("Please, type the directory for phone book:");
                String path = reader.readLine().trim();
                PrintWriter pw = new PrintWriter(path);
                JSONObject object = new JSONObject();
                int i = 1;
                for (String name : phoneBook.keySet()){
                    JSONObject value = new JSONObject();
                    value.put("name", name);
                    value.put("number", phoneBook.get(name));
                    object.put(i, value);
                    i++;
                }
                pw.write(object.toJSONString());
                pw.flush();
                pw.close();
            } else {
                Pattern p = Pattern.compile("79.+");
                Matcher m = p.matcher(command);
                if(m.find()){
                    String name = null;
                    for (Map.Entry<String,String> pair : phoneBook.entrySet()){
                        if (command.equals(pair.getValue())) {
                            name = pair.getKey();
                        }
                    }
                    if (name == null) {
                        System.out.println("Please, type the name:");
                        name = reader.readLine().trim();
                        phoneBook.put(name, command);
                    }
                    System.out.println(command + " is the number of " + name);
                }
                else {
                    String phone = phoneBook.get(command);
                    if (phone == null) {
                        System.out.println("Please, type the number, starting with 79:");
                        phone = reader.readLine().trim();
                        phoneBook.put(command, phone);
                    }
                    System.out.println(command + "'s number: " + phone);
                }
            }
        }
    }
}
