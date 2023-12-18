package Unidad2.tests;

import Unidad2.pages.HomePage;
import Unidad2.pages.LoginPage;
import Unidad2.pages.RegisterPage;
import Unidad2.utils.DataDriven;
import Unidad2.utils.PropertiesManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class CasosDePrueba {
    private WebDriver driver; //null
    private HomePage homePage;
    private RegisterPage registerPage;
    private LoginPage loginPage; //null
    private String browser = PropertiesManager.obtenerProperty("browser");
    private String propertyDriver = PropertiesManager.obtenerProperty("propertyDriver");
    private String rutaDriver = PropertiesManager.obtenerProperty("rutaDriver");
    private String url = PropertiesManager.obtenerProperty("url");
    private ArrayList<String> datosPrueba; //null

    @BeforeEach
    public void preparacionTests(){
        datosPrueba = new ArrayList<String>(); //arreglo tamaño 0
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
        datosPrueba = DataDriven.prepararData("CP001_creacion_cta");
        homePage.irARegistrarte();
        registerPage.crearCuenta(datosPrueba.get(1),datosPrueba.get(2),datosPrueba.get(3),datosPrueba.get(4),datosPrueba.get(5),datosPrueba.get(6), Integer.parseInt(datosPrueba.get(7)),true,true);
        Assertions.assertEquals(datosPrueba.get(8),homePage.getUsername());
    }

    @Test
    public void CP002_iniciar_sesion(){
        datosPrueba = DataDriven.prepararData("CP002_iniciar_sesion");
        homePage.irAIniciarSesion();
        loginPage.login(datosPrueba.get(1),datosPrueba.get(2));
        Assertions.assertEquals(datosPrueba.get(3),homePage.getUsername());
    }

    @AfterEach
    public void posEjecucion(){
        homePage.cerrarBrowser();
    }
}
