package pageObejects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DescriptionPage {
    WebDriver driver;


    public DescriptionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@name=\"qty\"]")
    WebElement quantityButton;
    @FindBy(id = "group_1")
    WebElement productSize;
    @FindBy(xpath = "//a[@name=\"Blue\"]")
    WebElement colour;
    @FindBy(xpath = "//button[@type=\"submit\"][./span[text()='Add to cart']]")
    WebElement addToCartButton;


   public void choose(){

       quantityButton.clear();
       quantityButton.sendKeys("2");

       Select select = new Select(productSize);
       select.selectByVisibleText("M");
       colour.click();

       addToCartButton.click();
   }
}




