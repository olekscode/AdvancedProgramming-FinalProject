package footballapp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    public Properties readProperties(String propertiesFileName) {
        Properties props = new Properties();

        try {
            props.load(new FileInputStream(propertiesFileName));
        }
        catch (Exception error) {
            System.out.println(error);
        }

        return props;
    }


}
