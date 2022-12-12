package FileParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVFileParser {

    public CSVFileParser(String path) throws IOException {
        parser(path);
    }

    private void parser(String path) throws IOException {
        List<String> lines;
        Map<String, String> stationInfo = new HashMap<>();

        lines = Files.readAllLines(Paths.get(path));

        String firstLine = null;
        for (String line : lines){
            if (firstLine == null){
                firstLine = line;
                continue;
            }

            String[] nameAndDate = line.split(",");
            String nameStation = nameAndDate[0];
            String dateStation = nameAndDate[1];

            stationInfo.put(nameStation, dateStation);
        }

        for (String name : stationInfo.keySet()){
            String date = stationInfo.get(name);
            System.out.println(name + "\t" + date);
        }
    }
}
