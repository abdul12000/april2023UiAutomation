package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LambdaHomePage {
    WebDriver driver;
    private By myAccountButton = By.xpath("//span[contains(text(),'My account')]");
private By registerButton = By.xpath("//span[contains(text(),'Register')]");
    public LambdaHomePage(WebDriver driver){
        this.driver = driver;
    }
    public void  clickOnMyAccount(){
        driver.findElements(myAccountButton).get(1).click();
    }

    public void hooverOnMyAccountAndClickRegisterLink() {
        List<WebElement> myAccount = driver.findElements(myAccountButton);
//perform mouse move action onto the element
        new Actions(driver).moveToElement(myAccount.get(1)).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //clicking on the register link after using explicit wait
//        WebElement registerLink = driver.findElement(By.xpath("//span[contains(text(),'Register')]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerButton));
        driver.findElement(registerButton).click();
    }
}
