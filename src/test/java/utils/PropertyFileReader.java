package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {

    private Properties properties;
    private InputStream inputStreamPropertyPath;
    private static String PROPERTY_PATH = "/confs/ezegarki.properties";

    public Properties getProperties(){
        return properties;
    }

    public PropertyFileReader readPropertyFile() throws IOException {
        inputStreamPropertyPath = this.getClass().getResourceAsStream(PROPERTY_PATH);
        properties = new Properties();
        properties.load(this.getClass().getResourceAsStream(PROPERTY_PATH));
        return this;
    }

}
