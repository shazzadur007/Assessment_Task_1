
package stepdefs;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.ContactPage;
import config.DriverManager;

public class ContactSteps {
    private final ContactPage contactPage = new ContactPage();

    @Given("I am on the contact page")
    public void navigateToContactPage() {
        DriverManager.getDriver().get("https://practicesoftwaretesting.com/contact");
        contactPage.navigateToContact();
    }

    @When("I submit the form without filling any fields")
    public void submitEmptyForm() {
        contactPage.submitForm();
    }

    @When("I fill in the contact form with valid data")
    public void fillContactForm() {
        contactPage.fillContactForm("John", "Doe", "john.doe@example.com", "Test message");
    }

    @And("I submit the form")
    public void submitForm() {
        contactPage.submitForm();
    }

    @Then("I should see validation errors")
    public void verifyValidationErrors() {
        Assert.assertTrue(contactPage.areValidationErrorsDisplayed(), "Validation errors not displayed");
    }

    @Then("I should see a success message")
    public void verifySuccessMessage() {
        Assert.assertTrue(contactPage.isSuccessMessageDisplayed(), "Success message not displayed");
    }
}