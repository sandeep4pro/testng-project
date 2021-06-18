package web.automation.utilities;

import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;

public class PropertiesFileReader {
    public static String getData(String fileName, String key) {
        Properties properties = new Properties();
        try {
            Reader fileReader = new FileReader("./src/test/resources/" + fileName + ".properties");
            properties.load(fileReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}
