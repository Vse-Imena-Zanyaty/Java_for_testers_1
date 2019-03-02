package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Group;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupModification extends CommonMethods {

  @Test
  public void testEditGroup() {
    app.getNavigationMethods().gotoGroupPage();
    if (!app.getGroupMethods().existingGroup()) {
      app.getGroupMethods().createGroup(new Group("name", "header", "footer"), app);
    }
    List<Group> before = app.getGroupMethods().getGroupList();
//    int before = app.getGroupMethods().getGroupCount();
    app.getGroupMethods().selectGroup(0);
    app.getGroupMethods().initEditGroup();
    Group group = new Group("edited_name", "edited_header", "edited_footer");
    app.getGroupMethods().fillGroupForm(group);
    app.getGroupMethods().submitEditGroup();
    app.getGroupMethods().returnToGroupPage();
    List<Group> after = app.getGroupMethods().getGroupList();
//    int after = app.getGroupMethods().getGroupCount();
    Assert.assertEquals(after.size(), before.size());

    before.remove(0);
    before.add(group);
    Comparator<? super Group> byID = Comparator.comparingInt(Group::getID);
//    Comparator<? super Group> byID = (g1, g2) -> Integer.compare(g1.getID(), g2.getID());
    before.sort(byID);
    after.sort(byID);
    Assert.assertNotEquals(before, after);
  }
}
