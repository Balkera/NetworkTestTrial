import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductsPage;

public class Test_Add_Product_To_Cart extends BaseTest {

    HomePage homePage ;
    ProductsPage productsPage ;
    ProductDetailPage productDetailPage ;
    LoginPage LoginPage ;

    @Test
    @Order(1)
    public void search_a_product(){
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("ceket");
        Assertions.assertTrue(productsPage.isOnProductPage() ,
                "ERROR 1: ceket");
    }

    @Test
    @Order(2)
    public void products_page_number(){

    String URL = driver.getCurrentUrl();
    Assert.assertEquals(URL, "https://www.network.com.tr/search?searchKey=ceket&page=2" );
    }
                
                
    @Test
    @Order(3)
    public void select_a_product(){
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectProduct(1);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),
                "ERROR 3: product detail page!");
    }

    @Test
    @Order(4)
    public void add_product_to_cart(){
        productDetailPage.addToCart();
        Assertions.assertTrue(homePage.isProductCountUp(),
                "Product count did not increase!");
    }

    @Test
    @Order(5)
    public void go_to_cart(){
        LoginPage = new LoginPage(driver);
        homePage.goToCart();
        Assertions.assertTrue(LoginPage.LogIn() ,
                "Login Failed!");
    }
    




}
