package webautomation.utils.browser;

import io.github.bonigarcia.wdm.OperaDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class OperaBrowser implements Browser {
    @Override
    public WebDriver getDriver() {
        OperaDriverManager.getInstance().setup();
        System.setProperty("webdriver.opera.driver", "C:\\Users\\mstyczen\\Documents\\operadriver_win64\\operadriver.exe");
        DesiredCapabilities dc = DesiredCapabilities.opera();
//        OperaOptions operaOptions = new OperaOptions();
//        operaOptions.setBinary(new File("C:\\Users\\mstyczen\\AppData\\Local\\Programs\\Opera\\launcher.exe"));
//        operaOptions.addArguments("start-maximized"); // open Browser in maximized mode
//        operaOptions.addArguments("disable-infobars"); // disabling infobars
//        operaOptions.addArguments("--disable-extensions"); // disabling extensions
//        operaOptions.addArguments("--disable-gpu"); // applicable to windows os only
//        operaOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
//        operaOptions.addArguments("--no-sandbox"); // Bypass OS security model
//        operaOptions.addArguments("--headless"); // Bypass OS security model
//
//        dc.setCapability(ChromeOptions.CAPABILITY,operaOptions);
//        dc.setBrowserName("opera");
        dc.setCapability("opera.binary", "C:\\Users\\mstyczen\\AppData\\Local\\Programs\\Opera\\launcher.exe");

        return new OperaDriver(dc);
    }
}