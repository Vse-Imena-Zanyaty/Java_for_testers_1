package mantis.appManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AppManager {
  private final Properties properties;
  private WebDriver wd;

  private String browser;
  private RegistrationMethods registrationMethods;

  public AppManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
  }

  public void stop() {
    if (wd != null){
      wd.quit();
    }
  }

  public HttpSession newSession() {
    return new HttpSession(this);
  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }

  public RegistrationMethods registration() {
    if (registrationMethods == null) {
      registrationMethods = new RegistrationMethods(this);
    }
    return registrationMethods;
  }

  public WebDriver getDriver() {
    if (wd == null) {
      if (browser.equals(BrowserType.CHROME)) {
        properties.getProperty("webdriver.chrome.wd");
        wd = new ChromeDriver();
      } else if (browser.equals(BrowserType.FIREFOX)) {
        properties.getProperty("webdriver.firefox.wd");
        wd = new FirefoxDriver();
      } else if (browser.equals(BrowserType.IE)) {
        properties.getProperty("webdriver.IE.wd");
        wd = new InternetExplorerDriver();
      }
      wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
      wd.get(properties.getProperty("web.baseUrl"));
    }
    return wd;
  }
}
