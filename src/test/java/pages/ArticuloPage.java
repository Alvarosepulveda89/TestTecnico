package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Base;

public class ArticuloPage extends Base {
    public ArticuloPage(WebDriver driver) {
        super(driver);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;
    By locatorbtnDescripcion = By.xpath("//*[@id=\"description\"]/div/button");
    By locatortxtDescripcion = By.xpath("//*[@id=\"description\"]/div/div/div/p");

    public void traeDescripcion() {
        js.executeScript("window.scrollBy(0,2000)");
        click(locatorbtnDescripcion);
    }

    public String txtDescripcion() {
        return obtenerTexto(locatortxtDescripcion);
    }
}