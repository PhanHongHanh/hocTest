package com.example.hoctest;

import initialization.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Dropdown_Tinh extends Init {
    public static void main(String[] args) throws InterruptedException {
        Setup();

        driver.navigate().to("https://demo.anhtester.com/basic-select-dropdown-demo.html");

        Thread.sleep(2000);

        //---hendle dropdow tĩnh

        //lấy element của thẻ "select" html
        WebElement element = driver.findElement(By.xpath("//select[@id='select-demo']"));

        //khai bảo đối tượng kiểu select cho elemennt trên
        Select selectSimple= new Select(element);

        selectSimple.selectByVisibleText("Thursday");// lấy theo text hiển thị
        System.out.println("chọn thursday");
        Thread.sleep(1000);

        //Nếu lấy theo Index vi tri bằng 3 chọn index 2
        selectSimple.selectByIndex(2);
        System.out.println("Chọn Monday");
        Thread.sleep(1000);

        selectSimple.selectByValue("Wednesday");//lấy theo value của thẻ option
        System.out.println("Chọn Wednesday");
        Thread.sleep(1000);

        //--- kiểm tra có phải dạng Multi select hay không
        selectSimple.isMultiple();
        if(selectSimple.isMultiple()==true){
            System.out.println("đay là Mulit slect");
        }
        else {
            System.out.println("không phải Multi select");
        }

        Thread.sleep(1000);
        System.out.println(selectSimple.getOptions().size());//kiểm tra số lượng thẻ option

        Thread.sleep(1000);
        System.out.println(selectSimple.getFirstSelectedOption().getText()); //kiểm tra giá trị option đa được chọn hiển thị option gần nhất đã chọn

        if(selectSimple.getFirstSelectedOption().getText()=="Monday"){
            System.out.println("đúng lựa chọn gần nhất");
        }
        else {
            System.out.println("sai k phải lựa chọn gần nhất");
        }
        Thread.sleep(1000);
        List<WebElement> getAlloption = selectSimple.getOptions();//kiểm tra hiển thị tất cả option

        for (int i=0; i<getAlloption.size(); i++){
            System.out.println(getAlloption.get(i).getText());//hiển thị text
            Thread.sleep(1000);
            System.out.println(getAlloption.get(i).getAttribute("value")); //hiển thị value trong rom
        }


        finish();
    }


}
