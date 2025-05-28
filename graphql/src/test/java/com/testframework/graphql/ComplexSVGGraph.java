package com.testframework.graphql;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ComplexSVGGraph {
	
	
	
	
	@Test
	public void findXYCoordinatesOfElement() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_images_imagemap.asp");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.xpath("//img[@usemap='#workmap']"));
		int x = element.getRect().getX();
		int y = element.getRect().getY();
		System.out.println("x :"+ x + " y : "+ y);
		int leftTopPositionY = (element.getSize().getHeight()/2)- element.getSize().getHeight();
		int leftTopPositionX = (element.getSize().getWidth()/2)- element.getSize().getWidth();
		System.out.println("x from size :"+ leftTopPositionX + " y from size : "+ leftTopPositionY);
		Actions actions = new Actions(driver);
		actions.moveToElement(element, leftTopPositionX, leftTopPositionY).click().build().perform();
		driver.quit();;
	}

	@Test
	public void testSVGGraph() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/search?q=covid+cases+in+india&rlz=1C1RXQR_enIN966IN966&oq=coivd+cases&aqs=chrome.4.69i57j0i10i131i433i457j0i402l2j0i10i131i433l6.3577j0j4&sourceid=chrome&ie=UTF-8");
		WebElement element  = driver.findElement(By.xpath("(//*[local-name()='svg' and @class='uch-psvg'])[2]"));
		
		int leftTopPositionY = (element.getSize().getHeight()/2)- element.getSize().getHeight();
		int leftTopPositionX = (element.getSize().getWidth()/2)- element.getSize().getWidth();
		Actions actions =  new Actions(driver);
		Date startDate = new SimpleDateFormat("dd-MM-yyyyy").parse("20-03-2020");
		Date end_date = new Date();
		for(int i = 0; startDate.compareTo(end_date) < 0; i ++) {
			actions.moveToElement(element, leftTopPositionX+i, leftTopPositionY).perform();
			String data = driver.findElement(By.xpath("//table[@class='swWWne']/tbody")).getText();
			System.out.println(data);
			startDate = DateUtils.addDays(startDate, 1);
		}
		driver.quit();
	}	
}
