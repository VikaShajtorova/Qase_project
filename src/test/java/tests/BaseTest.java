package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.EmailFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

@Log4j2
public class BaseTest {
    WebDriver driver;
    String baseUrl,email,password,passwordRegistration;
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
        baseUrl = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url"));
        email = System.getenv().getOrDefault("QASE_EMAIL", PropertyReader.getProperty("qase.email"));
        password = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password"));
        passwordRegistration = System.getenv().getOrDefault("QASE_PASSWORD_REGISTRATION",
                PropertyReader.getProperty("qase.passwordRegistration"));
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
