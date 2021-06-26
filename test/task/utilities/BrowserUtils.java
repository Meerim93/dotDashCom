package utilities;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BrowserUtils {
    public static String takeScreenShot(){

        // We use getScreenshotAs method to get the screenshot from our driver.
        // We convert output to the FILE type
        File source=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);

        // System.getPropery("user.dir"); --> it will give the current project file directory.
        // CurrentTimeMillis() --> we use this method to get unique name for our every screenshot file.
        String destination=System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";

        // Create one File Object for Destination
        File des= new File(destination);

        try{

            FileUtils.copyFile(source, des);

        }catch (IOException e){
            e.printStackTrace();
        }

        return destination;
    }
    public static void wait(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

}