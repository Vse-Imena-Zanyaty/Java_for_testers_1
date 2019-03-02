package Lecture22.addressbook.appManager;

import Lecture22.addressbook.objects.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupMethods extends BasicMethods {

  public GroupMethods(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(Group group) {
    type(By.name("group_name"), group.getName());
    type(By.name("group_header"), group.getHeader());
    type(By.name("group_footer"), group.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void initGroupDeletion() {
    click(By.name("delete"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void initEditGroup() { click(By.name("edit")); }

  public void submitEditGroup() {click(By.name("update")); }

  public void createGroup(Group group, AppManager app) {
    app.getNavigationMethods().gotoGroupPage();
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public boolean existingGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
