package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) {

        //1. setup chrome driver
        WebDriverManager.chromedriver().setup();

        //2.create chrome driver object
        ChromeDriver driver = new ChromeDriver();

        //3.Open some website, for example, google
        driver.get("http://google.com");


    }

}


