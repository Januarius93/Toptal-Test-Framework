package webautomation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {

    private Properties properties;
    private InputStream inputStreamPropertyPath;
    private static String PROPERTY_PATH = "/confs/project.properties";

    public Properties getProperties() {
        return properties;
    }

    public PropertyFileReader readPropertyFile() {
        inputStreamPropertyPath = this.getClass().getResourceAsStream(PROPERTY_PATH);
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(PROPERTY_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

}
