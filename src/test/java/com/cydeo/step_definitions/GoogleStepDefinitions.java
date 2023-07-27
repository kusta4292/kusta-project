package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class GoogleStepDefinitions {

    @When("user is on Google search page")
    public void user_is_on_google_search_page() throws InterruptedException {

        Driver.getDriver().get("https://www.google.com");
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("//button[@id='L2AGLb']")).click();

    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {

        String expectedTitle = "Google";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        Driver.closeDriver();

    }
}
