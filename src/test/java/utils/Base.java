package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Base {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public Base(WebDriver driver){
        this.driver = driver;
    }



    public void click(By localizador){
        driver.findElement(localizador).click();
    }
    public void click(WebElement elemento){
        elemento.click();
    }

    public WebDriver getDriver() {
        return driver;
    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriverWait getWait() {
        return wait;
    }
    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    public String obtenerTexto(WebElement elemento){
        return elemento.getText();
    }
    public String obtenerTexto(By localizador){
        return driver.findElement(localizador).getText();
    }


    public void agregarTexto(By localizador, String texto){
        driver.findElement(localizador).sendKeys(texto);
    }
    public void agregarTexto(WebElement elemento, String texto){
        elemento.sendKeys(texto);
    }

    public List<WebElement> buscarElementosWeb(By localizador){
        return driver.findElements(localizador);
    }

    public WebElement esperarPorElementoAClickear(By localizador){
        WebElement elementoEsperado = wait.until(ExpectedConditions.elementToBeClickable(localizador));
        return elementoEsperado;}



    //Conexion Driver
    public WebDriver conexionDriver(String browser,String rutaDriver,String property){
        switch(browser){ //chrome
            case "chrome":
                System.setProperty(property,rutaDriver);
                this.driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty(property,rutaDriver);
                this.driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty(property,rutaDriver);
                this.driver = new EdgeDriver();
                break;
            default:
                this.driver = null;
        }
        return driver;
    }


    public void maximizarBrowser(){
        driver.manage().window().maximize();
    }
    public void cargarURL(String url){
        driver.get(url);
    }
    public void cerrarBrowser(){
        driver.quit();
    }
    public String obtenerUrlPagina(){
        return this.driver.getCurrentUrl();
    }

    public void esperarXSegundos(int miliSegundos) {
        try {
            Thread.sleep(miliSegundos);
        } catch (InterruptedException e) {
            System.out.println("Ha ocurrido un error :/");
            throw new RuntimeException(e);
        }
    }
}
