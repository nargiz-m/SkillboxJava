import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Loader {
    public static void main(String[] args) {
        Path src = Paths.get("res", "Probabilites.txt");
        Path dest = Paths.get("res", "formatted.txt");

        try (FileReader fileReader = new FileReader(src.toString());
             BufferedReader reader = new BufferedReader(fileReader);
             PrintWriter pw = new PrintWriter(dest.toString()))
        {
            HashMap<String, Integer> name = new HashMap<>();
            pw.write("\t\t");

            int length = 0;

            for (int i = 0; ; i++) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                String[] currentRow = line.trim().split("\\s+");
                if (i == 0) {
                    for (int j = 0; j < currentRow.length; j++) {
                        name.put(currentRow[j], j + 1);
                        if (currentRow[j].length() > length) {
                            length = currentRow[j].length();
                        }
                    }
                    name = sortByValue(name);
                    for (String nameInstance : name.keySet()) {
                        StringBuilder strToWrite = new StringBuilder();
                        strToWrite.append("\t" + nameInstance);
                        for (int j = 0; j < (length - nameInstance.length()) / 4; j++) {
                            strToWrite.append("\t");
                        }
                        pw.write("\t|" + strToWrite);
                    }
                } else {
                    for (int j = 1; j < currentRow.length; j++) {
                        if (currentRow[j].length() > length) {
                            length = currentRow[j].length();
                        }
                    }
                    pw.write("\n" + currentRow[0]);
                    for (int j = 1; j < currentRow.length; j++) {
                        StringBuilder strToWrite = new StringBuilder();
                        strToWrite.append("\t" + currentRow[j]);
                        for (int k = 0; k < (length - currentRow[j].length()) / 4; j++) {
                            strToWrite.append("\t");
                        }
                        pw.write("\t|" + strToWrite);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static HashMap<String, Integer> sortByValue(HashMap<String, Integer> unsorted) {
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
