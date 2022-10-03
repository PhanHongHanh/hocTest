package com.example.hoctest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class test1 {
    String baseUrl = "http://live.techpanda.org/";
    public WebDriver driver = new ChromeDriver();
    @Test
    public void testLogin(){
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        System.out.println("test login");
        WebElement account = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a"));
        account.click();
        WebElement logIn = driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[6]/a"));
        logIn.click();
        WebElement email = driver.findElement(By.id("email"));
        WebElement pass = driver.findElement(By.id("pass"));
        WebElement loginBT = driver.findElement(By.id("send2"));
        email.sendKeys("hanhruby2511@gmail.com");
        pass.sendKeys("5e8KRqXJf9tp2yg");
        loginBT.click();
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a")).click();

        //dùng kiểu dữ liệu true/false (boolean) để lưu giá trị check cái Header có hiển thị hay ko
        boolean headerMyWishlist = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div[1]/div")).isDisplayed(); //boolean giá trị được gán mặc định true/false
        if(headerMyWishlist == true){
            System.out.println("đến trang My wishlist");
        }
        boolean buttonAddToCart = driver.findElement(By.xpath("//*[@id=\"item_58379\"]/td[5]/div/button")).isEnabled();
        if(buttonAddToCart == true){
            driver.findElement(By.xpath("//*[@id=\"item_58379\"]/td[5]/div/button")).click();
        }
        else {
            System.out.println("ko click vào add to cart");
        }
        driver.close();
    }
}
