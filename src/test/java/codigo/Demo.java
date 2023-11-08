package codigo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
    public static void main(String[] args) {

        String rutaDriver = "C:\\Users\\domingo.saavedra\\Documents\\BCI_Selenium\\src\\test\\resources\\drivers\\chromedriver.exe";

        //Enlazar el driver via property en el sistema
        System.setProperty("webdriver.chrome.driver",rutaDriver);

        //Instanciar objetos para emular el browser
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.cl");

    }
}
