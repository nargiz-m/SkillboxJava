import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        System.out.println("Введите директорию: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine().trim();
        //path = "C:/Users/Наргиз/Desktop/JavaProjects0Pro1/MyFirstProject";

        File directoryPath = new File(path);
        getContents(directoryPath, 0);
    }

    private static void getContents(File directory, int n) {
        File[] files = directory.listFiles();
        n++;
        if(files != null) {
            for (File file : files) {
                for (int i = 1; i < n; i++) System.out.print("  ");
                if (file.isFile()) {
                    System.out.println(file.getName() + " " + file.length());
                }
                if (file.isDirectory()) {
                    System.out.println(file.getName() + " " + Objects.requireNonNull(file.listFiles()).length);
                    getContents(file, n);
                }
            }
        }
    }
}
