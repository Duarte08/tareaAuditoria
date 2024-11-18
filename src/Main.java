import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
      System.setProperty("webdriver","C:\\Users\\Manuel Duarte\\Downloads\\chrome.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("eel ues");
        searchbox.sendKeys(Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement eel= driver.findElement(By.id("APjFqb"));
        eel.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.close();
    }
}