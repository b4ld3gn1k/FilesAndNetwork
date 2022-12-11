package JSON;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONFileParser {

    public JSONFileParser(String path) throws IOException {
        parser(path);
    }

    private void parser(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonText = Files.readString(Paths.get(path));

        JSONFile[] jsonFiles = objectMapper.readValue(jsonText, JSONFile[].class);

        for (JSONFile file : jsonFiles){
            System.out.println("station_name: " + file.getStation_name() + "\n" + "depth: " + file.getDepth() + "\n");
        }
    }
}
