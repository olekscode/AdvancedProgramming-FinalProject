package footballapp;

import org.apache.spark.sql.DataFrame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static footballapp.Constants.PROD;

public class Main {
    public static void main(String[] args) {

        System.setProperty("spring.profiles.active", PROD);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        DataService dataService = context.getBean(DataService.class);
        ValidationService validationService = context.getBean(ValidationService.class);
        EnrichmentService enrichmentService = context.getBean(EnrichmentService.class);

        DataFrame df = dataService.readData();

        df = validationService.validate(df);
        df = enrichmentService.enrich(df);

        dataService.writeData(df);
        context.close();
    }
}
