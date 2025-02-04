package stepdefs;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.ProductPage;

public class CartSteps extends BaseSteps {
    private ProductPage productPage;
    private CartPage cartPage;
    private double initialPrice;

    @Given("I am on the product page for {string}")
    public void iAmOnProductPage(String product) {
        productPage = new ProductPage(driver);
        productPage.navigateToProduct();
    }

    @When("I add the product to cart")
    public void iAddProductToCart() {
        productPage.addToCart();
        Assert.assertTrue(productPage.isProductAddedToCart());
    }

    @When("I navigate to cart page")
    public void iNavigateToCartPage() {
        cartPage = new CartPage(driver);
        cartPage.navigateToCart();
        initialPrice = cartPage.getTotalPrice();
    }

    @When("I update the quantity to {int}")
    public void iUpdateQuantity(int quantity) throws InterruptedException {
        cartPage.updateQuantity(quantity);
    }

    @Then("the cart total should be updated correctly")
    public void cartTotalShouldBeUpdated() {
        double updatedPrice = cartPage.getTotalPrice();
        Assert.assertEquals(updatedPrice, initialPrice * 3);
    }
}
