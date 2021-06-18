package web.automation.utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;

public class ConfigReader {
    private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);
    private static JSONParser jsonParser;
    private static Object object;

    public static String getEnv() {
        String env = null;
        if (jsonParser == null) {
            jsonParser = new JSONParser();
        }
        try {
            FileReader file = new FileReader("./src/test/resources/env.json");
            object = jsonParser.parse(file);
            if (System.getProperty("env") != null) {
                env = System.getProperty("env");
            } else {
                env = (String) ((JSONObject) object).get("env");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return env;
    }

    public static String getData(String key) {
        String env = getEnv();
        logger.info("****************** Script started running against " + env + " environment ******************");
        JSONObject jsonObject = ((JSONObject) (((JSONObject) object).get(env)));
        return (String) jsonObject.get(key);
    }
}
