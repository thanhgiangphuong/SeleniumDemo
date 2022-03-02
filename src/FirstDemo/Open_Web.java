package FirstDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Open_Web {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chromedriver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com/");
        Thread.sleep(1000);
        driver.manage().window().maximize();

        // Open the first video of Nam Em cover list on youtube
        driver.findElement(By.xpath("/html/body/ytd-app/div/div/ytd-" +
                "masthead/div[3]/div[2]/ytd-searchbox")).sendKeys("Nam Em cover");
        driver.findElement(By.xpath("//*[@id=\"search-icon-legacy\"]/yt-icon")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string")).click();
        Thread.sleep(7000);
        driver.findElement(By.xpath("//*[@id=\"skip-button:5\"]/span/button/span")).click();

        // Right click to open video setting
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[1]/video"));
        actions.contextClick(elementLocator).perform();

    }
}

