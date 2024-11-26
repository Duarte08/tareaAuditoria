package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Test {
    private WebDriver driver;

    public Test() {
        setupDriver();
    }

    public void setupDriver() {
        System.setProperty("webdriver", "C:\\Users\\Manuel Duarte\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Espera implícita
    }

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

    public void testTres() {
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

    public void testCuatro() {
        try {
            // Navegar a Google
            driver.navigate().to("https://www.google.com");

            // Buscar "mike mike"
            WebElement searchbox = driver.findElement(By.name("q"));
            searchbox.sendKeys("mike mike");
            searchbox.sendKeys(Keys.RETURN);

            // Esperar hasta que el primer resultado sea clickeable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")));
            firstResult.click();

            // Clic para cerrar modal
            WebElement result = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"onesignal-slidedown-cancel-button\"]")));
            result.click();

            // Agregar el primer ítem al carrito
            WebElement firstProduct = driver.findElement(By.cssSelector("#root > div > div > div:nth-child(3) > div > div:nth-child(2) > div.relative > div.slick-slider.slick-initialized > div > div > div.slick-slide.slick-active.slick-current > div > div"));
            firstProduct.click();

            WebElement firstItemButton = driver.findElement(By.cssSelector("body > div:nth-child(7) > div > div > div > div > div.md\\:flex.relative.overflow-hidden.p-4 > div.relative.w-full.md\\:w-2\\/5.mr-4 > div.w-5\\/6.my-3 > button"));
            firstItemButton.click();
            Thread.sleep(2000);
            WebElement closeVentana = driver.findElement(By.cssSelector("body > div:nth-child(7) > div > div > button"));
            closeVentana.click();
            Thread.sleep(2000);

            // Agregar el segundo ítem al carrito
            WebElement secondProduct = driver.findElement(By.cssSelector("#root > div > div > div:nth-child(3) > div > div:nth-child(4) > div.flex.items-center > div.w-full.md\\:w-8\\/12.relative > div.slick-slider.slick-initialized > div > div > div:nth-child(5) > div > div"));
            secondProduct.click();
            Thread.sleep(3000);

            WebElement secondItemButton = driver.findElement(By.cssSelector("body > div:nth-child(7) > div > div > div > div > div.md\\:flex.relative.overflow-hidden.p-4 > div.relative.w-full.md\\:w-2\\/5.mr-4 > div.w-5\\/6.my-3 > button"));
            secondItemButton.click();
            Thread.sleep(3000);

            WebElement closeVentanaDos = driver.findElement(By.cssSelector("body > div:nth-child(7) > div > div > button"));
            closeVentanaDos.click();

            // Abrir el carrito
            WebElement cartButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/nav/div[1]/div/div[1]/div[3]/div[1]/a"));
            cartButton.click();

            // Esperar a que los ítems en el carrito sean visibles
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/div/div")));
            // Paso 2: Validar los ítems en el carrito
            List<WebElement> cartItems = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/div/div"));
            int itemCount = cartItems.size();

            System.out.println("Número de ítems en el carrito: " + itemCount);
            assert itemCount == 2 : "El número de ítems en el carrito no coincide.";

        } catch (Exception e) {
            System.out.println("Se produjo un error durante la ejecución: " + e.getMessage());
        } finally {
            // Cerrar el navegador al finalizar el test
            if (driver != null) {
                driver.quit();
            }
        }
    }
    //Cierra el navegador y finaliza el WebDriver
    public void closeWindow() {
        if (driver != null) {
            driver.close();
        }
    }

}




