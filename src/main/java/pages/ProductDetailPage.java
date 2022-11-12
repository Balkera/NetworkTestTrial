package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage{

    By addToCartButtonLocator = new By.ByCssSelector("header__icon -shoppingBag");
    By continueButtonLocator = new By.ByCssSelector("continueButton n-button large block text-center -primary");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        click(addToCartButtonLocator);
        click(continueButtonLocator);
    }
}
