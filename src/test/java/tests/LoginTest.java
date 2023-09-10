package tests;

import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {
    @Description("Input valid data")
    @Test
    public void userIsLoggedInWithValidData() {
        boolean isProjectPage = loginPage.open()
                .inputEmailAndPassword(email, password)
                .clickSignInButton()
                .isPageOpen();

        assertTrue(isProjectPage);
    }

    @DataProvider(name = "incorrectLoginTest")
    public Object[][] incorrectLoginTest() {
        return new Object[][]{
                {" shajtorova@mail.ru", "Dbrf_110585", "Value ' shajtorova@mail.ru' does not match format email of type string"},
                {"shajtorova@mail.ru ", "Dbrf_110585", "Value 'shajtorova@mail.ru ' does not match format email of type string"},
                {"123456789", "Dbrf_110585", "Value '123456789' does not match format email of type string"},
                {"aBcdeFg", "Dbrf_110585", "Value 'aBcdeFg' does not match format email of type string"},
                {"абВгДе", "Dbrf_110585", "Value 'абВгДе' does not match format email of type string"},
                {"@#$%^&*()", "Dbrf_110585", "Value '@#$%^&*()' does not match format email of type string"},
                {"shajtorova@mail.ru", " Dbrf_110585", "These credentials do not match our records."},
                {"shajtorova@mail.ru", "Dbrf_110585 ", "These credentials do not match our records."},
                {"shajtorova@mail.ru", "абВгДе", "These credentials do not match our records."},
                {"shajtorova@mail.ru", "aBcdeFg", "These credentials do not match our records."},
                {"shajtorova@mail.ru", "123456789", "Security notice: The password entered has been found in a public data leak." +
                        " Please reset your password to ensure the safety of your account"},
                {"shajtorova@mail.ru", "@#$%^&*()", "Security notice: The password entered has been found in a public data leak." +
                        " Please reset your password to ensure the safety of your account"},
        };

    }

    @Description("Input invalid data")
    @Test(dataProvider = "incorrectLoginTest")
    public void loginTestWithWrongData(String email, String password, String errorMessage) {
        loginPage.open()
                .inputEmailAndPassword(email, password)
                .clickSignInButton();

        assertEquals(loginPage.getErrorMessage(), errorMessage,
                "The message text is incorrect or missing");
    }

    @Description("Leave the password field empty")
    @Test
    public void leavePasswordFieldEmpty() {
        loginPage.open()
                .inputEmailAndPassword(email, "")
                .clickSignInButton();

        assertEquals(loginPage.getMessage("Password"), "This field is required",
                "The message text is incorrect or missing");
    }

    @Description("Leave the email field empty")
    @Test
    public void leaveEmailFieldEmpty() {
        loginPage.open()
                .inputEmailAndPassword("", password)
                .clickSignInButton();

        assertEquals(loginPage.getMessage("E-Mail"), "This field is required",
                "The message text is incorrect or missing");
    }

}
