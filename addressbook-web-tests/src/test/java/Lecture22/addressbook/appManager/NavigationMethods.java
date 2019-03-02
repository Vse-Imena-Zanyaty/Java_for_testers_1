package Lecture22.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationMethods extends BasicMethods {

  public NavigationMethods(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void gotoHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home page"));
  }

  public void goHome() {
    click(By.linkText("home"));
  }

  public void gotoContactCreation() {
    click(By.linkText("add new"));
  }

  public void gotoEditContact(int index) {
    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
  }
//  public void gotoEditContact() {click(By.xpath("//img[@alt='Edit']")); }
}
