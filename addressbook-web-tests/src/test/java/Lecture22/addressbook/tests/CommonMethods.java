package Lecture22.addressbook.tests;

import Lecture22.addressbook.appManager.AppManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonMethods {

  public final AppManager app = new AppManager();

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    app.getSessionMethods().stop();
  }

}
