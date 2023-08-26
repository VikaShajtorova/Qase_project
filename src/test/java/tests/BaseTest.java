package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

@Log4j2
public class BaseTest {
    WebDriver driver;
    SignupPage signupPage;
    SuccessfulRegistrationPage successfulRegistrationPage;
    LoginPage loginPage;
    ProjectsPage projectsPage;
    ProjectModalPage projectModalPage;
    RepositoryPage repositoryPage;
    SuiteModalPage suiteModalPage;
    CasePage casePage;
    AttachmentsCasePage attachmentsCasePage;

    @Step("Setting up and opening the browser")
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        signupPage = new SignupPage(driver);
        successfulRegistrationPage = new SuccessfulRegistrationPage(driver);
        loginPage = new LoginPage(driver);
        projectsPage = new ProjectsPage(driver);
        projectModalPage = new ProjectModalPage(driver);
        repositoryPage = new RepositoryPage(driver);
        suiteModalPage = new SuiteModalPage(driver);
        casePage = new CasePage(driver);
        attachmentsCasePage = new AttachmentsCasePage(driver);
    }

    @Step("Closing the browser")
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
