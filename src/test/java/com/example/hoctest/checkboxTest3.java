package com.example.hoctest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import initialization.*;
import org.testng.Assert;

public class checkboxTest3 extends Init {

    //static Init init = new Init(); // dạng static các hàm có trong mail đểu phải đưa về static
    public static void main(String[] args) throws InterruptedException {
        Setup();
        driver.navigate().to("https://demo.anhtester.com/basic-checkbox-demo.html");
        //driver.findElement(By.id("isAgeSelected")).click(); //click trước >> ktra sau

        //kiểm tra checkbox đã được check hay chưa
        Boolean isSelected = driver.findElement(By.id("isAgeSelected")).isSelected();
        Thread.sleep(1000);

        if (isSelected == false) {
            System.out.println("chưa được chọn!");
            driver.findElement(By.id("isAgeSelected")).click();//Nếu chưa được check thì click vào ô checkbox
            //System.out.println("đa chọn!"); //kiểm tra sau khi click
            WebElement msgDisplayed = driver.findElement(By.id("txtAge"));
            if(msgDisplayed.isDisplayed()==true){
                System.out.println("vừa chọn");
                System.out.println(msgDisplayed.getText());
            }
            Thread.sleep(1000);
        }
        else {
            Thread.sleep(1000);
            System.out.println("đã chọn!");
        }
        WebElement button_CheckAll =driver.findElement(By.id("check1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",button_CheckAll); //chuyển đến mục chọn
        Thread.sleep(1000);
        //System.out.println(button_CheckAll.getAttribute("value")); //get "check all"
        if(button_CheckAll.getAttribute("value").equals("Check All")) {
            button_CheckAll.click();//click để check all
        }
        else {
            System.out.println("không lấy được!");
        }
        Thread.sleep(1000);
        //cách 1
//        WebElement Checkbox1 = driver.findElement(By.className("cb1-element"));
//        if(Checkbox1.isSelected()==true){
//            System.out.println("đã chọn!");
//        }
//        else {
//            System.out.println("Lỗi chưa chọn.");
//        }
        //Cach 2
        //dùng findElements lấy số lượng thẻ div có class là checkbox (class là checkbox cho nhiều checkbox giống nhau)
        var listCheckbox = driver.findElements(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[@class='chechbox']"));//thêm thẻ div[@class='chechbox' trong mục để đếm
        System.out.println(listCheckbox.size());// in ra số lượng trên

        //dùng for để chay từ 1 đến hết số lượng trên (listCheckbox.size())
        for (int i=1; i<=listCheckbox.size();i++){
            //tìm đến element cụ thể theo thứ tự i của vòng lặp for
            WebElement Checkbox = driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div[2]/div[2]/div["+ i +"]/label/input"));
            if(Checkbox.isSelected()==true){
                System.out.println("checbox"+ i +" đã được chọn.");
            }
            else {
                System.out.println("sai. checkbox thư \"+i\" chưa được chọn.");
                //Assert.assertTrue(Checkbox.isSelected()); //testcase  fall
            }
        }

        //kiểm tra nut check all thành uncheck all
        WebElement button_unCheckAll =driver.findElement(By.id("check1"));
        if(button_unCheckAll.getAttribute("value").equals("Uncheck All")){
            System.out.println("đã được chuyển nut check all");
        }
        finish();
    }
}
