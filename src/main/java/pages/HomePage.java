package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage{
    static WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    By searchButton = By.xpath("//button[@class='nav-search__search-submit searchform__submit']");
    By signInButton =  By.className("nav__userMenu");
    By menuButton = By.xpath("//label[@id='imdbHeader-navDrawerOpen--desktop']");
    By categoryButton = By.xpath("//label[@aria-label='All']");
    By movieName = By.xpath("//input[@name='q']");

    public static void verifyHomePageTitle(){
        String pageTitle = "IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows";
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle, pageTitle);
    }

    public void signIn() throws InterruptedException {
        driver.findElement(signInButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void clickSearchButton() throws InterruptedException {
        driver.findElement(searchButton).click();
        Thread.sleep(3000);
    }

    public void selectCategory(String categoryName) {
        driver.findElement(categoryButton).click();
        switch (categoryName) {
            case "Titles" ->
                    driver.findElement(By.xpath("(//span[@id=\"navbar-search-category-select-contents\"]//ul//li)[2]")).click();
            case "TV Episodes" ->
                    driver.findElement(By.xpath("(//span[@id=\"navbar-search-category-select-contents\"]//ul//li)[3]")).click();
            case "Celebs" ->
                    driver.findElement(By.xpath("(//span[@id=\"navbar-search-category-select-contents\"]//ul//li)[4]")).click();
            case "Companies" ->
                    driver.findElement(By.xpath("(//span[@id=\"navbar-search-category-select-contents\"]//ul//li)[5]")).click();
            case "Keywords" ->
                    driver.findElement(By.xpath("(//span[@id=\"navbar-search-category-select-contents\"]//ul//li)[6]")).click();
        }
        //driver.findElement(By.xpath("(//span[@id=\"navbar-search-category-select-contents\"]//ul//li)[i]")).click();
    }

    public void search(String movie){
        driver.findElement(movieName).sendKeys(movie);
    }

    public void menuButton()  {
        driver.findElement(menuButton).click();
    }

}
