package com.basePage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass
{
    public static WebDriver driver;
    public Properties properties;
    public static WebDriverWait wait;

    public BaseClass()
    {
        String filePath="C://Users//ELCOT//IdeaProjects//StudentApplicationForm//src//main//resources//InputData";
        properties=new Properties();
        try
        {
            FileInputStream file=new FileInputStream(filePath);
            properties.load(file);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }

    public void navigateToApplication()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait=new WebDriverWait(driver,Duration.ofSeconds(40));
        driver.get(properties.getProperty("url"));
    }

    public void writeText(String text, WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public void clickButton(WebElement element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void quitApplications()
    {
        try
        {
            Thread.sleep(10000);
            driver.quit();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }

    public static String captureScreenshot(String testName)
    {
        String path = "screenshots/" + testName + ".png";
        try
        {
            TakesScreenshot screenshot=(TakesScreenshot) driver;
            File src=screenshot.getScreenshotAs(OutputType.FILE);
            File file=new File(path);
            FileHandler.copy(src,file);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        return path;
    }

}