import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public WebDriver driver;

    public static void main(String[] args) {
        Main main = new Main();
        main.setupDriver(); // Configurar el WebDriver
        //main.testUno();
        main.testDos();
        //main.testTres();
        //main.testCuatro();// Ejecutar la prueba
        main.closeWindow();    // Cerrar el navegador
    }

    //Configura el WebDriver y abre el navegador.
    public void setupDriver() {
        System.setProperty("webdriver", "C:\\Users\\Manuel Duarte\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Espera implícita
    }

    //Ejecuta el caso de prueba
    public void testUno() {
        try {
            // Navegar a Google
            driver.navigate().to("https://www.google.com");

            // Buscar "mike mike"
            WebElement searchbox = driver.findElement(By.name("q"));
            searchbox.sendKeys("mike mike");
            searchbox.sendKeys(Keys.RETURN);

            // Hacer clic en el primer resultado
            WebElement firstResult = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3"));
            firstResult.click();

            // Hacer clic en un botón de búsqueda
            WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"lithium-root\"]/main/div[3]/div/div/div[2]/form/div/span/button"));
            searchButton.click();

        } catch (Exception e) {
            System.out.println("Se produjo un error durante la ejecución: " + e.getMessage());
        }
    }
    public void testDos() {
            try {
                // Navegar a Google
                driver.navigate().to("https://www.google.com");

                // Buscar "mike mike"
                WebElement searchbox = driver.findElement(By.name("q"));
                searchbox.sendKeys("mike mike");
                searchbox.sendKeys(Keys.RETURN);

                // Esperar hasta que el primer resultado sea clickeable
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")));
                firstResult.click();

                //Clic para cerrar modal
                WebElement Result = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"onesignal-slidedown-cancel-button\"]")));
                Result.click();

                // Esperar hasta que las secciones sean clickeables y hacer clic en cada una
                String[] sectionXPaths = {
                        "//*[@id=\"root\"]/div/div/nav/div[2]/ul/li[1]/a/p", // Mochilas
                        "//*[@id=\"root\"]/div/div/nav/div[2]/ul/li[2]/a/p", // Bolsos
                        "//*[@id=\"root\"]/div/div/nav/div[2]/ul/li[3]/a/p", // Maletines
                        "//*[@id=\"root\"]/div/div/nav/div[2]/ul/li[4]/a/p", // Maletas
                        "//*[@id=\"root\"]/div/div/nav/div[2]/ul/li[5]/a/p", // Billeteras
                        "//*[@id=\"root\"]/div/div/nav/div[2]/ul/li[6]/a/p", // Accesorios
                        "//*[@id=\"root\"]/div/div/nav/div[2]/ul/li[7]/a/p"  // Outlet
                };

                for (String xpath : sectionXPaths) {
                    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                    element.click();
                    Thread.sleep(5000);
                   // wait.withTimeout(Duration.ofSeconds(600));  // Pausa para asegurar la carga de cada sección
                }

            } catch (Exception e) {
                System.out.println("Se produjo un error durante la ejecución: " + e.getMessage());
            }

    }

    //Cierra el navegador y finaliza el WebDriver
    public void closeWindow() {
        if (driver != null) {
            driver.close();
        }
    }
}
