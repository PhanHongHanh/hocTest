package initialization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class Init {
   // static String Url="https://mail.google.com/";
    public static WebDriver driver = new ChromeDriver();

    public static void Setup(){

        System.out.println("test:");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void finish() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("xong");
        //driver.close();
    }

}
