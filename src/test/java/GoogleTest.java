import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GoogleTest {
    WebDriver driver;
    String url;
    String search;
    @Before
    public void before () {
        driver = new ChromeDriver();
        url = "https://google.com.ua";
        search = "cats";
        driver.get(url);
    }

    @Test
    public void testMethod () {
        driver.findElement(By.cssSelector("input[name='q']")).sendKeys(search);
        driver.findElement(By.cssSelector("input[name='q']")).sendKeys(Keys.ENTER);
        List<WebElement> elements = driver.findElements(By.cssSelector(".rc"));
        for (WebElement el: elements) {
            Assert.assertTrue(el.getText().toLowerCase().contains(search));
        }
        }

        @After
    public void after () {
            driver.quit();
    }
}
