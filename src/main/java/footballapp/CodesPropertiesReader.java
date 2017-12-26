package footballapp;

import lombok.Setter;

public class CodesPropertiesReader extends PropertiesReader {
    @Setter
    private String propertiesFileName;

    protected String getPropertiesFileName() {
        return propertiesFileName;
    }
}
