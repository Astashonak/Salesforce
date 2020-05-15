package tests;

import models.Account;
import org.testng.annotations.Test;

public class FunctionalTests extends BaseTest{

    @Test
    public void login(){
        Account account = new Account("Elena", "111333555", "exampleDescription");

        loginPage
                .openPage()
                .provideCredsAndLogin("e.anischyk-tl4e@force.com", "astashonak12")
                .verifyLogin()
                .openPage()
                .clickNew()
                .createAccount(account);
    }
}