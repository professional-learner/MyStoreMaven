package pageObejects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
    WebDriver driver;

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
    WebElement confMessage;

    @FindBy(xpath = "//a[@title=\"Proceed to checkout\"]")
    WebElement checkOutButton;


    public void conferm() {
        confMessage.click();
        String acctualM = confMessage.getText();
        System.out.println(acctualM);
        Assert.assertEquals("Product successfully added to your shopping cart", acctualM);
    }

    public void proceadToCheckOut() {
        checkOutButton.click();
    }


}







