package com.example.hoctest;

import initialization.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.*;


public class Dropdown_Dong extends Init {
    public static void main(String[] args) throws InterruptedException, AWTException {
        Setup();
        driver.navigate().to("https://techydevs.com/demos/themes/html/listhub-demo/listhub/index.html");
        Thread.sleep(2000);

        WebElement selectCountryElement = driver.findElement(By.xpath("//span[normalize-space()='Select a Country']"));
        selectCountryElement.click();

        Thread.sleep(2000);
        WebElement inputCountryElement = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        inputCountryElement.sendKeys("Vietnam");

        Thread.sleep(2000);
        //khai báo đối tượng thuộc lớp Action để hanlde trực tiếp KeyBoard của bàn phím máy tính
        Actions action = new Actions(driver);
        //Hàm build() để xây dựng hành động cho action, hàm perform() để xác nhận xây dựng đó
        action.sendKeys(Keys.ENTER).build().perform();


        finish();
    }
}
