import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Loader {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Set source folder: ");
        String src = scanner.nextLine().trim();
//        String src = "C:/Users/Наргиз/Desktop/JavaProjects0Pro1/MyFirstProject/";

        System.out.println("Set destination folder: ");
        String dest = scanner.nextLine().trim();
//        String dest = "C:/Users/Наргиз/Desktop/exp/";

        File directoryPath = new File(src);
        File[] files = directoryPath.listFiles();
        for(File file : files) {
            Files.copy(
                    file.toPath(),
                    (new File(dest + file.getName())).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
            if(file.isDirectory()) getContents(file, dest);
        }
    }

    public static void getContents(File directoryPath, String dest) throws IOException {
        File[] files = directoryPath.listFiles();
        dest = dest + '/' + directoryPath.getName() + '/';
        for(File file : files) {
            Files.copy(
                    file.toPath(),
                    (new File(dest + file.getName())).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
            if(file.isDirectory()) getContents(file, dest);
        }
    }
}

