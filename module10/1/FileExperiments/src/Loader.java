import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        System.out.println("Enter directory: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine().trim();
        //path = "C:/Users/Наргиз/Desktop/JavaProjects0Pro1/MyFirstProject";

        File directoryPath = new File(path);
        getContents(directoryPath, 0);
    }

    private static void getContents(File directory, int n) {
        File[] files = directory.listFiles();
        n++;
        if (files != null) {
            for (File file : files) {
                for (int i = 1; i < n; i++) {
                    System.out.print("  ");
                }
                if (file.isFile()) {
                    System.out.println(file.getName() + " (" + file.length() + " bytes)");
                }
                if (file.isDirectory()) {
                    System.out.println(file.getName() + " (" + directorySize(file) + " bytes)");
                    getContents(file, n);
                }
            }
        }
    }

    private static long directorySize(File directory) {
        long length = 0;
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    length += file.length();
                }
                if (file.isDirectory()) {
                    length += directorySize(file);
                }
            }
        }
        return length;
    }
}
