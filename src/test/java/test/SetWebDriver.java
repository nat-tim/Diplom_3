package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SetWebDriver {
    private static String baseUri = "https://stellarburgers.nomoreparties.site";

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
        return baseUri+"/register";
    }

    public static String getUrlLogin() {
        return baseUri+"/login";
    }

    public static String getUrlHome() {
        return baseUri;
    }

    public static String getUrlRecoverPass() {
        return baseUri+"/forgot-password";
    }
    public static String getApiDelUser() {
        return baseUri+"/api/auth/user";
    }
    public static String getApiLoginUser() {
        return baseUri+"/api/auth/login";
    }
    public static String getApiRegUser() {
        return baseUri+"/api/auth/register";
    }
}
