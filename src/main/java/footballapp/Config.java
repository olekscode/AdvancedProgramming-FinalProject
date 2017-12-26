package footballapp;

import lombok.Getter;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SQLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Configuration
@ComponentScan
public class Config {

    @Getter
    private List<String> columnNames;

    private PropertiesReader propertiesReader = new PropertiesReader();

    @Autowired
    private SparkConf sparkConf;

    @Bean
    public JavaSparkContext sc() {
        return new JavaSparkContext(sparkConf);
    }

    @Bean
    public SQLContext sqlContext(){
        return new SQLContext(sc());
    }

    @PostConstruct
    public void initialize() {
        Properties props = propertiesReader.readProperties("data/football_columns.properties");
        String columnNamesStr = props.getProperty("columnNames");
        this.columnNames = Arrays.asList(columnNamesStr.split(","));
    }
}
