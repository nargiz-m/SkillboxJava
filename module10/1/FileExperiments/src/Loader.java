import java.io.File;
import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        System.out.println("Enter directory: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine().trim();
        //path = "C:/Users/Наргиз/Desktop/JavaProjects0Pro1/MyFirstProject";

        File directoryPath = new File(path);
        System.out.println(directoryPath.getName());
        long totalSize = getContents(directoryPath, 1);
        System.out.println("Total size of the directory: " + totalSize + " bytes");
    }

    private static long getContents(File directory, int n) {
        long length = 0;
        File[] files = directory.listFiles();
        n++;
        if (files != null) {
            for (File file : files) {
                for (int i = 1; i < n; i++) {
                    System.out.print("  ");
                }
                if (file.isFile()) {
                    System.out.println(file.getName() + " (" + file.length() + " bytes)");
                    length += file.length();
                }
                if (file.isDirectory()) {
                    System.out.println(file.getName());
                    length += getContents(file, n);
                }
            }
        }
        return length;
    }
}
