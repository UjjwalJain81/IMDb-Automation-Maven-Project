package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ImdbLogIn {
    WebDriver driver;

    public ImdbLogIn(WebDriver driver){
        this.driver = driver;
    }

    By userName = By.xpath("//*[@id=\"ap_email\"]");
    By password = By.xpath("//*[@id=\"ap_password\"]");
    By signInButton = By.xpath("//input[@id=\"signInSubmit\"]");

    public void verifyImdbSignInPageTitle(){
        String pageTitle = "IMDb Sign-In";
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle, pageTitle, "IMDB Sign in page title not matching");
    }

    public void enterUsername(String user){
        driver.findElement(userName).sendKeys(user);
    }

    public void enterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }

    public void clickSignInButton() throws InterruptedException {
        driver.findElement(signInButton).click();
        Thread.sleep(4000);
    }
}
