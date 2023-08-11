package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SignupTest extends BaseTest{
    @Test
    public void userRegisters(){
        signupPage.open();
        signupPage.inputEmailPasswordPasswordConfirmationInRegistrationForm("yaveg19397@inkiny.com","Dbrnjhbz_1105","Dbrnjhbz_1105");
        signupPage.clickSignUpButton();
        successfulRegistrationPage.isPageOpen();

        assertEquals(successfulRegistrationPage.getMessageAboutSuccessfulRegistration(),"We have successfully created your account and sent a confirmation email to:");

    }

}
