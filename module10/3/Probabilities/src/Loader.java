import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Loader {
    public static void main(String[] args) {
        Path src = Paths.get("res", "Probabilites.txt");
        Path dest = Paths.get("res", "formatted.txt");

        try (FileReader fileReader = new FileReader(src.toString(), Charset.forName("windows-1251"));
             BufferedReader reader = new BufferedReader(fileReader);
             PrintWriter pw = new PrintWriter(dest.toString()))
        {
            pw.write("\t\t");
            for (int i = 0; ; i++) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }

                String[] currentRow = line.trim().split("\\s+");
                pw.write(writeFormattedRow(currentRow, i) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder writeFormattedRow(String[] currentRow, Integer rowType){
        int length = 0;
        StringBuilder strToWrite = new StringBuilder();
        int start = rowType == 0 ? 0 : 1;
        for (int j = start; j < currentRow.length; j++) {
            if (currentRow[j].length() > length) {
                length = currentRow[j].length();
            }
        }
        if (start == 1) strToWrite.append(currentRow[0]);
        for (int j = start; j < currentRow.length; j++) {
            StringBuilder currentValue = new StringBuilder();
            currentValue.append("\t").append(currentRow[j]);
            for (int k = 0; k < (length - currentRow[j].length()) / 4; k++) {
                currentValue.append("\t");
            }
            strToWrite.append("\t|").append(currentValue);
        }
        return strToWrite;
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
