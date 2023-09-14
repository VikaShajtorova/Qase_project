package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import pages.createCase.*;
import pages.sideMenuProject.*;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl, email, password;
    protected LoginPage loginPage;
    protected ProjectsPage projectsPage;
    protected ProjectModalPage projectModalPage;
    protected RepositoryPage repositoryPage;
    protected SuiteModalPage suiteModalPage;
    protected CasePage casePage;
    protected AttachmentsCasePage attachmentsCasePage;
    protected SharedStepPage sharedStepPage;
    protected CreateSharedStepPage createSharedStepPage;
    protected TestPlansPage testPlansPage;
    protected CreateTestPlanPage createTestPlanPage;
    protected SelectTestCasesPage selectTestCasesPage;
    protected ProjectSettingsPage projectSettingsPage;
    protected EditSuiteModalPage editSuitePage;
    protected BasicCasePage basicCasePage;
    protected ConditionsCasePage conditionsCasePage;
    protected ParametersCasePage parametersCasePage;
    protected CaseModalPage caseModalPage;
    protected CloneCaseModalPage cloneCaseModalPage;
    protected CloneSuiteModalPage cloneSuiteModalPage;
    protected TestRunsPage testRunsPage;
    protected TestRunsModalPage testRunsModalPage;
    protected ListOfSuitesInRunPage listOfSuitesInRunPage;
    protected SelectCasesModalPage selectCasesModalPage;


    @Step("Setting up and opening the browser")
    @BeforeMethod
    public void setUp() {
        baseUrl = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url"));
        email = System.getenv().getOrDefault("QASE_EMAIL", PropertyReader.getProperty("qase.email"));
        password = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password"));
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        loginPage = new LoginPage(driver);
        projectsPage = new ProjectsPage(driver);
        projectModalPage = new ProjectModalPage(driver);
        repositoryPage = new RepositoryPage(driver);
        suiteModalPage = new SuiteModalPage(driver);
        casePage = new CasePage(driver);
        attachmentsCasePage = new AttachmentsCasePage(driver);
        sharedStepPage = new SharedStepPage(driver);
        createSharedStepPage = new CreateSharedStepPage(driver);
        testPlansPage = new TestPlansPage(driver);
        createTestPlanPage = new CreateTestPlanPage(driver);
        selectTestCasesPage = new SelectTestCasesPage(driver);
        projectSettingsPage = new ProjectSettingsPage(driver);
        editSuitePage = new EditSuiteModalPage(driver);
        basicCasePage = new BasicCasePage(driver);
        conditionsCasePage = new ConditionsCasePage(driver);
        parametersCasePage = new ParametersCasePage(driver);
        caseModalPage = new CaseModalPage(driver);
        cloneCaseModalPage = new CloneCaseModalPage(driver);
        cloneSuiteModalPage = new CloneSuiteModalPage(driver);
        testRunsPage = new TestRunsPage(driver);
        testRunsModalPage = new TestRunsModalPage(driver);
        listOfSuitesInRunPage = new ListOfSuitesInRunPage(driver);
        selectCasesModalPage = new SelectCasesModalPage(driver);
    }

    @Step("Closing the browser")
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
