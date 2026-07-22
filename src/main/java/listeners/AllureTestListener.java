package listeners;

import io.qameta.allure.Allure;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.PrintWriter;
import java.io.StringWriter;

public class AllureTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result){
        Allure.step(
                "Started Test : "
                +result.getMethod().getMethodName()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result){
        Allure.step(
                "Passed Test : "+
                        result.getMethod().getMethodName()
        );
    }

    @Override
    public void onTestFailure(ITestResult result){
        Throwable throwable =
                result.getThrowable();

        if(throwable != null){
            Allure.addAttachment(
                    "Error Message",
                    throwable.getMessage()
            );
            StringWriter sw =
                    new StringWriter();

            PrintWriter pw =
                    new PrintWriter(sw);

            throwable.printStackTrace(pw);
            Allure.addAttachment(
                    "Stack Trace",
                    sw.toString()
            );
        }
    }

    @Override
    public void onTestSkipped(ITestResult result){
        Allure.step(
                "Skipped Test : "+
                        result.getMethod().getMethodName()
        );
    }
}
