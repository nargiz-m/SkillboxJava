import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loader {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter source URL:");
        String src = scanner.nextLine().trim(); //https://www.google.ru/

        System.out.println("Enter destination directory:"); //C:/Users/Наргиз/Desktop/exp/
        String dest = scanner.nextLine().trim();

        URL url = new URL(src);
        Document doc = Jsoup.parse(url, 10000);
        Elements elements = doc.select("img");

        List<URL> imagePaths = new ArrayList<>();
        for (Element element : elements) {
            String attribute = element.attr("src");
            if (attribute.lastIndexOf('.') == attribute.length() - 4) {
                if (attribute.substring(0, 4).equals("http")) imagePaths.add(new URL(attribute));
                if (attribute.substring(0, 2).equals("//")) imagePaths.add(new URL("http:" + attribute));
                else if (attribute.charAt(0) == '/') imagePaths.add(new URL(src + attribute));
            }
        }

        for (URL path : imagePaths) {
            saveImage(path, dest);
        }
    }

    private static void saveImage(URL path, String dest) throws IOException {
        String fileName = path.getFile();
        String destName = dest + fileName.substring(fileName.lastIndexOf("/"));
        System.out.println(destName);

        InputStream is = path.openStream();
        FileOutputStream fos = new FileOutputStream(destName);

        for (; ; ) {
            int code = is.read();
            if (code < 0) break;
            fos.write(code);
        }
        fos.flush();
        fos.close();
    }
}
