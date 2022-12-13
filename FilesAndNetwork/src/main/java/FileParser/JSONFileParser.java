package FileParser;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONFileParser {

    public JSONFileParser(String[] pathJson, String[] pathCSV) throws IOException {
        for (int i = 0; i < (pathJson.length + pathCSV.length) / 2; i++) {
            parser(pathJson[i], pathCSV[i]);
        }
    }

    private void parser(String pathJSON, String pathCSV) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonText = Files.readString(Paths.get(pathJSON));
        JSONFile[] jsonFiles = objectMapper.readValue(jsonText, JSONFile[].class);

        List<String> lines;
        Map<String, String> stationInfo = new HashMap<>();
        List<Station> stationsInfo = new ArrayList<>();
        Station station = new Station();

        String jsonFile = Files.readString(Paths.get("DataCollector\\map.json"));
        JsonNode jsonData = objectMapper.readTree(jsonFile);
        JsonNode stationNmae = jsonData.get("stations");
        JsonNode lineName = jsonData.get("lines");

        lines = Files.readAllLines(Paths.get(pathCSV));

        String firstLine = null;
        for (String line : lines) {
            if (firstLine == null) {
                firstLine = line;
                continue;
            }

            String[] nameAndDate = line.split(",");
            String nameStation = nameAndDate[0];
            String dateStation = nameAndDate[1];

            stationInfo.put(nameStation, dateStation);
        }

        for (JSONFile file : jsonFiles) {
            for (String name : stationInfo.keySet()) {
                String date = stationInfo.get(name);
                if (file.getStation_name().equalsIgnoreCase(name)){
                    file.setStation_name(name);
                    station.setDate(date);
                }

                if (file.getDepth().equalsIgnoreCase("?")){
                    file.setDepth("0");
                }
            }

            for (JsonNode line : lineName){
                String lineNumber = line.get("number").asText();
                String lineNames = line.get("line").asText();
                JsonNode stationList = stationNmae.get(lineNumber);
                for (JsonNode stationName : stationList){
                    if (file.getStation_name().equalsIgnoreCase(stationName.asText().replaceAll("\\\"+", "").trim())){
                        station.setLine(lineNames);
                    }
                }

            }

            stationsInfo.add(new Station(file.getStation_name(), station.getLine(), station.getDate(), file.getDepth(), true));

        }

        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("DataCollector\\stations.json"), new Stations(stationsInfo));
    }
}
