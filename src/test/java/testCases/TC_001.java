
//Mhamood al-deen 25/4/22
package testCases;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObejects.AddToCartPage;
import pageObejects.DescriptionPage;
import pageObejects.HomePage;
import testBase.BaseClass;
import utilities.ExcelReader;

public class TC_001 extends BaseClass{
    HomePage hm;
    DescriptionPage dp;
    AddToCartPage atc;



        @Test
        public void test() throws Exception {
            HomePage hm=new HomePage(driver);
            DescriptionPage dp=new DescriptionPage(driver);
            AddToCartPage atc=new AddToCartPage(driver);


            excel = new ExcelReader();
            excel.setExcelFile("./testData/Book2.xlsx", "sheet1");

            hm.search();
            hm.captureList();
            dp.choose();
            atc.conferm();
            atc.proceadToCheckOut();


            excel = new ExcelReader();
            excel.setExcelFile("./testData/Book2.xlsx", "sheet1");

            WebElement description_txt =driver.findElement(By.xpath("//table[@id=\"cart_summary\"]//td//p[@class=\"product-name\"]"));
            System.out.println(description_txt.getText());
            WebElement colour_Size = driver.findElement(By.xpath("//table[@id=\"cart_summary\"]//td//a[contains(text(),\"Size\")]"));
            System.out.println(colour_Size.getText());
            WebElement costOfProduct = driver.findElement(By.xpath("//table[@id=\"cart_summary\"]//td[@id=\"total_product\"]"));
            System.out.println(costOfProduct.getText());
            WebElement costOfShiping = driver.findElement(By.xpath("//table[@id=\"cart_summary\"]//td[@id=\"total_shipping\"]"));
            System.out.println(costOfShiping.getText());
            WebElement totalBeforeTax = driver.findElement(By.xpath("//table[@id=\"cart_summary\"]//td[@id=\"total_price_without_tax\"]"));
            System.out.println(totalBeforeTax.getText());
            WebElement costOfTax = driver.findElement(By.xpath("//table[@id=\"cart_summary\"]//td[@id=\"total_tax\"]"));
            System.out.println(costOfTax.getText());
            WebElement total = driver.findElement(By.xpath("//table[@id=\"cart_summary\"]//td[@id=\"total_price_container\"]"));
            System.out.println(total.getText());

            excel.getCellData("Description",1);
            excel.getCellData("Description",2);
            excel.getCellData("Total products",1);
            excel.getCellData("Total shipping",1);
            excel.getCellData("Total",1);
            excel.getCellData("Tax",1);
            excel.getCellData("Total",1);
            //this is a comment


            assertEquals(description_txt.getText(),excel.getCellData("Description",1));
            assertEquals(colour_Size.getText(),excel.getCellData("Description",2));
            assertEquals(costOfProduct.getText(),excel.getCellData("Total products",1));
            assertEquals(costOfShiping.getText(),excel.getCellData("Total shipping",1));
            assertEquals(totalBeforeTax.getText(),excel.getCellData("Total",1));
            assertEquals(costOfTax.getText(),excel.getCellData("Tax",1));
            assertEquals(total.getText(),excel.getCellData("Total",1));


        }

    }


