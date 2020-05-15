package tests;

import models.Account;
import models.Contact;
import org.testng.annotations.Test;
public class FunctionalTests extends BaseTest{

    @Test
    public void login(){
        Account account = new Account("Elena", "111333555", "exampleDescription");

        loginPage
                .openPage()
                .provideCredsAndLogin("e.anischyk-tl4e@force.com", "astashonak12")
                .verifyLoginAccounts()
                .openPage()
                .clickNew()
                .createAccount(account);
    }

    @Test
    public void contacts(){
        Contact contact = new Contact("Elena", "Astashonak", "myEmail", "student");
        loginPage
                .openPage()
                .provideCredsAndLogin("e.anischyk-tl4e@force.com", "astashonak12")
                .verifyLoginContacts()
                .openPage()
                .clickNew()
                .createContact(contact)
                .verifyErrorMessage("Review the errors on this page.");
    }
}