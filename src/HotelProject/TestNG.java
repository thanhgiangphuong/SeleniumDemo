package HotelProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestNG {
    WebDriver driver;

    @BeforeClass
    public void seTup() throws InterruptedException {
        System.setProperty("webdriver.chromedriver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://14.176.232.213:8084/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void TC01_Searchroom() throws InterruptedException {
        driver.findElement(By.id("check-in")).sendKeys("03/03/2022");
        driver.findElement(By.id("check-out")).sendKeys("05/03/2022");
        driver.findElement(By.name("adult")).sendKeys("2");
        driver.findElement(By.name("children")).sendKeys("1");
        driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div/div/form/div[2]/div[3]/div/input")).click();
        Thread.sleep(2000);
        String a = driver.findElement(By.cssSelector("body > section:nth-child(9) > div > div > div > div > div > div > h2")).getText();
        Assert.assertEquals(a, "Rooms");
    }
    @Test(priority = 2)
    public void TC02_Bookroom() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/section[2]/div/div/div[1]/div/div[2]/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"booking\"]/input")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("name")).sendKeys("Phuong Thanh Giang");
        driver.findElement(By.id("email")).sendKeys("phuongthanhgiang@gmail.com");
        driver.findElement(By.id("phone")).sendKeys("0986474334");
        driver.findElement(By.id("address")).sendKeys("DN");
        driver.findElement(By.xpath("//*[@id=\"user\"]/div/div[1]/div[5]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"user\"]/div/div[1]/div[6]/input")).click();
        Thread.sleep(2000);
        String b = driver.findElement(By.cssSelector("/html/body/section[1]/div/div/div/div/div/div/h2")).getText();
        Assert.assertEquals(b, "Checkout");
    }
    @Test(priority = 3)
    public void TC03_Payment() throws InterruptedException {
        driver.findElement(By.id("cardNumber")).sendKeys("1111111111111111");
        driver.findElement(By.id("ownerName")).sendKeys("PHUONG THANH GIANG");
        Thread.sleep(2000);
        driver.findElement(By.name("expiry")).sendKeys("05/25");
        driver.findElement(By.id("cvvcode")).clear();
        driver.findElement(By.id("cvvcode")).sendKeys("123");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"cardForm\"]/div[6]/input[2]")).click();

        String c = driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div/div/h2")).getText();
        Assert.assertEquals(c, "Confirm");
    }

}
