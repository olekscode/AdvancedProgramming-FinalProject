package quoter;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf();
        conf.setAppName("Football App");
        conf.setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> rdd = sc.textFile("../data/rawData.txt");

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//        PropertiesReader codesPropertiesReader = context.getBean(CodesPropertiesReader.class);
//
//        try {
//            Properties codesProperties = codesPropertiesReader.getProperties();
//            System.out.println(codesProperties.getProperty("1"));
//        }
//        catch (IOException error) {
//            System.out.println(error);
//        }
    }
}
