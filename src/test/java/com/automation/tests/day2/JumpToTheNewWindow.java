package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {
    public static void main(String[]args) throws Exception{

        WebDriverManager.chromedriver().setup();

        WebDriver driver =  new ChromeDriver();
         driver.get("http://practice.cybertekschool.com/open_new_tab");

         Thread.sleep(5000);

         //every window has some id, this id called window handle
        //based on the window handle, we can switch in between windows
        String windowHandle = driver.getWindowHandle();

        System.out.println(windowHandle);

        //getWindowHandles() -returns id's of all currently opened windows
        //Set -does not allow duplicates

        Set<String> windowHandles =  driver.getWindowHandles();

        System.out.println(windowHandles);

        System.out.println("BEFORE SWITCH : " + driver.getCurrentUrl());
        /*Since, we have all windows and we know id of an original window
        * We can say switch to something that is not equal to old window id */
        for(String windowId : windowHandles){
            //If it is not an old window, then switch
            if(!windowId.equals(windowHandle)){
                driver.switchTo().window(windowId);//to jump to the new window
            }
        }

        System.out.println("AFTER SWITCH : " + driver.getCurrentUrl());


        driver.quit();

    }
    /**
     * This method helps to switch in between windowsbased on page title
     * @param pageTitle
     * @param driver
     * */
    public static void switchToWindowBasedTitle(String pageTitle, WebDriver driver){
    Set<String> windows = driver.getWindowHandles();
    for(String window: windows){
        driver.switchTo().window(window);
        if(driver.getTitle().equals(pageTitle)){
            break;
        }
    }
    }
}
