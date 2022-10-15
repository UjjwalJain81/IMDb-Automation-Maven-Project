import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ImdbLogIn;
import pages.SignInOptions;

public class TestSearchMovie {
    WebDriver driver;

    HomePage homePage;
    SignInOptions signInOptions;
    ImdbLogIn imdbLogIn;


    //This is browser set up method where browser name is Passed through parameter.
    @Parameters("browser")
    @BeforeTest
    public void browserSetUp(String browser){
        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/ujjwal.jain/IdeaProjects/ImdbAutomationMavenPro/driver/chromedriver");
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }
        else {
            System.out.println("Invalid Browser name. Enter either Chrome or Safari");
        }
        driver.get("https://www.imdb.com/");
    }

    // Verify the home Page By checking the Title --> click to Sign In
    @Test(priority = 1)
    public void navigateToHomePageClickOnSignIn() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.verifyHomePageTitle();
        homePage.signIn();
    }

    // --> Verify the Sign-In page through Title of Page
    // --> click on show More options to view all the Sign-in options available
    // --> click on Sign-In through desired Options by Parameter
    @Parameters("SignInOption")
    @Test(priority = 2)
    public void navigateToSignInOptionsSelectIMDb(String signInOption) throws InterruptedException {
        signInOptions = new SignInOptions(driver);
        signInOptions.verifySignInPageTitle();
        signInOptions.showMoreOptions();
        signInOptions.signInOptions(signInOption);
    }


    // --> Verify the IMDb Log in Page
    // --> enter user name
    // --> Enter password
    // --> click Sign In
    @Parameters({"username", "password"})
    @Test(priority = 3)
    public void navigateToIMDbLogInPage(String username, String password) throws InterruptedException {
        imdbLogIn = new ImdbLogIn(driver);
        imdbLogIn.verifyImdbSignInPageTitle();
        imdbLogIn.enterUsername(username);
        imdbLogIn.enterPassword(password);
        imdbLogIn.clickSignInButton();

    }

    // --> Verify that we are landing on a Home Page
    // --> Search the movie by selecting Title from category option which is present at index 2
    // --> enter the movie name or title
    // --> click on search button
    @Parameters({"movieName", "selectCategory"})
    @Test(priority = 4)
    public void searchForMovie(String movieName, String category) throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.verifyHomePageTitle();
        homePage.selectCategory(category);
        homePage.search(movieName);
        homePage.clickSearchButton();
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
