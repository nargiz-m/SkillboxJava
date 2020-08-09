import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class Loader
{
    public static void main(String[] args)
    {
        String array[] = {"Red", "Orange", "Yellow", "Green", "Cyan", "Blue", "Violet"};

        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }

        String numbers[] = new String[2277];
        int j = 0;
        for (int i=1; i < 100; i++) {
            Year year=Year.of(1997);
            while (year.isBefore(Year.now().plusYears(1))) {
                if(i/10==0) {
                    numbers[j] = "0" + i;
                }
                else {
                    numbers[j] = "" + i;
                }

                numbers[j] += year.format(DateTimeFormatter.ofPattern("uu")).toString() ;
                year = year.plusYears(1);
                j++;
            }
        }

        for (String item: numbers) {
            System.out.println(item);
        }

        String chess[][] = new String[8][8];
        char[] symbols = {'A','B','C','D','E','F','G','H'};
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                chess[i][k] = Character.toString(symbols[i]) + (k + 1);
                System.out.print(chess[i][k]+" ");
            }
            System.out.println();
        }
    }
}
