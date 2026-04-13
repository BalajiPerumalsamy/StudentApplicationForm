package com.applicationFormPages;

import com.basePage.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(xpath="//select[@class='react-datepicker__year-select']")
    WebElement year;

    @FindBy(xpath="//select[@class='react-datepicker__month-select']")
    WebElement month;

    @FindBy(xpath="//input[@id='subjectsInput']")
    WebElement subject;

    @FindBy(xpath="//input[@value='1']")
    WebElement hobbies;

    @FindBy(xpath="//input[@type='file']")
    WebElement picture;

    @FindBy(xpath="//textarea[@id='currentAddress']")
    WebElement address;

    @FindBy(xpath="//div[@id='state']")
    WebElement state;

    @FindBy(xpath="//div[@id='stateCity-wrapper']//div[text()='NCR']")
    WebElement selectState;

    @FindBy(xpath="//div[@id='city']")
    WebElement city;

    @FindBy(xpath="//div[@id='stateCity-wrapper']//div[text()='Noida']")
    WebElement selectCity;

    @FindBy(xpath="//button [text()='Submit']")
    WebElement submitButton;

    public @FindBy(xpath="//div[text()='Thanks for submitting the form']")
    WebElement verifyMessage;

    public String firstNameBorderColor;
    public String lastNameBorderColor;
    public String genderBorderColor;
    public String emailBorderColor;
    public String mobileNumberBorderColor;

    public void formFill(String fName, String lName, String userEmail, String number, String yearValue, String monthValue, String dayValue, String sub,
                         String userPicture, String userAddress)
    {
        writeText(fName,firstName);
        writeText(lName,lastName);
        writeText(userEmail,email);
        clickButton(gender);
        writeText(number,mobileNumber);


        clickButton(dateOfBirth);
        Select yearDropDown=new Select(year);
        yearDropDown.selectByVisibleText(yearValue);
        Select monthDropDown=new Select(month);
        monthDropDown.selectByVisibleText(monthValue);
        driver.findElement(By.xpath(
                        "//div[contains(@class,'react-datepicker__day') and not(contains(@class,'outside-month')) and text()='" + dayValue + "']"))
                .click();

        subject.sendKeys(sub);
        subject.sendKeys(Keys.ENTER);
        clickButton(hobbies);
        writeText(userPicture,picture);
        writeText(userAddress,address);
        Actions action=new Actions(driver);
        action.moveToElement(state).perform();
        clickButton(state);
        clickButton(selectState);
        action.moveToElement(city).perform();
        clickButton(city);
        clickButton(selectCity);
        clickButton(submitButton);
        emailBorderColor=email.getCssValue("border-color");
        mobileNumberBorderColor=mobileNumber.getCssValue("border-color");
    }

    public void shouldShowErrorsWhenSubmittingEmptyForm()
    {
        Actions act=new Actions(driver);
        act.scrollByAmount(0,500).perform();
        clickButton(submitButton);
        firstNameBorderColor=firstName.getCssValue("border-color");
        lastNameBorderColor=lastName.getCssValue("border-color");
        genderBorderColor=gender.getCssValue("border-color");
        mobileNumberBorderColor=mobileNumber.getCssValue("border-color");
    }
}
