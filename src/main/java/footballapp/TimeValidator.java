package footballapp;

import org.apache.spark.sql.DataFrame;

public class TimeValidator implements Validator {
    public DataFrame validate(DataFrame df) {
        return df;
    }
}
