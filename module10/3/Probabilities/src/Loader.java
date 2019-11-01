import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Loader {
    public static void main(String[] args) throws IOException {
        String src = "res\\Probabilites.txt";
        String dest = "res\\formatted.txt";
        BufferedReader reader = new BufferedReader(new FileReader(src));

        HashMap<String, Integer> name = new HashMap<>();
        HashMap<String, Integer> date = new HashMap<>();
        String[][] objects = new String[100][100];

        int length = 0;
        String longestString = "";

        for(int i = 0;;i++) {
            String line = reader.readLine();
            if(line == null) break;
            String[] currentRow = line.trim().split("\\s+");
            if(i == 0) for(int j = 0; j < currentRow.length; j++) name.put(currentRow[j], j + 1);
            else {
                date.put(currentRow[0], i);
                for(int j = 1; j < currentRow.length; j++) {
                    objects[i][j] = currentRow[j];
                    if(objects[i][j].length() > length) {
                        length = objects[i][j].length();
                    }
                }
            }
        }
        name = sortByValue(name);
        date = sortByValue(date);

        PrintWriter pw = new PrintWriter(dest);
        pw.write("\t\t");
        for (String nameInstance : name.keySet()) {
            String strToPrint = "\t" + nameInstance;
            for(int j = 0; j < (length - nameInstance.length())/4; j++) strToPrint += "\t";
            pw.write("\t|" + strToPrint);
        }

        for(String dateInstance : date.keySet()) {
            pw.write("\n" + dateInstance);
            for(int i = 1; i <= name.size(); i++) {
                String strToPrint = "\t" + objects[date.get(dateInstance)][i];
                for(int j = 0; j < (length - objects[date.get(dateInstance)][i].length())/4; j++) strToPrint += "\t";
                pw.write("\t|" + strToPrint);
            }
        }
        pw.flush();
        pw.close();
    }

    private static HashMap<String, Integer> sortByValue(HashMap<String, Integer> unsorted){
        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsorted.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        HashMap<String, Integer> sorted = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sorted.put(entry.getKey(), entry.getValue());
        }
        return sorted;
    }
}
