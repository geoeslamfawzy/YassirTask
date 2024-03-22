package helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.FrameworkConstants;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class JsonHelper {
    private final String fileName;

    public JsonHelper(String fileName) {
        this.fileName = FrameworkConstants.readDataFile(fileName + ".json");
    }

    public String extractData(String tokenName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(new File(fileName));
        JsonNode tokenNode = rootNode.get(tokenName);
        return tokenNode.asText();
    }

    public HashMap<String, String> getJsonDataToMap(String tokenPath) throws IOException {
        String jsonContent = FileUtils.readFileToString(new File(fileName), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonContent);
        JsonNode dataNode = rootNode.path(tokenPath);
        return mapper.convertValue(dataNode, HashMap.class);
    }

    public Object[][] getJsonData(String tokenPath) throws IOException {
        Object[][] objs = new Object[getJsonDataToMap(tokenPath).size()][2];
        // String[][] objs = new String[getJsonDataToMap(tokenPath).size()][2];
        int index = 0;
        for (Map.Entry<String, String> entry : getJsonDataToMap(tokenPath).entrySet()) {
            objs[index][0] = entry.getKey();
            objs[index][1] = entry.getValue();
            index++;
        }
        return objs;
    }

    public Map<String, String>[] getJsonDataArray(String tokenPath) throws IOException {
        Map<String, String>[] dataArray = new Map[getJsonDataToMap(tokenPath).size()];
        int index = 0;
        for (Map.Entry<String, String> entry : getJsonDataToMap(tokenPath).entrySet()) {
            dataArray[index] = new HashMap<>();
            dataArray[index].put(entry.getKey(), entry.getValue());
            index++;
        }
        return dataArray;
    }


}