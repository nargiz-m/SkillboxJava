import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Loader {
    public static void main(String[] args) throws IOException {
        String path = "res/Page.html";
        Document doc = Jsoup.parse(new File(path), "utf-8");
        Elements elements = doc.select("img");
        for(Element element : elements) System.out.println(element.attr("data-original"));
    }
}
