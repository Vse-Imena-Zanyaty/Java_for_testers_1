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
  private UiMethods uiMethods;
  private FtpMethods ftp;
  private MailServer mailServer;
  private JamesServer jamesServer;
  private DatabaseManager databaseManager;

  public AppManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

    databaseManager = new DatabaseManager();
  }

  public void stop() {
    if (wd != null) {
      wd.quit();
    }
  }

  public HttpSession newSession() {
    return new HttpSession(this);
  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }

/*  public UiMethods registration() {
    if (uiMethods == null) {
      uiMethods = new UiMethods(this);
    }
    return uiMethods;
  }*/

  public UiMethods uiMethods() {
    if (uiMethods == null) {
      uiMethods = new UiMethods(this);
    }
    return uiMethods;
  }

  public FtpMethods ftp() {
    if (ftp == null) {
      ftp = new FtpMethods(this);
    }
    return ftp;
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

  public MailServer mail() {
    if (mailServer == null) {
      mailServer = new MailServer(this);
    }
    return mailServer;
  }

  public JamesServer james() {
    if (jamesServer == null) {
      jamesServer = new JamesServer(this);
    }
    return jamesServer;
  }

  public DatabaseManager db() {
    return databaseManager;
  }
}
