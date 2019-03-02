package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Group;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class EditGroup extends CommonMethods {

  @Test
  public void testEditGroup() {
    app.getNavigationMethods().gotoGroupPage();
    if (!app.getGroupMethods().existingGroup()) {
      app.getGroupMethods().createGroup(new Group(0, "name", "header", "footer"), app);
    }
    List<Group> before = app.getGroupMethods().getGroupList();
//    int before = app.getGroupMethods().getGroupCount();
    app.getGroupMethods().selectGroup(0);
    app.getGroupMethods().initEditGroup();
    Group group = new Group(before.get(0).getID(), "edited_name", "edited_header", "edited_footer");
    app.getGroupMethods().fillGroupForm(group);
    app.getGroupMethods().submitEditGroup();
    app.getGroupMethods().returnToGroupPage();
    List<Group> after = app.getGroupMethods().getGroupList();
//    int after = app.getGroupMethods().getGroupCount();
    Assert.assertEquals(after.size(), before.size());

    before.remove(0);
    before.add(group);
    Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
  }
}
