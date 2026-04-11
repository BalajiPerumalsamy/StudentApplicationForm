import com.applicationFormPages.FormFillPage;
import com.applicationFormPages.SelectFormPage;
import com.basePage.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormFillPageTest
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
    public void verifyFormFill()
    {
        formFillPage=new FormFillPage();
        formFillPage.formFill(baseClass.properties.getProperty("FirstName"),
                baseClass.properties.getProperty("LastName"), baseClass.properties.getProperty("Email"),
                baseClass.properties.getProperty("MobileNumber"),
                baseClass.properties.getProperty("Year"), baseClass.properties.getProperty("Month"),
                baseClass.properties.getProperty("Day"),baseClass.properties.getProperty("Subject"),
                baseClass.properties.getProperty("Picture"), baseClass.properties.getProperty("Address"));
        Assert.assertTrue(formFillPage.verifyMessage.isDisplayed(),"Application not saved");
    }

    @AfterMethod
    public void tearDown()
    {
        baseClass.quitApplications();
    }
}