package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);


    }

    @FindBy(id="user")
        public WebElement usernameInput;

    @FindBy(id="password")
    public WebElement passwordInput;

    @FindBy(id = "submit-form")

    public WebElement loginButton;

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")

    public WebElement wrongusernameorpass;

    @FindBy(xpath = "//img[@src='/core/img/actions/toggle.svg']")

    public WebElement eyeIcon;

    @FindBy(id="lost-password")

    public WebElement forgotPasswordLink;

    @FindBy(id="reset-password-submit")

    public WebElement resetPasswordLink;

    }
