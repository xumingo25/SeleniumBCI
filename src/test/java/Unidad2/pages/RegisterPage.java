package Unidad2.pages;

import Unidad2.utils.ClaseBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage extends ClaseBase {

    //Centralizar Localizadores
    By locatorTxtUsername = By.id("login-username");

    By locatorBtnSiguiente = By.xpath("//button[@data-testid='submit']");

    By locatorTxtPass = By.id("new-password");

    By locatorTxtNickname = By.id("displayName");

    By locatorTxtDia = By.xpath("//input[@id='day']");

    By locatorDDLMes = By.xpath("//select[@id='month']");

    By locatorTxtAnnio = By.xpath("//input[@id='year']");

    By locatorOptionGender = By.xpath("//label[contains(@for,'gender')]");

    By locatorCheck = By.xpath("//label[contains(@for,'checkbox')]");
    //Funciones

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void ingresarDia(String dia){
        agregarTexto(esperarPresenciaWebElement(locatorTxtDia),dia);
    }

    public void siguiente(){
        click(esperarPorElementoAClickear(locatorBtnSiguiente));
    }

    public void crearCuenta(String email,String pass,String nick,String dia,String mes,String annio,int genero,boolean checkPriv,boolean checkEnvioInfo){
        agregarTexto(esperarPresenciaWebElement(locatorTxtUsername),email);
        click(esperarPorElementoAClickear(locatorBtnSiguiente));
        agregarTexto(esperarPresenciaWebElement(locatorTxtPass),pass);
        click(esperarPorElementoAClickear(locatorBtnSiguiente));
        agregarTexto(esperarPresenciaWebElement(locatorTxtNickname),nick);
        agregarTexto(esperarPresenciaWebElement(locatorTxtDia),dia);
        selecionarComboBoxPorValue("10",esperarPresenciaWebElement(locatorDDLMes));
        agregarTexto(esperarPresenciaWebElement(locatorTxtAnnio),annio);
        List<WebElement> generos = buscarElementosWeb(locatorOptionGender);
        generos.get(genero);
        click(esperarPorElementoAClickear(locatorBtnSiguiente));

        List<WebElement> checks = buscarElementosWeb(locatorCheck);



    }


}
