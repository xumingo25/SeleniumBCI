package Unidad2.tests;

import Unidad2.pages.HomePage;
import Unidad2.pages.LoginPage;
import Unidad2.pages.RegisterPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class CasosDePrueba {
    private WebDriver driver; //null
    private HomePage homePage;
    private RegisterPage registerPage;
    private LoginPage loginPage; //null
    private String browser = "chrome";
    private String propertyDriver = "webdriver.chrome.driver";
    private String rutaDriver = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
    private String url = "https://open.spotify.com/";

    @BeforeEach
    public void preparacionTests(){
        homePage = new HomePage(driver);
        homePage.conexionDriver(browser,rutaDriver,propertyDriver);
        homePage.manejoEsperasElementosWeb(10);
        registerPage = new RegisterPage(homePage.getDriver());
        loginPage = new LoginPage(homePage.getDriver());

        homePage.cargarURL(url);
        homePage.maximizarBrowser();
    }

    @Test
    public void CP001_creacion_cta(){
        homePage.irARegistrarte();
        registerPage.crearCuenta("em67865343351@algo.com","123FFF24","User Test BCI","31","10","1990",0,true,true);
        Assertions.assertEquals("User Test BCI",homePage.getUsername());
    }

    @Test
    public void CP002_iniciar_sesion(){
        homePage.irAIniciarSesion();
        loginPage.login("emailTest123456@algo.com","Frre3232");
        Assertions.assertEquals("Curso BCI Selenium",homePage.getUsername());
    }

    @AfterEach
    public void posEjecucion(){
        homePage.cerrarBrowser();
    }
}
