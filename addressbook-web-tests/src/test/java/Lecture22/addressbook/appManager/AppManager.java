package Lecture22.addressbook.appManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class AppManager {
  private WebDriver wd;

  private SessionMethods sessionMethods;
  private NavigationMethods navigationMethods;
  private GroupMethods groupMethods;
  private ContactMethods contactMethods;
  private String browser;

  public AppManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    if (browser.equals(BrowserType.CHROME)) {
      System.setProperty("webdriver.chrome.wd", "C:/Windows/System32/chromedriver.exe");
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.FIREFOX)) {
      System.setProperty("webdriver.firefox.wd", "C:/Windows/System32/geckodriver.exe");
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.IE)) {
      System.setProperty("webdriver.IE.wd", "C:/Windows/System32/IEDriverServer.exe");
      wd = new InternetExplorerDriver();
    }
    wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    sessionMethods = new SessionMethods(wd);
    navigationMethods = new NavigationMethods(wd);
    groupMethods = new GroupMethods(wd);
    contactMethods = new ContactMethods(wd);
    sessionMethods.login("admin", "secret");
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
}
