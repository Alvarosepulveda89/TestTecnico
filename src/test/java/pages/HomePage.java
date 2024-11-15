package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Base;

import java.util.List;

public class HomePage extends Base {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By locatorTxtBuscar = By.xpath("//*[@id=\"cb1-edit\"]");
    By locatorBtnBuscar = By.xpath("/html/body/header/div/div[2]/form/button");



    public void buscarProducto(String buscar) {
        agregarTexto(locatorTxtBuscar, buscar);
        click(locatorBtnBuscar);
    }


}