package Lecture22.addressbook.appManager;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AppManager {
  private ChromeDriver wd;

  private SessionMethods sessionMethods;
  private NavigationMethods navigationMethods;
  private GroupMethods groupMethods;

  public void init() {
    System.setProperty("webdriver.chrome.wd", "C:/Windows/System32/chromedriver.exe");
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    sessionMethods = new SessionMethods(wd);
    navigationMethods = new NavigationMethods(wd);
    groupMethods = new GroupMethods(wd);
    sessionMethods.login("admin", "secret");
  }

  public SessionMethods getSessionMethods() {
    return sessionMethods;
  }

  public void stop() {
    sessionMethods.stop();
  }

  public NavigationMethods getNavigationMethods() {
    return navigationMethods;
  }

  public void gotoGroupPage() {
    navigationMethods.gotoGroupPage();
  }

  public GroupMethods getGroupMethods() {
  return groupMethods;
  }
}
