package com.negativeTests;

import com.applicationFormPages.FormFillPage;
import com.applicationFormPages.SelectFormPage;
import com.basePage.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmptyFormSubmissionTest
{
    public BaseClass baseClass;
    public SelectFormPage selectFormPage;
    public FormFillPage formFillPage;

    @BeforeMethod
    public void setUp()
    {
        baseClass=new BaseClass();
        baseClass.navigateToApplication();

        selectFormPage=new SelectFormPage();
        selectFormPage.navigateToPracticeForm();
        Assert.assertTrue(selectFormPage.verifyMessage.isDisplayed(),
                "Couldn't navigate to Practice Form");
    }

    @Test
    public void validateErrorsForEmptyFormSubmission()
    {
        formFillPage=new FormFillPage();
        formFillPage.shouldShowErrorsWhenSubmittingEmptyForm();
        Assert.assertTrue(formFillPage.firstNameBorderColor.contains("rgb(220, 53, 69)"),
                "Application saved");
        Assert.assertTrue(formFillPage.lastNameBorderColor.contains("rgb(220, 53, 69)"),
                "Application saved");
        Assert.assertTrue(formFillPage.genderBorderColor.contains("rgb(220, 53, 69)"),
                "Application saved");
        Assert.assertTrue(formFillPage.mobileNumberBorderColor.contains("rgb(220, 53, 69)"),
                "Application saved");
    }

    @AfterMethod
    public void tearDown()
    {
        baseClass.quitApplications();
    }
}
