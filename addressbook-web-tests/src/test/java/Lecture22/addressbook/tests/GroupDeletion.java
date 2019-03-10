package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Group;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupDeletion extends CommonMethods {

  @BeforeMethod
  public void ensurePreconditions() {
    app.groupMethods().groupExists(app);
  }

  @Test
  public void testGroupDeletion() {
    List<Group> before = app.groupMethods().list();
    int index = before.size() - 1;
    app.groupMethods().delete(index);
    List<Group> after = app.groupMethods().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Comparator<? super Group> byID = Comparator.comparingInt(Group::getID);
//    Comparator<? super Group> byID = (g1, g2) -> Integer.compare(g1.getID(), g2.getID());
    before.sort(byID);
    after.sort(byID);
    Assert.assertEquals(before, after);
  }
}
