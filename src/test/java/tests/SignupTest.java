package tests;

import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SignupTest extends BaseTest {
    @Description("The user registers with valid data")
    @Test
    public void userRegistersWithValidData() {
        signupPage.open()
                .createEmail()
                .inputPasswordPasswordConfirmationInRegistrationForm("Dbrnjhbz_110", "Dbrnjhbz_110")
                .clickSignUpButton();
        successfulRegistrationPage.isPageOpen();

        assertEquals(successfulRegistrationPage.getMessageAboutSuccessfulRegistration(),
                "We have successfully created your account and sent a confirmation email to:");
    }

    @Description("Input 48 characters in the password field")
    @Test
    public void userRegistersWithValidDataPasswordContains48Characters() {
        signupPage.open()
                .createEmail()
                .inputPasswordPasswordConfirmationInRegistrationForm("Dbrnjhbz_111111111111111111111111111111111111222",
                        "Dbrnjhbz_111111111111111111111111111111111111222")
                .clickSignUpButton();
        successfulRegistrationPage.isPageOpen();

        assertEquals(successfulRegistrationPage.getMessageAboutSuccessfulRegistration(),
                "We have successfully created your account and sent a confirmation email to:");
    }

    @Description("Input a space before the password")
    @Test
    public void userUsesSpaceInPasswordCreation() {
        signupPage.open()
                .createEmail()
                .inputPasswordPasswordConfirmationInRegistrationForm(" Dbrnjhbz_110", " Dbrnjhbz_110")
                .clickSignUpButton();
        successfulRegistrationPage.isPageOpen();

        assertEquals(successfulRegistrationPage.getMessageAboutSuccessfulRegistration(),
                "We have successfully created your account and sent a confirmation email to:");
    }

    @Description("Input  49 characters in the password field and password confirmation")
    @Test
    public void userInput49CharactersInPasswordFieldAndPasswordConfirmation() {
        signupPage.open()
                .createEmail()
                .inputPasswordPasswordConfirmationInRegistrationForm("Dbrnjhbz_1111111111111111111111111111111111112223",
                        "Dbrnjhbz_1111111111111111111111111111111111112223")
                .clickSignUpButton();

        assertEquals(signupPage.getErrorMessage(), "Keyword validation failed: Length of " +
                        "'Dbrnjhbz_1111111111111111111111111111111111112223' must be shorter or equal to 48",
                "The message text is incorrect or missing");
    }

    @Description("The user enters 11 characters in the password field and password confirmation")
    @Test
    public void userInput11CharactersInPasswordFieldAndPasswordConfirmation() {
        signupPage.open()
                .createEmail()
                .inputPasswordPasswordConfirmationInRegistrationForm("Dbrnjhbz_11", "Dbrnjhbz_11")
                .clickSignUpButton();

        assertEquals(signupPage.getMessage("Password"), "Password must has at least 12 characters",
                "The message text is incorrect or missing");
        assertEquals(signupPage.getMessage("Password confirmation"), "Password must has at least 12 characters",
                "The message text is incorrect or missing");
    }

    @Description("Leave the password field empty")
    @Test
    public void userLeftPasswordFieldEmpty() {
        signupPage.open()
                .createEmail()
                .inputPasswordPasswordConfirmationInRegistrationForm("", "Dbrnjhbz_110")
                .clickSignUpButton();

        assertEquals(signupPage.getMessage("Password"), "Password must has at least 12 characters",
                "The message text is incorrect or missing");
        assertEquals(signupPage.getMessage("Password confirmation"), "Passwords must match",
                "The message text is incorrect or missing");
    }

    @Description("Leave the password confirmation field empty")
    @Test
    public void userLeftPasswordConfirmationFieldEmpty() {
        signupPage.open()
                .createEmail()
                .inputPasswordPasswordConfirmationInRegistrationForm("Dbrnjhbz_110", "")
                .clickSignUpButton();

        assertEquals(signupPage.getMessage("Password confirmation"), "Passwords must match",
                "The message text is incorrect or missing");
    }

    @Description("Input numbers in the password field and password confirmation")
    @Test
    public void userInputNumbersInPasswordFieldAndPasswordConfirmation() {
        signupPage.open()
                .createEmail()
                .inputPasswordPasswordConfirmationInRegistrationForm("1234567891234", "1234567891234")
                .clickSignUpButton();

        assertEquals(signupPage.getMessage("Password"), "Password must contain at least one lowercase letter",
                "The message text is incorrect or missing");
        assertEquals(signupPage.getMessage("Password confirmation"), "Password must contain at least one lowercase letter",
                "The message text is incorrect or missing");
    }

    @Description("Input the upper and lower case Cyrillic letters in the password field and confirm the password")
    @Test
    public void userInputUpperAndLowerCaseCyrillicLettersInPasswordFieldAndPasswordConfirmation() {
        signupPage.open()
                .createEmail()
                .inputPasswordPasswordConfirmationInRegistrationForm("ОднооБразный", "ОднооБразный")
                .clickSignUpButton();

        assertEquals(signupPage.getMessage("Password"), "Password must contain at least one number",
                "The message text is incorrect or missing");
        assertEquals(signupPage.getMessage("Password confirmation"), "Password must contain at least one number",
                "The message text is incorrect or missing");
    }

    @Description("Input uppercase and lowercase Latin letters in the password field and confirm the password")
    @Test
    public void userInputUppercaseAndLowercaseLatinLettersInPasswordFieldAndPasswordConfirmation() {
        signupPage.open()
                .createEmail()
                .inputPasswordPasswordConfirmationInRegistrationForm("АntitheTical", "АntitheTical")
                .clickSignUpButton();

        assertEquals(signupPage.getMessage("Password"), "Password must contain at least one number",
                "The message text is incorrect or missing");
        assertEquals(signupPage.getMessage("Password confirmation"), "Password must contain at least one number",
                "The message text is incorrect or missing");
    }

    @Description("Input the characters in the password field and confirm the password")
    @Test
    public void userInputCharactersInPasswordFieldAndPasswordConfirmation() {
        signupPage.open()
                .createEmail()
                .inputPasswordPasswordConfirmationInRegistrationForm("!@#$%^&*()_+", "!@#$%^&*()_+")
                .clickSignUpButton();

        assertEquals(signupPage.getMessage("Password"), "Password must contain at least one lowercase letter",
                "The message text is incorrect or missing");
        assertEquals(signupPage.getMessage("Password confirmation"), "Password must contain at least one lowercase letter",
                "The message text is incorrect or missing");
    }

    @Description("Input an incorrect password confirmation")
    @Test
    public void userInputIncorrectPasswordConfirmation() {
        signupPage.open()
                .createEmail()
                .inputPasswordPasswordConfirmationInRegistrationForm("Dbrnjhbz_110", "Dbrnjhbz_111")
                .clickSignUpButton();

        assertEquals(signupPage.getMessage("Password confirmation"), "Passwords must match",
                "The message text is incorrect or missing");
    }

    @Description("Leave the email field empty")
    @Test
    public void userLeftEmailFieldEmpty() {
        signupPage.open()
                .inputEmailPasswordPasswordConfirmationInRegistrationForm("",
                        "Dbrnjhbz_110", "Dbrnjhbz_110")
                .clickSignUpButton();

        assertEquals(signupPage.getMessage("E-Mail"), "This field is required",
                "The message text is incorrect or missing");
    }

    @Description("The user registers with the data already available")
    @Test
    public void userRegistersWithDataAlreadyAvailable() {
        signupPage.open()
                .inputEmailPasswordPasswordConfirmationInRegistrationForm(email,
                        passwordRegistration, passwordRegistration)
                .clickSignUpButton();

        assertEquals(signupPage.getErrorMessage(), "The email has already been taken.",
                "The message text is incorrect or missing");
    }

    @DataProvider(name = "userRegistersWithIncorrectEmail")
    public Object[][] userRegistersWithIncorrectEmail() {
        return new Object[][]{
                {"СССС@mail.ru", "Dbrnjhbz_110", "Dbrnjhbz_110", "Value 'СССС@mail.ru' does not match format email of type string"},
                {"@mail.ru", "Dbrnjhbz_110", "Dbrnjhbz_110", "Value '@mail.ru' does not match format email of type string"},
                {" hewihat415@wlmycn.com", "Dbrnjhbz_110", "Dbrnjhbz_110",
                        "Value ' hewihat415@wlmycn.com' does not match format email of type string"},
                {"hewihat415@wlmycn.com ", "Dbrnjhbz_110", "Dbrnjhbz_110",
                        "Value 'hewihat415@wlmycn.com ' does not match format email of type string"},
                {"$$$%^!*_$@mail.ru", "Dbrnjhbz_110", "Dbrnjhbz_110",
                        "Value '$$$%^!*_$@mail.ru' does not match format email of type string"},//TODO регистрирует с этими данными
        };
    }

    @Description("The user registers with an incorrect email")
    @Test(dataProvider = "userRegistersWithIncorrectEmail")
    public void userRegistersWithIncorrectEmail(String email, String password, String passwordConfirmation, String errorMessage) {
        signupPage.open()
                .inputEmailPasswordPasswordConfirmationInRegistrationForm(email, password, passwordConfirmation)
                .clickSignUpButton();

        assertEquals(signupPage.getErrorMessage(), errorMessage,
                "The message text is incorrect or missing");
    }

    @Test
    public void userRegisters5() {
        signupPage.open()
                .clickSignUpButton();

        assertEquals(signupPage.getMessage("E-Mail"), "This field is required",
                "The message text is incorrect or missing");
        assertEquals(signupPage.getMessage("Password"), "Password must has at least 12 characters",
                "The message text is incorrect or missing");
        assertEquals(signupPage.getMessage("Password confirmation"), "Password must has at least 12 characters",
                "The message text is incorrect or missing");
    }

}
