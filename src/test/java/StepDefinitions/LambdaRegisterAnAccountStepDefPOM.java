package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LambdaHomePage;
import pages.LambdaMyAccountPage;
import pages.LambdaRegisterConfirmationPage;
import pages.LambdaRegistrationPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LambdaRegisterAnAccountStepDefPOM {
    WebDriver driver;

    @Before
    public void initialize(){
        //1st : Creating driver instance for Chrome
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities dp = new DesiredCapabilities();
        dp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(dp);
        driver = new ChromeDriver(options);
//implicit wait:
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //maximize the screen
        driver.manage().window().maximize();
    }
    @Given("I am on the Lambdatest home page {string}")
    public void i_am_on_the_lambdatest_home_page(String lambdaUrl) {
////1st : Creating driver instance for Chrome
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        DesiredCapabilities dp = new DesiredCapabilities();
//        dp.setCapability(ChromeOptions.CAPABILITY, options);
//        options.merge(dp);
//        driver = new ChromeDriver(options);
////implicit wait:
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        //maximize the screen
//        driver.manage().window().maximize();
        //Navigate to the lambda home page
//        driver.get(lambdaUrl);
        driver.navigate().to(lambdaUrl);

    }

    @When("I click on MyAccount Menu")
    public void i_click_on_my_account_menu() {
        // Write code here that turns the phrase above into concrete actions
//        List<WebElement> myAccount = driver.findElements(By.xpath("//span[contains(text(),'My account')]"));
//        myAccount.get(1).click();
        LambdaHomePage lambdaHomePage = new LambdaHomePage(driver);
        lambdaHomePage.clickOnMyAccount();


    }

    @When("I click on Continue under the New Customer")
    public void i_click_on_continue_under_the_new_customer() {
        // Write code here that turns the phrase above into concrete actions
//        WebElement continueButton = driver.findElement(By.linkText("Continue"));
//        continueButton.click();
        LambdaMyAccountPage lambdaMyAccountPage = new LambdaMyAccountPage(driver);
        lambdaMyAccountPage.clickOnContinueButton();
    }

    @Then("the Register Account page should be displayed")
    public void the_register_account_page_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        WebElement registerAccountHeader = driver.findElement(By.cssSelector("h1[class='page-title h3']"));
        System.out.println(registerAccountHeader.getText());
        String actualResult = registerAccountHeader.getText();
        assertThat(actualResult, is(equalTo("Register Account")));



    }

    @When("I enter valid details for First Name as {string}, Last Name as {string}, E-mail as {string}, Telephone as {string}, Password as {string}")
    public void i_enter_valid_details_for_first_name_as_last_name_as_e_mail_as_telephone_as_password_as(String fName, String lName, String eMail, String tPhone, String pWord) {
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys(fName);
        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys(lName);
        WebElement emailAddress = driver.findElement(By.id("input-email"));
        emailAddress.sendKeys(pNumber()+ eMail);
        WebElement telephoneNum = driver.findElement(By.id("input-telephone"));
        telephoneNum.sendKeys(tPhone);
        WebElement passWord = driver.findElement(By.id("input-password"));
        passWord.sendKeys(pWord);
        WebElement confirmPword = driver.findElement(By.id("input-confirm"));
        confirmPword.sendKeys(pWord);
    }
    static int pNumber() {
        Random ran = new Random();
        return ran.nextInt(1000);


    }
    @When("I accept the privacy policy")
    public void i_accept_the_privacy_policy() {
        LambdaRegistrationPage lambdaRegistrationPage = new LambdaRegistrationPage(driver);
        lambdaRegistrationPage.clickOnPrivacyPolicy();
    }
    @When("I click on Continue button on the Register and Account page")
    public void i_click_on_continue_button_on_the_register_and_account_page() {
        LambdaRegistrationPage lambdaRegistrationPage = new LambdaRegistrationPage(driver);
        lambdaRegistrationPage.clickOnContinueButton();
    }
    @Then("Register Confirmation page is displayed")
    public void register_confirmation_page_is_displayed() {
        LambdaRegisterConfirmationPage lambdaRegisterConfirmationPage = new LambdaRegisterConfirmationPage(driver);
        assertThat(lambdaRegisterConfirmationPage.getPageheader(), is(equalTo("Your Account Has Been Created!")));


    }

    @Then("error message is displayed")
    public void errorMessageIsDisplayed() {
        WebElement ppMsg = driver.findElement(By.xpath("//div[contains(text(),' Warning: You must agree to the Privacy Policy!')]")) ;
        assertThat(ppMsg.isDisplayed(), is(true));

    }

    @And("the pp box is left unticked")
    public void thePpBoxIsLeftUnticked() {
    }



    @When("I enter username as  {string} and password {string}")
    public void i_enter_username_as_and_password(String uName, String pWord) {
        // Write code here that turns the phrase above into concrete actions
 WebElement username = driver.findElement(By.cssSelector("#input-email"));
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        username.sendKeys(uName);
        password.sendKeys(pWord);

    }
    @When("I click on Login button")
    public void i_click_on_login_button() {
        // Write code here that turns the phrase above into concrete actions
        WebElement loginButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
        loginButton.click();

    }
    @When("I click on {string} menu")
    public void i_click_on_menu(String string) {
        List <WebElement> shopByCategories = driver.findElements(By.xpath("//a[@data-toggle='mz-pure-drawer']"));
        shopByCategories.get(7).click();

    }
    @When("I click on {string} from the left hand menu")
    public void i_click_on_from_the_left_hand_menu(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement softWare = driver.findElement(By.xpath("//span[contains(text(),'Software')]"));
        softWare.click();
    }
    @When("I choose {string}")
    public void i_choose(String string) {
        // Write code here that turns the phrase above into concrete actions
        List <WebElement> palmTreoPro = driver.findElements(By.xpath("//a[@class='text-ellipsis-2']"));
        palmTreoPro.get(1).click();
    }
    @When("I click on Buy Now")
    public void i_click_on_buy_now() {
        // Write code here that turns the phrase above into concrete actions
        WebElement buyNow = driver.findElement(By.xpath("//button[@title='Buy now']"));
        buyNow.click();
    }
    @When("I accept terms and condition")
    public void i_accept_terms_and_condition() {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> acceptTC = driver.findElements(By.cssSelector("div.custom-control.custom-checkbox"));
        acceptTC.get(3).click();
    }
    @When("I click on continue")
    public void i_click_on_continue() {
        // Write code here that turns the phrase above into concrete actions
        WebElement continueButton = driver.findElement(By.id("button-save"));
        continueButton.click();
    }
    @When("I click on Confirm order button")
    public void i_click_on_confirm_order_button() {
        // Write code here that turns the phrase above into concrete actions
        WebElement confirmOrder = driver.findElement(By.id("button-confirm"));
        confirmOrder.click();
    }
    @Then("{string} is displayed")
    public void is_displayed(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement orderPlaced = driver.findElement(By.xpath("//h1[contains(text(),' Your order has been placed!')]"));
        assertThat(orderPlaced.isDisplayed(),is(true));
    }

    @When("I hover on myAccount and click Register")
    public void iHoverOnMyAccountAndClickRegister() {
        List<WebElement> myAccount = driver.findElements(By.xpath("//span[contains(text(),'My account')]"));
//perform mouse move action onto the element
        new Actions(driver).moveToElement(myAccount.get(1)).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //clicking on the register link after using explicit wait
        WebElement registerLink = driver.findElement(By.xpath("//span[contains(text(),'Register')]"));
        wait.until(ExpectedConditions.visibilityOf(registerLink));
        registerLink.click();

    }

    @And("I enter valid details for {string}, {string}, {string}, {string} and {string}")
    public void iEnterValidDetailsForAnd(String fName, String lName, String eMail, String tPhone, String pWord) {
//        WebElement firstName = driver.findElement(By.id("input-firstname"));
//        firstName.sendKeys(fName);
//        WebElement lastName = driver.findElement(By.id("input-lastname"));
//        lastName.sendKeys(lName);
//        WebElement emailAddress = driver.findElement(By.id("input-email"));
//        emailAddress.sendKeys(pNumber()+ eMail);
//        WebElement telephoneNum = driver.findElement(By.id("input-telephone"));
//        telephoneNum.sendKeys(tPhone);
//        WebElement passWord = driver.findElement(By.id("input-password"));
//        passWord.sendKeys(pWord);
//        WebElement confirmPword = driver.findElement(By.id("input-confirm"));
//        confirmPword.sendKeys(pWord);

        LambdaRegistrationPage lambdaRegistrationPage = new LambdaRegistrationPage(driver);
        lambdaRegistrationPage.enterFirstname(fName);
        lambdaRegistrationPage.enterLastname(lName);
        lambdaRegistrationPage.enterEmail(eMail);
        lambdaRegistrationPage.enterTelephoneNumber(tPhone);
        lambdaRegistrationPage.enterPassword(pWord);
        lambdaRegistrationPage.enterConfirmPassword(pWord);
    }
    @After
    public void tearDown() throws IOException {
        takeScreenshot();
        driver.close();
        driver.quit();
    }

    private void takeScreenshot() throws IOException {
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile, new File ("target/screenshot" + System.currentTimeMillis()+ ".png"));

    }

