package footballapp;

import org.apache.spark.sql.DataFrame;
import org.springframework.stereotype.Service;

@Service
public class EnrichmentService {
    public DataFrame enrich(DataFrame df) {
        return df;
    }
}
