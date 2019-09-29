import java.io.File;
import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        System.out.println("Введите директорию: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine().trim();
        //path = "C:/Users/Наргиз/Desktop/JavaProjects0Pro1/MyFirstProject";

        File directoryPath = new File(path);
        File[] files = directoryPath.listFiles();
        for(File file : files) {
            if(file.isFile()) System.out.println(file.getName() + " " + file.length());
            if(file.isDirectory())
            {
                System.out.println(file.getName());
                getContents(file, 0);
            }
        }
    }

    public static void getContents(File directory, int n) {
        File[] files = directory.listFiles();
        n++;
        for(File file : files) {
            for(int i = 0; i < n; i++) System.out.print("  ");
            if(file.isFile()) System.out.println(file.getName() + " " + file.length());
            if(file.isDirectory()) {
                System.out.println(file.getName());
                getContents(file, n);
            }
        }
    }
}
