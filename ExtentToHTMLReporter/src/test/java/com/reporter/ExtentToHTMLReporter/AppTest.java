package com.reporter.ExtentToHTMLReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.JsonFormatter;

import software.amazon.awssdk.auth.signer.params.Aws4PresignerParams;
import software.amazon.awssdk.protocols.json.internal.unmarshall.AwsJsonResponseHandler;

public class AppTest {
	
	 private static final String JSON_ARCHIVE = "target/json/jsonArchive.json";
	public static void main(String[] args) {
		ExtentReports extent = new ExtentReports();
		Aws4PresignerParams
        JsonFormatter json = new JsonFormatter(JSON_ARCHIVE);
        extent.attachReporter(json);
        ExtentTest test1 = extent.createTest("Testname1", "description1")
                .pass("Pass")
                .skip("Skip")
                .fail("Fail");
        test1.assignCategory("SpellCheck");
        test1.assignCategory("Error");
        test1.addScreenCaptureFromPath(JSON_ARCHIVE);
        test1.createNode("Nested Test1", "Logs").pass("Pass nested node").fail("Nested node");
        ExtentTest test2 = extent.createTest("Testname2", "description2")
                .warning("Warn")
                .info("Info");
        extent.flush();
        test2.assignCategory("Grammer");
        test2.addScreenCaptureFromPath("Tes2t");
        extent.flush();
        System.out.println("nayeem");
	}

}
