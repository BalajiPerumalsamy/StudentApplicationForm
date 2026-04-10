package com.applicationFormPages;

import com.basePage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFormPage extends BaseClass
{
    public SelectFormPage()
    {
      super();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//h5[text()='Forms']")
    WebElement selectForm;

    @FindBy(xpath="//span[text ()='Practice Form']")
    WebElement clickPracticeForm;

    public @FindBy(xpath="//h1[text()='Practice Form']")
    WebElement verifyMessage;

    public void navigateToPracticeForm()
    {
        Actions action=new Actions(driver);
        action.scrollByAmount(0,500).perform();
        clickButton(selectForm);
        clickButton(clickPracticeForm);
    }
}
