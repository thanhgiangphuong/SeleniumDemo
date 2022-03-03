package HotelProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Auto_HotelPrj {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chromedriver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://14.176.232.213:8084/");
        Thread.sleep(1000);
        driver.manage().window().maximize();



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

        driver.findElement(By.id("cardNumber")).sendKeys("1111111111111111");
        driver.findElement(By.id("ownerName")).sendKeys("PHUONG THANH GIANG");
        Thread.sleep(2000);
        driver.findElement(By.name("expiry")).sendKeys("05/25");
        driver.findElement(By.id("cvvcode")).clear();
        driver.findElement(By.id("cvvcode")).sendKeys("123");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"cardForm\"]/div[6]/input[2]")).click();

        String a = driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/p[1]/span[2]")).getText();
        System.out.println(a);
        System.out.println("Booking room successfully");


    }
}
