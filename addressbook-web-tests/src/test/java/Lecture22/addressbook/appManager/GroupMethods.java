package Lecture22.addressbook.appManager;

import Lecture22.addressbook.objects.Group;
import Lecture22.addressbook.objects.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

/*  public void select(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }*/

  public void selectByID(int ID) {
    wd.findElement(By.cssSelector("input[value='" + ID + "']")).click();
    // wd.findElement(By.cssSelector(String.format("input[value='%s'}", ID))).click();
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
    groupCache = null;
    returnToGroupPage();
  }

  public void modify(Group group) {
    selectByID(group.getID());
    initModification();
    fillForm(group);
    submitModification();
    groupCache = null;
    returnToGroupPage();
  }

/*  public void delete(int index) {
    select(index);
    initDeletion();
    returnToGroupPage();
  }*/

  public void delete(Group group) {
    selectByID(group.getID());
    initDeletion();
    groupCache = null;
    returnToGroupPage();
  }

/*  public void groupExists(AppManager app) {
    app.goTo().GroupPage();
    if (all().size() == 0) {
      create(new Group().withName("name"), app);
    }
  }*/

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

/*  public List<Group> list() {
    List<Group> groups = new ArrayList<Group>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int ID = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groups.add(new Group().withID(ID).withName(name));
    }
    return groups;
  }*/

  private Groups groupCache = null;

  public Groups all() {
    if (groupCache != null) {
      return new Groups(groupCache);
    }

    groupCache = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int ID = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupCache.add(new Group().withID(ID).withName(name));
    }
    return new Groups(groupCache);
  }
}