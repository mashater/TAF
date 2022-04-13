import org.testng.ITestListener;

public class Listener implements ITestListener {
    public void onTestFailure(org.testng.ITestResult result) {
        System.out.println("Make a screenshot ");
    }


}
