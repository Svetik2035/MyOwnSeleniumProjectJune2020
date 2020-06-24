package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String []args) throws Exception {

        /*
         * to start selenium script, we need:
         * 1.setup webDriver (browser driver)
         * */
        WebDriverManager.chromedriver().setup();
        //2. Create WebDriver Object
        WebDriver driver = new ChromeDriver();
        /*
         * In Selenium, everything starts from  WebDriver interface
         * ChromeDriver extends RemoteWebDriver --> implements WeDriver
         * */
        driver.get("http://google.com");//to open a website
        driver.manage().window().maximize();

        Thread.sleep(3000);//for demo, wait 3 seconds
        /*
         * Method that returns page title
         * you can also see it as tab name, in browser
         * */
        String title = driver.getTitle();//returns <title> Some title</title> text
        String expectedTitle = "Google";

        System.out.println("Title is.." + title);

        if (expectedTitle.equals(title)) {
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }
        //go to another website
        driver.navigate().to("http://amazon.com");// to close browser
        Thread.sleep(3000);//for demo wait 3 seconds
        if (driver.getTitle().toLowerCase().contains("amazon")) {
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("tEST FAILED!");
        }
        driver.navigate().back();
        Thread.sleep(3000);

        verifyEquals(driver.getTitle(), "Google");
        driver.navigate().forward();
        Thread.sleep(3000);
        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getTitle());

        driver.navigate().refresh();//reload the page
        Thread.sleep(3000);
        driver.close();



    }
   public static void verifyEquals(String arg1, String arg2){
            if (arg1.equals(arg2)) {
                System.out.println("TEST PASSED!");
            } else {
                System.out.println("TEST FAILED!");
            }
        }}
