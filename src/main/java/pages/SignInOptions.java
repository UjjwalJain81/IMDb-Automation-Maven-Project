package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class SignInOptions {
    static WebDriver driver;
    Actions actions;

    public SignInOptions(WebDriver driver){
        this.driver = driver;
    }

    By showMoreOptionsButton = By.xpath("//div[@class=\"auth-options-toggle\"]");
    By imdbButton = By.xpath("//*[@id='signin-options']/div/div[1]/a[1]");
    By amazonButton =By.xpath("//*[@id='signin-options']/div/div[1]/a[2]");
    By googleButton =By.xpath("//*[@id='signin-options']/div/div[1]/a[3]");
    By appleButton = By.xpath("//*[@id='signin-options']/div/div[1]/a[4]");
    By facebookButton = By.xpath("//span[@class='auth-sprite imdb-logo retina']");
    By createNewAccountButton = By.xpath("//span[@class='auth-sprite imdb-logo retina']");




    public static void verifySignInPageTitle(){
        String pageTitle = "Sign in with IMDb - IMDb";
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle, pageTitle);
    }

    public void showMoreOptions() throws InterruptedException {
        driver.findElement(showMoreOptionsButton).click();
        Thread.sleep(3000);
    }

    public void signInOptions(String option) throws InterruptedException {
        switch (option){
            case "IMDB":
                driver.findElement(imdbButton).click();
                break;

            case "Amazon":
                driver.findElement(amazonButton).click();
                break;

            case "Google":
                driver.findElement(googleButton).click();
                break;

            case "Apple":
                driver.findElement(appleButton).click();
                break;

            case "Facebook":
                driver.findElement(facebookButton).click();
                break;
        }
        Thread.sleep(3000);
    }

    public void createNewAcco() throws InterruptedException {
        driver.findElement(createNewAccountButton).click();
        Thread.sleep(3000);
    }
}
