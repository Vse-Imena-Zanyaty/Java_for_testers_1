package Lecture22.addressbook.tests;

import Lecture22.addressbook.appManager.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonMethods {

  public final AppManager app = new AppManager(BrowserType.CHROME);

  @BeforeMethod(alwaysRun = true)
  public void setUp() {
    app.init();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    app.getSessionMethods().stop();
  }

}
