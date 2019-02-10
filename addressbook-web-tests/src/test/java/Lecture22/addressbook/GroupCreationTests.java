package Lecture22.addressbook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.*;

public class GroupCreationTests {
  private ChromeDriver wd;

  @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.wd", "C:/Windows/System32/chromedriver.exe");
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("admin");
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys("secret");
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testGroupCreation() throws Exception {
    wd.findElement(By.linkText("groups")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | link=groups | ]]
    wd.findElement(By.name("new")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | name=new | ]]
    wd.findElement(By.name("group_name")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | name=group_name | ]]
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys("group1");
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys("header1");
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys("comment1");
    wd.findElement(By.name("submit")).click();
    wd.findElement(By.linkText("group page")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.findElement(By.linkText("Logout")).click();
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
