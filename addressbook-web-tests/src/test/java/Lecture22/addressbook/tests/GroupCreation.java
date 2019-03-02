package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Group;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreation extends CommonMethods {

  @Test
  public void testGroupCreation() {
    app.getNavigationMethods().gotoGroupPage();
    List<Group> before = app.getGroupMethods().getGroupList();
//    int before = app.getGroupMethods().getGroupCount();
    Group group = new Group(0, "new2", "header", "footer");
    app.getGroupMethods().createGroup(group, app);
    List<Group> after = app.getGroupMethods().getGroupList();
//    int after = app.getGroupMethods().getGroupCount();
    Assert.assertEquals(after.size(), before.size() + 1);

    group.setID(after.stream().max(Comparator.comparingInt(Group::getID)).get().getID());
//    group.setID(after.stream().max((o1, o2) -> Integer.compare(o1.getID(),o2.getID())).get().getID());
    before.add(group);
    Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
  }
}
