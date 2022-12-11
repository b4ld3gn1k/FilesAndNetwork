package MoscowUndergroundParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;


public class ParseMoscowUnderground {

    public ParseMoscowUnderground(String url) throws Exception {
        parseMoscowUnderground(url);
    }

    private void parseMoscowUnderground(String url) throws Exception{
        String idBrowser = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36 OPR/92.0.0.0";


        Document document = Jsoup.connect(url).userAgent(idBrowser).referrer("http://www.google.com").get();
        Elements linesUnderground = document.select("span.js-metro-line.t-metrostation-list-header.t-icon-metroln");
        Elements stationsUnderground = document.select("div.js-metro-stations.t-metrostation-list-table");
        Elements connections = stationsUnderground.select("p.single-station");

        Set<String> connect = new HashSet<>();
        Set<String> lines = new HashSet<>();
        Map<String, String[]> allStations = new HashMap<>();
        String[] stations;

        for (Element line : linesUnderground){
            lines.add(line.text() + " №" + line.attr("data-line"));
        }

        for (Element connects : connections){
            String tmp;
            tmp = connects
                    .select("span.t-icon-metroln")
                    .attr("title")
                    .replaceAll("^[а-я]+\\s[а-я]+\\s[а-я]+\\s", "");
            if (tmp.isEmpty()){
                continue;
            }
            connect.add(tmp.substring(1, tmp.indexOf('»')));
        }

        for (Element line : stationsUnderground){
                stations = line.text().replaceAll("\\.\s", ".").split("\s\b");

            for (String s : lines){
                if (s.replaceAll("[А-я]+-?\\s?\\d?\\s?\\W+", "").equalsIgnoreCase(line.attr("data-line"))){
                    allStations.put(s, stations);
                }
            }
        }

        //allStations.forEach((key, value) -> System.out.println(key + " ->" + Arrays.toString(value)));
        //lines.forEach(System.out::println);
        //connect.forEach(System.out::println);
        //connections.forEach(System.out::println);

    }

    /*private void parseMoscowUnderground(String url) throws Exception{
        String idBrowser = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36 OPR/92.0.0.0";


        Document document = Jsoup.connect(url).userAgent(idBrowser).referrer("http://www.google.com").get();
        Elements linesUnderground = document.select("span.js-metro-line.t-metrostation-list-header.t-icon-metroln");
        Elements stationsUnderground = document.select("div.js-metro-stations.t-metrostation-list-table");
        Elements connections = document.select("span.t-icon-metroln");

        Set<String> lines = new LinkedHashSet<>();
        Map<String, String[]> allStations = new HashMap<>();
        String[] stations;

        for (Element line : linesUnderground){
            lines.add(line.text() + " -> " + line.attr("data-line"));
        }

        for (Element line : stationsUnderground){
            stations = line.text().replaceAll("\\.\s", ".").split("\s\b");
            allStations.put("Линия " + line.attr("data-line"), stations);
        }

        allStations.forEach((key, value) -> System.out.println(key + " -> " + Arrays.toString(value)));

        for (String s : lines){
            if (s.isEmpty()) continue;
            System.out.println(s);
        }

    }*/

    private void downloadSourceAndCreateFile(String url) throws Exception{
        URLConnection connection = new URL(url).openConnection();
        InputStream inputStream = connection.getInputStream();

        FileOutputStream fileOutputStream = new FileOutputStream("data\\UndergroundSource.html");
        int v;
        while ((v = inputStream.read()) != -1){
            fileOutputStream.write(v);
        }

        fileOutputStream.flush();
        fileOutputStream.close();
        inputStream.close();
    }
}
