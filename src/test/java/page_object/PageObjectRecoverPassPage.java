package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectRecoverPassPage {

    private By buttonLogin = By.xpath(".//a[text()='Войти']");
    private WebDriver driver;

    public PageObjectRecoverPassPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonLogin() {
        driver.findElement(buttonLogin).click();
    }


}
