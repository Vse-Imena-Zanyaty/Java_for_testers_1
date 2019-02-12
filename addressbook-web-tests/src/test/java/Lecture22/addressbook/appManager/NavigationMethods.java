package Lecture22.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods extends BasicMethods {

  public NavigationMethods(ChromeDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void gotoHomePage() {
    click(By.linkText("home page"));
  }

  public void goHome() {
    click(By.linkText("home"));
  }

  public void gotoContactCreation() {
    click(By.linkText("add new"));
  }

  public void gotoEditContact() {click(By.xpath("//img[@alt='Edit']"));
  }
}
