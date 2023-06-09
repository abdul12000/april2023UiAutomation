package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LambdaMyAccountPage {
    WebDriver driver;
    By continueButton = By.linkText("Continue");

    public LambdaMyAccountPage(WebDriver driver){
        this.driver = driver;
    }
    public void  clickOnContinueButton(){
        driver.findElement(continueButton).click();
    }

}
