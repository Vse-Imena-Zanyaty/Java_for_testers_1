package Lecture22.addressbook.tests;

import Lecture22.addressbook.appManager.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonMethods {

  public static final AppManager app = new AppManager(BrowserType.CHROME);

  @BeforeSuite(alwaysRun = true)
  public void setUp() {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.getSessionMethods().stop();
  }

}
