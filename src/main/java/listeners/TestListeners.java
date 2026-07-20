package listeners;

import io.qameta.allure.Allure;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.PrintWriter;
import java.io.StringWriter;

public class TestListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result){
        System.out.println(
                "STARTED : " +
                        result.getMethod().getMethodName()
        );

        Allure.step(
                "Test Started : "+
                        result.getMethod().getMethodName()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println(
                "PASSED : "+
                        result.getMethod().getMethodName()
        );

        Allure.step(
                "Test Passes : "+
                        result.getMethod().getMethodName()
        );

    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println(
                "FAILED : "+
                        result.getMethod().getMethodName()
        );

        Throwable throwable = result.getThrowable();

        if(throwable != null){
            Allure.addAttachment(
                    "Failed Message",
                    throwable.getMessage()
            );

            StringWriter sw = new StringWriter();

            throwable.printStackTrace(
                    new PrintWriter(sw)
            );
            Allure.addAttachment(
                    "Stack Trace",
                    sw.toString()
            );
        }
    }

    @Override
    public void onTestSkipped(ITestResult result){
        System.out.println(
                "SKIPPED : "+
                        result.getMethod().getMethodName()
        );

        Allure.step(
                "Test Skipped : "+
                        result.getMethod().getMethodName()
        );
    }

    @Override
    public void onStart(ITestContext context){
        System.out.println(
                "==== TEST SUIT STARTED"
        );
    }

    @Override
    public void onFinish(ITestContext context){
        System.out.println(
                "==== TEST SUIT FINISHED"
        );
    }


}
