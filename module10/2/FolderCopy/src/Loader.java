import java.io.IOException;
import java.nio.file.*;
import java.util.EnumSet;
import java.util.Scanner;

public class Loader {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Set source folder: ");
        String src = scanner.nextLine().trim(); //C:/Users/Наргиз/Desktop/JavaProjects0Pro1/MyFirstProject/
        Path source = Paths.get(src);

        System.out.println("Set destination folder: ");
        String dest = scanner.nextLine().trim(); //C:/Users/Наргиз/Desktop/exp/
        Path target = Paths.get(dest).resolve(source.getFileName());

        EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        MyFileVisitor myFileVisitor = new MyFileVisitor(source, target);
        Files.walkFileTree(source, opts, Integer.MAX_VALUE, myFileVisitor);
    }
}

