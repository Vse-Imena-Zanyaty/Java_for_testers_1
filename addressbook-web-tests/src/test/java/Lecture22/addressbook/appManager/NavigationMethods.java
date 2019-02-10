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
}
