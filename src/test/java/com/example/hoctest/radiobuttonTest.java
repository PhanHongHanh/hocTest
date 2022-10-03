package com.example.hoctest;

import initialization.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class radiobuttonTest extends Init {
    public static void main(String[] args) throws InterruptedException {
        Setup();
        driver.navigate().to("https://demo.anhtester.com/basic-radiobutton-demo.html");
        WebElement radio_Male = driver.findElement(By.xpath("//label[normalize-space()='Male']//input[@name='optradio']"));
        if(radio_Male.isSelected()==true){
            System.out.println("Male được chon");
        }
        else {
            radio_Male.click();
            System.out.println("vừa chọn");

        }
        Thread.sleep(1000);
        WebElement radio_Female=driver.findElement(By.xpath("//label[normalize-space()='Female']//input[@name='optradio']"));

        if(radio_Female.isSelected()==true){
            System.out.println("Female được chọn ->sai");
        }
        else {
            System.out.println("Female ko được chọn ->đúng");
        }

        //----Group radio button---
        WebElement radio_Age_5_15 = driver.findElement(By.xpath("//input[@value='5 - 15']"));
        radio_Age_5_15.click();

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",radio_Age_5_15);

        WebElement button_GetValues = driver.findElement(By.xpath("//button[normalize-space()='Get values']"));
        button_GetValues.click();
        WebElement mgs_button_getValuse =driver.findElement(By.xpath("//p[@class='groupradiobutton']"));
        System.out.println(mgs_button_getValuse.getText());

        if(mgs_button_getValuse.getText().contains("Age group: 5 - 15")) // tìm "Age group: 5 - 15" chứa trong
        {
            System.out.println("đã chọn tuổi từ 5-15");
        }
        else {
            System.out.println("chưa chọn đúng tuổi");
        }


        finish();
    }
}
