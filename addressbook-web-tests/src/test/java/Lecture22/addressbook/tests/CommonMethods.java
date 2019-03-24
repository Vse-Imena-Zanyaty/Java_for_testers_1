package Lecture22.addressbook.tests;

import Lecture22.addressbook.appManager.AppManager;
import Lecture22.addressbook.objects.Contact;
import Lecture22.addressbook.objects.Contacts;
import Lecture22.addressbook.objects.Group;
import Lecture22.addressbook.objects.Groups;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CommonMethods {

  Logger logger = LoggerFactory.getLogger(CommonMethods.class);

  public static final AppManager app
          = new AppManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite
  public void setUp() throws IOException {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.getSessionMethods().stop();
  }

  @BeforeMethod
  public void logTestStart(Method m, Object[] p) {
    logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m) {
    logger.info("Stop test " + m.getName());
  }

  public void verifyGroupListInUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.groupMethods().all();
      assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new Group().withID(g.getID()).withName(g.getName()))
              .collect(Collectors.toSet())));
    }
  }

  public void verifyContactListInUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Contacts dbContacts = app.db().contacts();
      Contacts uiContacts = app.contactMethods().all();
      assertThat(uiContacts, equalTo(dbContacts.stream()
              .map((g) -> new Contact().withID(g.getID()).withFirstName(g.getFirstName())
                      .withLastName(g.getLastName()).withAddress(g.getAddress()))
              .collect(Collectors.toSet())));
    }
  }
}