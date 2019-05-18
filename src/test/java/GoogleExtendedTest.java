import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.List;

public class GoogleExtendedTest {
    static WebDriver driver;
    static String url;
    static String search;
    static int pageCount;
    @BeforeClass
    public static void before () {
        driver = new ChromeDriver();
        url = "https://google.com.ua";
        search = "buy car";
        pageCount = 2;
        driver.get(url);
        driver.findElement(By.cssSelector("input[name='q']")).sendKeys(search);
        driver.findElement(By.cssSelector("input[name='q']")).sendKeys(Keys.ENTER);
    }

    @Test
    public void testMethod () {
        String[] searchWord = search.split("  ");
        for (int i = 0; i < pageCount; i++){
            System.out.println(driver.getCurrentUrl());
            List<WebElement> elements = driver.findElements(By.cssSelector(".rc"));

            for (WebElement el: elements) {
                for (int j = 0; j < searchWord.length; j++){
                    Assert.assertTrue(el.getText().toLowerCase().contains(searchWord[j].toLowerCase()));
                }
            }
            if (pageCount == i +1){
                break;
            }
            String href = driver.findElement(By.cssSelector("div#navcnt > table tr > td:nth-child(" + (i + 3) + ") > a")).getAttribute("href");
            driver.get(href);
        }
    }

    @AfterClass
    public static void after () {
       // driver.quit();
    }
}
