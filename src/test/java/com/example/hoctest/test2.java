package com.example.hoctest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class test2 {
    String baseUrl = "http://live.techpanda.org/";
    public WebDriver driver = new ChromeDriver();
    @Test
    public void testLogin() throws InterruptedException {
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //set t/g cho tat cả các step
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[6]/a")).click();
        driver.findElement(By.id("email")).sendKeys("hanhruby2511@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("5e8KRqXJf9tp2yg");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/div/a")).click();
        driver.findElement(By.className("cart-link")).click();
        Select stateProvince = new Select(driver.findElement(By.id("region_id")));
        stateProvince.selectByVisibleText("New York");
        driver.findElement(By.id("postcode")).sendKeys("5442896");
        driver.findElement(By.xpath("//*[@id=\"shipping-zip-form\"]/div/button/span")).click();
        Thread.sleep(2000);
        WebElement flatRate =driver.findElement(By.id("s_method_flatrate_flatrate"));
        if (flatRate.isSelected() == true){
            System.out.println("đã được chọn");
        }
        else {
            flatRate.click();
        }
        driver.findElement(By.xpath("//*[@id=\"co-shipping-method-form\"]/div/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div/div[3]/div/ul/li[1]/button/span")).click();
        Thread.sleep(4000);
        System.out.println("xong!");
        driver.close();
    }
}
