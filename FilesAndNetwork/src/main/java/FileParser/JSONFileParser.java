package FileParser;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
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

            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(new File("dataTwo.json"), jsonFiles);
    }
}
