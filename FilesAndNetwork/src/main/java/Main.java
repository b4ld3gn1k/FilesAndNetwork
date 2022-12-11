import CSV.CSVFileParser;
import JSON.JSONFileParser;

public class Main {

    public static void main(String[] args) {
        String url = "https://skillbox-java.github.io";
        String path = "data/";
        String JSONPath = "data\\2\\4\\depths-1.json";
        // data\\4\\6\\depths-3.json | data\\7\\1\\depths-2.json
        String CSVPath = "data\\0\\5\\dates-2.csv";
        // data\4\6\dates-1.csv | data\9\6\dates-3.csv

        try {
            MoscowUndergroundParser.ParseMoscowUnderground parseMoscowUnderground = new MoscowUndergroundParser.ParseMoscowUnderground(url);
            //SearchFiles.SearchFileInFolders searchFileInFolders = new SearchFiles.SearchFileInFolders(path);
            //JSONFileParser jsonFileParser = new JSONFileParser(JSONPath);
            //CSVFileParser csvFileParser = new CSVFileParser(CSVPath);
        } catch (Exception ex) {
            System.out.println("Что-то пошло не так...\n" + ex.getMessage());
            ex.printStackTrace();

        }
    }
}
