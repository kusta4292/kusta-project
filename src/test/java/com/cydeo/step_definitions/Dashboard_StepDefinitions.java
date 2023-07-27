package com.cydeo.step_definitions;

import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Dashboard_StepDefinitions {

   LoginPage loginPage = new LoginPage();
   @Given("user has already the website login page")
   public void user_has_already_the_website_login_page() {

      Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));
   }
   @Then("user enters valid username into input boxes")
   public void user_enters_valid_username_into_input_boxes() {

      loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("username"));

   }
   @Then("user enters valid passwordinto input boxes")
   public void user_enters_valid_passwordinto_input_boxes() throws InterruptedException {


      loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));

      Thread.sleep(2000);

      loginPage.loginButton.click();

      Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));

      }


   @Then("should not see the dashboard again after closing")
   public void should_not_see_the_dashboard_again_after_closing() {

      Assert.assertTrue(Driver.getDriver().getTitle().contains("login"));



   }



}
