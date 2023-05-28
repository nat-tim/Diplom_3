package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SetWebDriver {
    private static String urlRegistration = "https://stellarburgers.nomoreparties.site/register";
    private static String urlLogin = "https://stellarburgers.nomoreparties.site/login";
    private static String urlHome = "https://stellarburgers.nomoreparties.site";
    private static String urlRecoverPass = "https://stellarburgers.nomoreparties.site/forgot-password";

    public static WebDriver setupDriver() {
        WebDriver driver;
        String setBrowser = "yandex"; //yandex, chrome
        if (setBrowser.equals("chrome")) {
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static String getUrlRegistration() {
        return urlRegistration;
    }

    public static String getUrlLogin() {
        return urlLogin;
    }

    public static String getUrlHome() {
        return urlHome;
    }

    public static String getUrlRecoverPass() {
        return urlRecoverPass;
    }
}
