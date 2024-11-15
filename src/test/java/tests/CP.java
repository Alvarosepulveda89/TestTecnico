package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.ArticuloPage;
import pages.ListadoPage;
import pages.HomePage;
import utils.PropertiesManager;

public class CP {

    private WebDriver driver; //null
    private HomePage homePage;
    private ListadoPage listadoPage;
    private ArticuloPage articuloPage;

    private String browser = PropertiesManager.obtenerProperty("browser");
    private String propertyDriver = PropertiesManager.obtenerProperty("propertyDriver");
    private String rutaDriver = PropertiesManager.obtenerProperty("rutaDriver");
    private String url = PropertiesManager.obtenerProperty("url");


    @BeforeEach
    public void preparacionTests() {
        homePage = new HomePage(driver);
        homePage.conexionDriver(browser, rutaDriver, propertyDriver);
        listadoPage = new ListadoPage(homePage.getDriver());
        articuloPage = new ArticuloPage(listadoPage.getDriver());
        homePage.cargarURL(url);
        homePage.maximizarBrowser();
    }


    @Test
    public void CP01buscarProducto() {

        homePage.buscarProducto("zapatilla");
        homePage.esperarXSegundos(5000);
        listadoPage.seleccionarProducto();
        listadoPage.esperarXSegundos(5000);
        articuloPage.traeDescripcion();
        articuloPage.esperarXSegundos(5000);
        System.out.println(articuloPage.txtDescripcion());
    }

    @AfterEach
    public void posEjecucion() {
        homePage.cerrarBrowser();
    }
}