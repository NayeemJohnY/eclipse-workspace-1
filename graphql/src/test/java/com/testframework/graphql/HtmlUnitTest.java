package com.testframework.graphql;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HtmlUnitTest {
	
	@Test
	public void testHtmlUnit() throws Exception{
		 try (final WebClient webClient = new WebClient()) {
		        final HtmlPage page = webClient.getPage("https://htmlunit.sourceforge.io/");
		        Assert.assertEquals("HtmlUnit – Welcome to HtmlUnit", page.getTitleText());
		        System.out.println(page.getTitleText());
		        final String pageAsXml = page.asXml();
		        System.out.println(pageAsXml);
		 }
	}
	
	@Test
	public void testHtmlUnitDriver() throws Exception{
	
		WebDriver webDriver = new HtmlUnitDriver(BrowserVersion.FIREFOX);
		webDriver.get("https://google.com");
		System.out.println(webDriver.getTitle());
		System.out.println(webDriver.getCurrentUrl());
		webDriver.findElement(By.name("q")).sendKeys("NayeemJohn");
		webDriver.findElement(By.name("btnK")).click();
		System.out.println(webDriver.getTitle());
		System.out.println(webDriver.getCurrentUrl());
	}
	
	

}
