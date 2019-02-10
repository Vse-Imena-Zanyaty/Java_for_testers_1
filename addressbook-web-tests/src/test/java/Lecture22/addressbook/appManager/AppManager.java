package Lecture22.addressbook.appManager;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AppManager {
  private ChromeDriver wd;

  private SessionMethods sessionMethods;
  private NavigationMethods navigationMethods;
  private GroupMethods groupMethods;
  private ContactMethods contactMethods;

  public void init() {
    System.setProperty("webdriver.chrome.wd", "C:/Windows/System32/chromedriver.exe");
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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

  public NavigationMethods getNavigationMethods() {
    return navigationMethods;
  }

  public GroupMethods getGroupMethods() {
  return groupMethods;
  }

  public ContactMethods getContactMethods() {
    return contactMethods;
  }
}
