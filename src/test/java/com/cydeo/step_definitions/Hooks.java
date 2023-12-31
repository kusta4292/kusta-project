package com.cydeo.step_definitions;

/*
In the class we will be able to pass pre&post conditions to
each scenario and each step

 */


import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
   // @Before(order = 1 )
    public void setupScenario(){

        System.out.println("=====Setting up browser using cucumber @Before");

    }

   // @Before (value = "@login", order = 2)
    public void setupScenarioForLogins(){

        System.out.println("=====this will only apply to scenarios with @login tag");

    }

   // @Before (value = "@db", order = 0)
    public void setupForDatabaseScenarios(){

        System.out.println("=====this will only apply to scenarios with @db tag");

    }

    @After

    public void teardownScenario(Scenario scenario){
       // scenario.isFailed() --> if scenario fails this method will return True boolean value

        if(scenario.isFailed()){

            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", scenario.getName());

        }


        BrowserUtils.sleep(5 );

        Driver.closeDriver();


       // System.out.println("====Closing browser using cucumber @After");

        //System.out.println("====Scenario ended/Take Screenshot if failed!");


    }

   // @BeforeStep
    public void setupStep(){

        System.out.println("-------->Applying setup using @BeforeStep");

    }

   // @AfterStep
    public void afterstep(){

        System.out.println("------->Applying teardown using @AfterStep");
    }
}
