package pages;

import config.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ContactPage {
    private WebDriverWait wait;

    @FindBy(css = "a[data-test='nav-contact']")
    private WebElement contactLink;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "message")
    private WebElement messageInput;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(css = ".alert-success")
    private WebElement successMessage;

    @FindBy(css = ".invalid-feedback")
    private List<WebElement> validationErrors;

    public ContactPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
    }

    public void navigateToContact() {
        wait.until(ExpectedConditions.elementToBeClickable(contactLink)).click();
    }

    public void fillContactForm(String firstName, String lastName, String email, String message) {
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        messageInput.sendKeys(message);
    }

    public void submitForm() {
        submitButton.click();
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(successMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean areValidationErrorsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(validationErrors));
            return validationErrors.stream().anyMatch(WebElement::isDisplayed);
        } catch (Exception e) {
            return false;
        }
    }
}