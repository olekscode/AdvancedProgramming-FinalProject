package footballapp;

import org.apache.spark.sql.DataFrame;

public interface Validator {
    DataFrame validate(DataFrame df);
}
