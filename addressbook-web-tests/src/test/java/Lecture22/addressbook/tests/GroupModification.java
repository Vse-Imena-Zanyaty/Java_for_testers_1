package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Group;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupModification extends CommonMethods {

  @BeforeMethod
  public void ensurePreconditions() {
    app.groupMethods().groupExists(app);
  }

  @Test
  public void testEditGroup() {
    List<Group> before = app.groupMethods().list();
    int index = before.size() - 1;
    Group group = new Group(before.get(index).getID(), "edited_name", "edited_header", "edited_footer");
//    int before = app.groupMethods().getGroupCount();
    app.groupMethods().modify(index, group);
    List<Group> after = app.groupMethods().list();
//    int after = app.groupMethods().getGroupCount();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(group);
    Comparator<? super Group> byID = Comparator.comparingInt(Group::getID);
//    Comparator<? super Group> byID = (g1, g2) -> Integer.compare(g1.getID(), g2.getID());
    before.sort(byID);
    after.sort(byID);
    Assert.assertEquals(before, after);
  }
}
