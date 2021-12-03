package scenario;

import elements.*;
import baseTest.Base;
import methods.Methods;
import org.junit.jupiter.api.Test;

public class ScenarioTest extends Base {
    Methods steps = new Methods();
    HomePage homePage;
    LoginPage loginPage;
    ShopPage shopPage;
    BasketPage basketPage;
    OrderPage orderPage;
    TabPage tabPage;
    FavoritesPage favoritesPage;

    @Test
    public void TestScenario() throws Exception {

        steps.clickToElement(homePage.login);
        steps.clickToElement(homePage.loginButton);
        steps.waitSecond(1000);

        steps.sendKeysToElement(loginPage.txtEmail, loginPage.email);
        steps.sendKeysToElement(loginPage.txtPassword, loginPage.password);
        steps.clickToElement(loginPage.btnLogin);
        steps.waitSecond(1000);

        steps.sendKeysToElement(shopPage.searchBox, shopPage.blanketProductText);
        steps.waitSecond(1000);
        steps.clickToElement(shopPage.searchButton);
        steps.clickToElement(shopPage.blanketProducts);
        steps.randomClick(shopPage.favoriteButton, shopPage.favoriteProductText);
        steps.waitSecond(3000);
        steps.clickToElement(shopPage.goToHomePage);
        steps.sendKeysToElement(shopPage.searchBox, shopPage.bagProductText);
        steps.clickToElement(shopPage.searchButton);
        steps.bagClick(shopPage.bagProducts);
        steps.waitSecond(2000);
        steps.clickToElement(shopPage.popUp1);
        steps.clickToElement(shopPage.bagBasketButton);
        steps.clickToElement(shopPage.goToBasketButton);

        steps.clickToElement(basketPage.productPlusButton);
        steps.clickToElement(basketPage.productPlusButtonValue);
        steps.clickToElement(basketPage.tradeEndButton);
        steps.waitSecond(1000);

        steps.clickToElement(orderPage.saveAddressButton);
        steps.clickToElement(orderPage.editBasketButton);

        steps.clickToElement(basketPage.secondFavoriteProductBasketButton);
        steps.waitSecond(1000);

        steps.favoritesPage();
        steps.clickToElement(favoritesPage.favoriteThirdProductButton);
        steps.clickToElement(favoritesPage.deleteButton);

        steps.newHomeTab();
        steps.clickToElement(tabPage.login2);
        steps.clickToElement(tabPage.logoutButton);
        steps.clickToElement(tabPage.closeTabWindow);
        steps.close();
    }
}