//    @And("I enter valid details as")
//    public void iEnterValidDetailsAs() {
//
//    }

    @And("I enter valid details as")
    public void iEnterValidDetailsAs(List<String> table) {
        LambdaRegistrationPage lambdaRegistrationPage = new LambdaRegistrationPage(driver);
        lambdaRegistrationPage.enterFirstname(table.get(0));
        lambdaRegistrationPage.enterLastname(table.get(1));
        lambdaRegistrationPage.enterEmail(table.get(2));
        lambdaRegistrationPage.enterTelephoneNumber(table.get(3));
        lambdaRegistrationPage.enterPassword(table.get(4));
        lambdaRegistrationPage.enterConfirmPassword(table.get(4));

    }

    @And("I enter valid details for registration as")
    public void iEnterValidDetailsForRegistrationAs(List<List<String>> table) {
        LambdaRegistrationPage lambdaRegistrationPage = new LambdaRegistrationPage(driver);
        lambdaRegistrationPage.enterFirstname(table.get(1).get(1));
        lambdaRegistrationPage.enterLastname(table.get(2).get(1));
        lambdaRegistrationPage.enterEmail(table.get(3).get(1));
        lambdaRegistrationPage.enterTelephoneNumber(table.get(4).get(1));
        lambdaRegistrationPage.enterPassword(table.get(5).get(1));
        lambdaRegistrationPage.enterConfirmPassword(table.get(5).get(1));
    }

    @When("I hover on myAccount and click Register using POM")
    public void iHoverOnMyAccountAndClickRegisterUsingPOM() {
LambdaHomePage lambdaHomePage = new LambdaHomePage(driver);
lambdaHomePage.hooverOnMyAccountAndClickRegisterLink();
    }


}
