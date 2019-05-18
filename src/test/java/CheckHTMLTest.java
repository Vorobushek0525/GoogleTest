import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashSet;
import java.util.List;

public class CheckHTMLTest {
    static WebDriver driver;
    static String url;

    @BeforeClass
    public static void beforeMethod () {
        driver =  new ChromeDriver();
        url = "https://mvnrepository.com/";
        driver.get(url);
    }

    @Test
    public void test1Method () {
        int jsSize = driver.findElements(By.cssSelector("script:not([src])")) .size();
        Assert.assertEquals( 0, jsSize);
    }
    @Test
    public void test2Method (){
        int jsSize = driver.findElements(By.cssSelector("script[src]")).size();
        Assert.assertEquals( 1, jsSize);
    }
    @Test
    public void test3Method () {
        int cssSize = driver.findElements(By.cssSelector("style")).size();
        Assert.assertEquals(0, cssSize);
    }

    @Test
    public void test4Method () {
        int cssSize = driver.findElements(By.cssSelector("link[rel='stylesheet']")).size();
        Assert.assertEquals( 1, cssSize);
    }

    @Test
    public void test5Method () {
        List<WebElement> elements = driver.findElements(By.cssSelector("[id]"));
        int sizeBefore = elements.size();
        HashSet<String> strings = new HashSet<String>();
        for (WebElement el: elements) {
            strings.add(el.getAttribute("id"));
        }
        Assert.assertEquals(sizeBefore, strings.size());
    }

    @AfterClass
    public static void afterMethod () {
        driver.quit();
    }
}
