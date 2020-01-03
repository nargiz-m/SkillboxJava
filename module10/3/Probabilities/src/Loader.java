import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private static Map<String, Integer> sortWithStreams(HashMap<String, Integer> unsorted) {
        Stream<Map.Entry<String, Integer>> unsortedStream = unsorted.entrySet().stream();
        Stream<Map.Entry<String, Integer>> sortedStream = unsortedStream.sorted(Map.Entry.comparingByValue());
        return sortedStream.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
