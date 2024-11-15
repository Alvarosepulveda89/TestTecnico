package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Base;

public class ListadoPage extends Base {
    public ListadoPage(WebDriver driver) {
        super(driver);
    }

    By locatorLista = By.xpath("//*[@id=\"root-app\"]/div/div[3]/section/ol/li");


    public void seleccionarProducto(){
        // List<WebElement> resultados = driver.findElements(locatorLista);
        buscarElementosWeb(locatorLista).get(2).click();
    }
}
