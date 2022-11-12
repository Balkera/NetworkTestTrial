package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class LoginPage extends BasePage {

    By LoginButtonLocator = new By.ByCssSelector("n-button large block text-center -primary ");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfProductAdded() {
        return getProducts().size() > 0 ;
    }

    private List<WebElement> getProducts(){
        return findAll(LoginButtonLocator);
    }
}
