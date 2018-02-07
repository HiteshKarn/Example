package com.example;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.lang.String;

public class StockMaster {
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Documents\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaerp.franciscanecare.net/Secure/");
        driver.manage().window().maximize();

        // Enter value in the text field as user name
        driver.findElement(By.id("txtUserName")).sendKeys("admin");

        // Enter value in the text field as password
        driver.findElement(By.id("txtPassword")).sendKeys("Admin#franciscan");

        // Click on login
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"form1\"]/div[4]/div/div/div/div/div[3]/a/img")).click();
        driver.findElement(By.xpath("//*[@id=\"form2\"]/div[4]/div/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"form2\"]/div[4]/div/ul/li[3]/ul/li[1]/a")).click();

    }
}
