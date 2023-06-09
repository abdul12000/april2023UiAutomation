package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LambdaRegisterConfirmationPage {
    WebDriver driver;
    private By pageHeader = By.xpath("//h1[@class='page-title my-3']");

    public LambdaRegisterConfirmationPage(WebDriver driver){
        this.driver = driver;
    }
    public String  getPageheader(){
         return driver.findElement(pageHeader).getText();
    }

}
