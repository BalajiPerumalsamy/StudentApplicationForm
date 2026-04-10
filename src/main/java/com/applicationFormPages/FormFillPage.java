package com.applicationFormPages;

import com.basePage.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormFillPage extends BaseClass
{
    public FormFillPage()
    {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@id='firstName']")
    WebElement firstName;

    @FindBy(xpath="//input[@id='lastName']")
    WebElement lastName;

    @FindBy(xpath="//input[@id='userEmail']")
    WebElement email;

    @FindBy(xpath="//input[@value='Male']")
    WebElement gender;

    @FindBy(xpath="//input[@id='userNumber']")
    WebElement mobileNumber;

    @FindBy(xpath="//input[@id='dateOfBirthInput']")
    WebElement dateOfBirth;

    @FindBy(xpath="//input[@id='subjectsInput']")
    WebElement subject;

    @FindBy(xpath="//input[@value='1']")
    WebElement hobbies;

    @FindBy(xpath="//input[@type='file']")
    WebElement picture;

    @FindBy(xpath="//textarea[@id='currentAddress']")
    WebElement address;

    @FindBy(xpath="//div[text()='Select State']")
    WebElement state;

    @FindBy(xpath="//div[text()='Select City']")
    WebElement city;

    @FindBy(xpath="//button [text()='Submit']")
    WebElement submitButton;

    public @FindBy(xpath="//div[text()='Thanks for submitting the form']")
    WebElement verifyMessage;

    public void formFill(String fName, String lName, String userEmail, String number, String dob, String sub,
                         String userPicture, String userAddress, String userState, String userCity)
    {
        writeText(fName,firstName);
        writeText(lName,lastName);
        writeText(userEmail,email);
        clickButton(gender);
        writeText(number,mobileNumber);
        dateOfBirth.sendKeys(dob);
        dateOfBirth.sendKeys(Keys.ENTER);
        subject.sendKeys(sub);
        subject.sendKeys(Keys.ENTER);
        clickButton(hobbies);
        //writeText(userPicture,picture);
        writeText(userAddress,address);
        state.sendKeys(userState);
        state.sendKeys(Keys.ENTER);
        city.sendKeys(userCity);
        city.sendKeys(Keys.ENTER);
        clickButton(submitButton);
    }
}
