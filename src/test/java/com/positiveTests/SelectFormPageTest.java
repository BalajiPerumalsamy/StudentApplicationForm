package com.positiveTests;

import com.applicationFormPages.SelectFormPage;
import com.basePage.BaseClass;
import com.listeners.MyListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class)

public class SelectFormPageTest
{
    public BaseClass baseClass;
    public SelectFormPage selectFormPage;

    @BeforeMethod
    public void setUp()
    {
      baseClass=new BaseClass();
      baseClass.navigateToApplication();
    }

    @Test
    public void verifyPracticeForm()
    {
        selectFormPage=new SelectFormPage();
        selectFormPage.navigateToPracticeForm();
        Assert.assertTrue(selectFormPage.verifyMessage.isDisplayed(),
                "Couldn't navigate to Practice Form Page");
    }

    @AfterMethod
    public void tearDown()
    {
        baseClass.quitApplications();
    }
}
