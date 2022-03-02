package FirstDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Open_Web {
    public static void main(String[] args) {
        System.setProperty("webdriver.chromedriver","C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://iresource.smartdev.vn/");

    }
}

