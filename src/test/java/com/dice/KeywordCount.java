package com.dice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeywordCount {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<String> keyword = new ArrayList<>();
		keyword.add("Senior Programmer");
		keyword.add("Junior Programmer");
		keyword.add("Java Developer");
		keyword.add("Java Software Engineer");
		keyword.add("Web Developer-Java Mid Level");
		keyword.add("Java Developer-Back End");
		keyword.add("Java Developer-Java, AJAX");
		keyword.add("Selenium, HP QC ALM tester");
		keyword.add("Automation Tester");
		keyword.add("Sr. QA Automation Engineer");
		keyword.add("Software QA Engineer");
		keyword.add("Automated tester");
		keyword.add("Automation Tester/SDET");
		keyword.add("QA Analist");
		keyword.add("Senior Tester Developer");
		keyword.add("QA Automation");
		keyword.add("Test Engineer");
		keyword.add("SDET Tester");
		keyword.add("System Analyst");
		keyword.add("End to End Tester");
		
		List<String> newKeywords=new ArrayList<>();
		
		
		for(int i=0; i<keyword.size(); i++){
			String url="https://dice.com";
			driver.get(url);
			driver.findElement(By.id("search-field-keyword")).clear();
			driver.findElement(By.id("search-field-keyword")).sendKeys(keyword.get(i));
			String location = "22203";
			driver.findElement(By.id("search-field-location")).clear();
			driver.findElement(By.id("search-field-location")).sendKeys(location);
			driver.findElement(By.id("findTechJobs")).click();
			String count = driver.findElement(By.id("posiCountId")).getText();
			newKeywords.add(keyword.get(i)+"-"+count.replaceAll(",", ""));	
			
		}
		
		System.out.println(newKeywords);
		
		//===========Reading from .txt file=============
		
		List<String> ReadnewKeywords=new ArrayList<>();
		
		try {
			FileReader reader = new FileReader("ITjobs.txt");
			BufferedReader br = new BufferedReader(reader);
			String str;
			while((str=br.readLine())!=null) {
			String url="https://dice.com";
			driver.get(url);
			driver.findElement(By.id("search-field-keyword")).clear();
			driver.findElement(By.id("search-field-keyword")).sendKeys(str);
			String location = "22102";
			driver.findElement(By.id("search-field-location")).clear();
			driver.findElement(By.id("search-field-location")).sendKeys(location);
			driver.findElement(By.id("findTechJobs")).click();
			String count = driver.findElement(By.id("posiCountId")).getText();
			ReadnewKeywords.add(str+"-"+count.replaceAll(",", ""));	
			}
		}catch(IOException e) {
			System.out.println("File Not Found");
		}
			
		driver.close();
		System.out.println(ReadnewKeywords);
	}

}
