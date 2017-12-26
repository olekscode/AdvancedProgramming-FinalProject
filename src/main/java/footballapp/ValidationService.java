package footballapp;

import org.apache.spark.sql.DataFrame;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    public DataFrame validate(DataFrame df) {
        return df;
    }
}
