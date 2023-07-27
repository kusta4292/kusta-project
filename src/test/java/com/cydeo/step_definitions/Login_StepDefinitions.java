package com.cydeo.step_definitions;

import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();



    @Given("user is on the website login page")
    public void user_is_on_the_website_login_page()  {

        Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));

        //String url = ConfigurationReader.getProperty("web.url");
        //Driver.getDriver().get(url);

    }

    //=========================AC-1 by clicking login button (LOGIN 1)===================================================
    @When("user enters valid username {string} into input boxes")
    public void user_enters_valid_username_into_input_boxes(String string1) {

        String username1 = string1;

        loginPage.usernameInput.sendKeys(username1);
    }

    @When("user enters valid password {string} ito input boxes")
    public void user_enters_valid_password_ito_input_boxes(String string2) {


        String password1 = string2;

        loginPage.passwordInput.sendKeys(password1);


    }

    @When("user clicks to login button")
    public void user_clicks_to_login_button() {

        loginPage.loginButton.click();


    }

    @Then("user should see dashboard page")
    public void user_should_see_dashboard_page() {

        String expected = "dashboard";

        String actual = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actual.contains(expected));




    }


    //=========================AC-1 when hitting enter keys(LOGIN 2)===================================================

    @When("user hitting Enter key")
    public void user_hitting_enter_key() {

        Driver.getDriver().findElement(By.id("submit-form")).sendKeys(Keys.ENTER);


    }

    //===========================================AC-2================================================================

    @When("user log in {string} and {string} with {string}")
    public void user_log_in_and_with(String username1, String password1, String submitType) throws InterruptedException {


        loginPage.usernameInput.sendKeys(username1);
        loginPage.passwordInput.sendKeys(password1);


        if (submitType.equals("enterKey")) {

            Driver.getDriver().findElement(By.id("submit-form")).sendKeys(Keys.ENTER);

        } else {

            loginPage.loginButton.click();
        }


    }

    @When("user should see invalid credential message Wrong username or password text")
    public void user_should_see_invalid_credential_message_wrong_username_or_password_text() {

        Assert.assertTrue(loginPage.wrongusernameorpass.getText().contains("Wrong username or password."));


    }


    @Then("user should see usage of empty password or username Please fill out this field text")
    public void user_should_see_usage_of_empty_password_or_username_please_fill_out_this_field_text() {


        String message1 = Driver.getDriver().findElement(By.name("user")).getAttribute("validationMessage");

        String message2 = Driver.getDriver().findElement(By.name("password")).getAttribute("validationMessage");


        if (loginPage.usernameInput.equals("")) {

            Assert.assertEquals("Please fill out this field.", message1);


        } else {

            Assert.assertEquals("Please fill out this field.", message2);
        }


    }
    //===========================================AC-3================================================================
    @Then("user sees password in a form of dots")
    public void user_sees_password_in_a_form_of_dots() {

        String expectedValue = "password";
        String actualValue = loginPage.passwordInput.getAttribute("type");

        Assert.assertEquals("Type value is in a form of dot",expectedValue,actualValue);


    }

    //===========================================AC-4================================================================

    @When("user clicks to eye icon is need")
    public void user_clicks_to_eye_icon_is_need() {

       loginPage.passwordInput.sendKeys("2345gg");
       loginPage.eyeIcon.click();

        String expectedValue = "text";
        String actualValue = loginPage.passwordInput.getAttribute("type");

        Assert.assertEquals("Type value is explicitly can see when click eye icon",expectedValue,actualValue);

    }
    @When("user can see forgot password link")
    public void user_can_see_forgot_password_link() {

       Assert.assertTrue(loginPage.forgotPasswordLink.isDisplayed());

    }
    @Then("user click forgot password link")
    public void user_click_forgot_password_link() {
        loginPage.forgotPasswordLink.click();


    }
    @Then("user should see resert password button")
    public void user_should_see_resert_password_button() {



        Assert.assertTrue(loginPage.resetPasswordLink.isDisplayed());

    }

    @When("user see valid placeholder on username")
    public void user_see_valid_placeholder_on_username() {

        String expectedPlaceHolder ="Username or email";
        String actualPlaceHolder= loginPage.usernameInput.getAttribute("aria-label");

        Assert.assertEquals(expectedPlaceHolder, actualPlaceHolder);



    }
    @Then("user see valid placeholder on password")
    public void user_see_valid_placeholder_on_password() {


        String expectedPassword = "Password";
        String actualPassword = loginPage.passwordInput.getAttribute("placeholder");

        Assert.assertEquals(expectedPassword,actualPassword);


    }



}





    //===========================================AC-3================================================================
  /*  @Then("user sees password in a form of dots")
    public void user_sees_password_in_a_form_of_dots() {

      String password = ConfigurationReader.getProperty("valid.password");

      String expected = "****";
      String actual = password;

      Assert.assertTrue(actual.contains(expected));


    }*/





