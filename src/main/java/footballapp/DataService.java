package footballapp;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DataService {
    @Autowired
    private JavaSparkContext sc;

    @Autowired
    private SQLContext sqlContext;

    @Autowired
    private String pathToData;

    @Autowired
    private Config config;

    public DataFrame readData() {
        JavaRDD<String> rdd = sc.textFile(pathToData);
        rdd = rdd.filter(line->!line.isEmpty()); // filtering empty rows

        JavaRDD<Row> rowRdd = rdd.map(this::createRowFromLine);
        List<String> columnNames = config.getColumnNames();

        StructField[] fields = new StructField[columnNames.size()];

        for (int i = 0; i < fields.length; i++) {
            fields[i] = DataTypes.createStructField(columnNames.get(i), DataTypes.StringType, true);
        }

        DataFrame df = sqlContext.createDataFrame(
                rowRdd,
                DataTypes.createStructType(fields));

        return df;
    }

    public void writeData(DataFrame df) {

    }
}
