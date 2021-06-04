package automateIt.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {
    public static ExtentReports extent;

    public static ExtentReports setupReports() throws Exception {
    	
    	boolean ispurgeAllPreviousReportsTillYesterday=Boolean.parseBoolean(ReadPropertyFile.getProperty("purgeAllPreviousReportsTillYesterday"));
    	purgePreviousReports(ispurgeAllPreviousReportsTillYesterday);
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
    
    public static void purgePreviousReports(boolean ispurgeAllPreviousReportsTillYesterday) {
    	if(ispurgeAllPreviousReportsTillYesterday) {
    	String dir = System.getProperty("user.dir")+"/Reports/";

        // cutoff date:
        Instant today = Instant.now().minus(1, ChronoUnit.DAYS);

        // find with filter
        try {
			List<Path > listPaths=Files.find(Paths.get(dir), Integer.MAX_VALUE,
			    (p, a) -> {
			        try {
			            return Files.isRegularFile(p)
			                && Files.getLastModifiedTime(p).toInstant().isBefore(today);
			        }
			        catch(IOException e) {
			            throw new RuntimeException(e);
			        }
			    })
			    .collect(Collectors.toList());
			for(Path path:listPaths) {
				path.toFile().delete();
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	}
    }
}
