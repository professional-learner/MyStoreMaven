package pageObejects;


import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id=\"search_query_top\"]")
    WebElement LnkSearchBox;

    @FindBy(xpath = "//div[@class='ac_results']//descendant::li[@class='ac_even']")
    List<WebElement> list;

    public void search() {
        LnkSearchBox.click();
        LnkSearchBox.sendKeys("Printed Summer Dress ");
    }

    public void captureList() {
        System.out.println("Total number of suggestion in serach box:::====>" + list.size());
        for (WebElement webElement : list) {
            System.out.println(webElement.getText());

            if (webElement.getText().contains("Printed Summer Dress")) {
                webElement.click();
                break;

            }

        }
    }

}