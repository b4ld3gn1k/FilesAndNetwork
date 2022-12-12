package MoscowUndergroundParser;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.*;

public class ParseMoscowUnderground {

    public ParseMoscowUnderground(String url) throws Exception {
        parseMoscowUnderground(url);
    }

    private void parseMoscowUnderground(String url) throws Exception {
        String idBrowser = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36 OPR/92.0.0.0";

        Document document = Jsoup.connect(url).userAgent(idBrowser).referrer("http://www.google.com").get();
        Elements linesUnderground = document.select("span.js-metro-line.t-metrostation-list-header.t-icon-metroln");
        Elements stationsUnderground = document.select("div.js-metro-stations.t-metrostation-list-table");
        Elements connections = stationsUnderground.select("p.single-station");

        Map<String, String[]> allStations = new HashMap<>();
        List<Line> lineAndNum = new ArrayList<>();

        String[] stations;

        for (Element e : linesUnderground)
            lineAndNum.add( new Line(e.attr("data-line"), e.text().replaceAll("[А-я]+$", "").trim()));

        for (Element e : stationsUnderground){
            stations = e.text().replaceAll("[0-9]+\\.\\s", "").split("\s\b");
            allStations.put(e.attr("data-line"), stations);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("map.json"), new Underground(allStations, lineAndNum));



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
}