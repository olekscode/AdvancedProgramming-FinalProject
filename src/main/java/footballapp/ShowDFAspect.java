package footballapp;

import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import static footballapp.Constants.DEV;

@Service
@Aspect
@Profile(DEV)
public class ShowDFAspect {

    @Before("@annotation(ShowDataframeInTheBeginning)")
    public void showDFInTheBeginningOfMethod(JoinPoint jp){
        Dataset<Row> df = (Dataset<Row>) jp.getArgs()[0];
        System.out.println("ShowDFInTheBeginning aspect is working...");
        printToConsole(jp, df);
    }

    @AfterReturning(value = "@annotation(ShowDataframeInTheEnd)",returning = "dataFrame")
    public void showDFInTheEndOfMethod(JoinPoint jp,Dataset<Row> dataFrame){

        System.out.println("ShowDFInTheEnd aspect is working...");
        printToConsole(jp, dataFrame);
    }

    private void printToConsole(JoinPoint jp, Dataset<Row> dataFrame){
        dataFrame.show();
    }


}