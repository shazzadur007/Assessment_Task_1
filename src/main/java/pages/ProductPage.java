package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverHelper;

public class ProductPage {
    private WebDriver driver;
    private WebDriverHelper helper;

    @FindBy(id = "btn-add-to-cart")
    private WebElement addToCartButton;

    @FindBy(id = "quantity-input")
    private WebElement cartCount;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.helper = new WebDriverHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToProduct() {
        driver.get("https://practicesoftwaretesting.com/product/01JK8V1HJ13EBJGVN5ESWFYENS");
        helper.waitForElement(addToCartButton);
    }

    public void addToCart() {
        helper.waitForElementClickable(addToCartButton);
        addToCartButton.click();
    }

    public boolean isProductAddedToCart() {
        helper.waitForElement(cartCount);
        return Integer.parseInt(cartCount.getText().trim()) > 0;
    }
}
