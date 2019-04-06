package Lecture22.addressbook.appManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AppManager {
  private final Properties properties;
  private WebDriver wd;

  private SessionMethods sessionMethods;
  private NavigationMethods navigationMethods;
  private GroupMethods groupMethods;
  private ContactMethods contactMethods;
  private String browser;
  private DatabaseManager databaseManager;

  public AppManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

    databaseManager = new DatabaseManager();

    if ("".equals(properties.getProperty("selenium.server"))) {
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
    } else {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setBrowserName(browser);
      wd = new RemoteWebDriver(new URL(properties.getProperty("selenium.server")), capabilities);
    }
    wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    wd.get(properties.getProperty("web.baseUrl"));
    sessionMethods = new SessionMethods(wd);
    navigationMethods = new NavigationMethods(wd);
    groupMethods = new GroupMethods(wd);
    contactMethods = new ContactMethods(wd);
    sessionMethods.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
  }

  public SessionMethods getSessionMethods() {
    return sessionMethods;
  }

  public NavigationMethods goTo() {
    return navigationMethods;
  }

  public GroupMethods groupMethods() {
    return groupMethods;
  }

  public ContactMethods contactMethods() {
    return contactMethods;
  }

  public DatabaseManager db() {
    return databaseManager;
  }
}
