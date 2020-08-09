import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class Loader {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> blatNumbers = new ArrayList<>();
        char[] symbols = {'A','B','E','K','M','H','O','P','C','T','Y','X'};

        for (int j = 0; j < symbols.length; j++){
            for (int jj = 0; jj < symbols.length; jj++) {
                for (int jjj = 0; jjj < symbols.length; jjj++) {
                    for (int reg =1; reg < 100; reg++) {
                        for (int i = 1; i < 10; i++) {
                            int num = i;
                            /* blatNumbers.add(symbols[j] + "00" + num + symbols[jj] + symbols[jjj] + "0" + reg);
                            num = i*10;
                            blatNumbers.add(symbols[j] + "0" + num + symbols[jj] + symbols[jjj] + "0" + reg);
                            num = i*100;
                            blatNumbers.add(symbols[j] + "" + num + symbols[jj] + symbols[jjj] + "0" + reg);
                            num = i*101;
                            blatNumbers.add(symbols[j] + "" + num + symbols[jj] + symbols[jjj] + "0" + reg);*/
                            num = i*111;
                            String result = String.format("%s%d%s%s%02d", symbols[j], num, symbols[jj], symbols[jjj],reg);
                            blatNumbers.add(result);
                        }
                    }
                }
            }
        }

        for (int i = 1; i<1000; i++) {
            for (int j = 0; j < symbols.length; j++){
                for (int reg =1; reg < 100; reg++) {
                    String result = String.format("%s%03d%s%s%02d", symbols[j], i, symbols[j], symbols[j], reg);
                    blatNumbers.add(result);
                }
            }
        }

        HashSet<String> blatNumbersHash = new HashSet(blatNumbers);
        TreeSet<String> blatNumbersTree = new TreeSet(blatNumbers);

        for(;;) {
            System.out.println("Please, type the number");
            String number = reader.readLine().trim().toUpperCase();
            boolean blat = false;

            long start = System.nanoTime();
            if (blatNumbers.contains(number)) {
                    blat = true;
            }
            System.out.println(blat + " (" + (System.nanoTime() - start) + " ms)");

            Collections.sort(blatNumbers);
            start = System.nanoTime();
            if (Collections.binarySearch(blatNumbers,number)>0) {
                blat = true;
            }
            System.out.println(blat + " (" + (System.nanoTime() - start) + " ms)");

            start = System.nanoTime();
            if (blatNumbersHash.contains(number)) {
                blat = true;
            }
            System.out.println(blat + " (" + (System.nanoTime() - start) + " ms)");

            start = System.nanoTime();
            if (blatNumbersTree.contains(number))
            {
                blat = true;
            }
            System.out.println(blat + " (" + (System.nanoTime() - start) + " ms)");
        }
    }
}
