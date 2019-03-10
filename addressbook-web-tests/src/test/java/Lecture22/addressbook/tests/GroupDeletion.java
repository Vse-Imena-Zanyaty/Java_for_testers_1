package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Group;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class GroupDeletion extends CommonMethods {

  @BeforeMethod
  public void ensurePreconditions() {
    app.groupMethods().groupExists(app);
  }

  @Test
  public void testGroupDeletion() {
    Set<Group> before = app.groupMethods().all();
    Group deletedGroup = before.iterator().next();
    app.groupMethods().delete(deletedGroup);
    Set<Group> after = app.groupMethods().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedGroup);
    Assert.assertEquals(before, after);
  }
}
