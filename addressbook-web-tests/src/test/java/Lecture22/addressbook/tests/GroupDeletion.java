package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Group;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletion extends CommonMethods {

  @Test
  public void testGroupDeletion() {
    app.getNavigationMethods().gotoGroupPage();
    if (!app.getGroupMethods().existingGroup()) {
      app.getGroupMethods().createGroup(new Group(0, "name", "header", "footer"), app);
    }
    List<Group> before = app.getGroupMethods().getGroupList();
//    int before = app.getGroupMethods().getGroupCount();
    app.getGroupMethods().selectGroup(before.size() - 1);
    app.getGroupMethods().initGroupDeletion();
    app.getGroupMethods().returnToGroupPage();
    List<Group> after = app.getGroupMethods().getGroupList();
//    int after = app.getGroupMethods().getGroupCount();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
//    for (int i = 0; i < after.size(); i++) {
    Assert.assertEquals(before, after);
  }
}
