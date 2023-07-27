package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

    public DashBoardPage(){

        PageFactory.initElements(Driver.getDriver(),this);


    }

    @FindBy(xpath = "//div[@class='avatardiv avatardiv-shown']")
    public WebElement upperRightIcon;

    @FindBy(xpath = "//nav[@class='settings-menu menu']/ul/li[4]")

    public WebElement logoutButton;




}
