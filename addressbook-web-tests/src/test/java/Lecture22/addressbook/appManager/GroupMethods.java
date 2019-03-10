package Lecture22.addressbook.appManager;

import Lecture22.addressbook.objects.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GroupMethods extends BasicMethods {

  public GroupMethods(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitCreation() {
    click(By.name("submit"));
  }

  public void fillForm(Group group) {
    type(By.name("group_name"), group.getName());
    type(By.name("group_header"), group.getHeader());
    type(By.name("group_footer"), group.getFooter());
  }

  public void initCreation() {
    click(By.name("new"));
  }

  public void initDeletion() {
    click(By.name("delete"));
  }

  public void select(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initModification() {
    click(By.name("edit"));
  }

  public void submitModification() {
    click(By.name("update"));
  }

  public void create(Group group, AppManager app) {
    app.goTo().GroupPage();
    initCreation();
    fillForm(group);
    submitCreation();
    returnToGroupPage();
  }

  public void modify(int index, Group group) {
    select(index);
    initModification();
    fillForm(group);
    submitModification();
    returnToGroupPage();
  }

  public void delete(int index) {
    select(index);
    initDeletion();
    returnToGroupPage();
  }

//  public boolean groupExists() {
//    return isElementPresent(By.name("selected[]"));
//  }

  public void groupExists(AppManager app) {
    app.goTo().GroupPage();
    if (list().size() == 0) {
      create(new Group("name", "header", "footer"), app);
    }
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<Group> list() {
    List<Group> groups = new ArrayList<Group>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int ID = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      Group group = new Group(ID, name, null, null);
      groups.add(group);
    }
    return groups;
  }
}