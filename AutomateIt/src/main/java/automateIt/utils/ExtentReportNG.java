package automateIt.utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.*;
import com.aventstack.extentreports.reporter.configuration.*;

import java.text.*;
import java.util.*;

public class ExtentReportNG {
    public static ExtentReports extent;

    public static ExtentReports setupReports() throws Exception {
       String url=ReadPropertyFile.getProperty("appURL");
       String browser=ReadPropertyFile.getProperty("browser");
        String isRemoteExecutionOn=ReadPropertyFile.getProperty("remote_execution_mode");
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
        Date date = new Date();
        String actualdate=format.format(date);
        String reportPath=System.getProperty("user.dir")+"/Reports/ExecutionReport_"+actualdate+".html";
        ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(sparkReport);

        sparkReport.config().setDocumentTitle("DocumentTitle");
        sparkReport.config().setTheme(Theme.DARK);
        sparkReport.config().setReportName("ReportName");
        extent.setSystemInfo("Execeuted on Environment:", url);
        extent.setSystemInfo("Execeuted on Browser:",browser);
        extent.setSystemInfo("Execeuted on OS:", System.getProperty("os.name"));
        extent.setSystemInfo("Execeuted on User:", System.getProperty("user.dir"));
        extent.setSystemInfo("Test Executed on Remote: ",isRemoteExecutionOn);
        return extent;
    }
}
