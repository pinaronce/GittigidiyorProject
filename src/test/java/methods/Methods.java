package methods;

import baseTest.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.fail;

public class Methods extends Base {


    public static String favoriteProduct2;
    public static String favoriteProduct3;
    public static String Url2 = "https://www.gittigidiyor.com/hesabim/izlediklerim";


    public static WebElement findElement(String key) {
        try {
            WebElement element = (new WebDriverWait(driver, 5, 300))
                    .until(ExpectedConditions.elementToBeClickable(By.cssSelector(key)));
            return element;

        } catch (Exception ex) {
            return null;
        }
    }

    public static List<WebElement> findElements(String key) {
        try {
            WebDriverWait waitForFormLabel = new WebDriverWait(driver, 30);
            List<WebElement> elements = driver.findElements(By.cssSelector(key));
            waitForFormLabel.until(ExpectedConditions.visibilityOfAllElements(elements));
            return elements;
        } catch (Exception ex) {
            return null;
        }
    }

    public static void waitSecond(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickToElement(String key) {
        WebElement element = findElement(key);
        waitSecond(500);
        element.click();
    }

    public void sendKeysToElement(String key, String text) {
        WebElement element = findElement(key);
        waitSecond(500);
        element.sendKeys(text);
    }

    public static void verticalScrollDown(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void randomClick(String key, String keyText) {
        List<WebElement> elements = findElements(key);
        List<WebElement> textElements = findElements(keyText);
        Random random = new Random();
        int low = 1;
        int high = 32;

        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() != 4) {
            int result = random.nextInt(high - low) + low;
            if (!numbers.contains(result)) {
                numbers.add(result);
            }
        }
        for (Integer sayi : numbers) {
            waitSecond(3000);

            verticalScrollDown(elements.get(sayi));
            System.out.println("Tıklanan sayı: " + sayi);
            elements.get(sayi).click();
        }
        String product2 = textElements.get(numbers.get(1)).getText();
        String product3 = textElements.get(numbers.get(2)).getText();
    }

    public void bagClick(String key) {
        List<WebElement> elements = findElements(key);
        int low = 1;
        int high = 32;
        int bagProduct = 6;
        elements.get(bagProduct).click();
        System.out.println(bagProduct + ". Elemente tıklandı..");
    }

    public void newHomeTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.gittigidiyor.com/");
    }

    public void favoritesPage() {
        driver.get(Url2);
    }
}
