package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{
    @Test
    public void userIsLoggedInWithValidData(){
        boolean isProjectPage = loginPage.open()
                .inputEmailAndPassword("shajtorova@mail.ru","Dbrf_110585")
                .clickSignInButton()
                .isPageOpen();


        assertTrue(isProjectPage);
    }

}
