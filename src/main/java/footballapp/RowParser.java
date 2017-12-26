package footballapp;

import org.apache.avro.generic.GenericData;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RowParser {
    @Autowired
    private Config config;

    public Row parse(String line) {
        String[] pairs = line.split(";");
        List<String> values = new ArrayList<>();

        for (String pair : pairs) {
            String[] keyValues = pair.split("=");
            values.add(keyValues[1]);
        }

        return RowFactory.create(values.toArray());
    }
}
