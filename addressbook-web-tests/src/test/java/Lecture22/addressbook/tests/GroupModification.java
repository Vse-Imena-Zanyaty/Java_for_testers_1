package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Group;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class GroupModification extends CommonMethods {

  @BeforeMethod
  public void ensurePreconditions() {
    app.groupMethods().groupExists(app);
  }

  @Test
  public void testEditGroup() {
    Set<Group> before = app.groupMethods().all();
    Group modifiedGroup = before.iterator().next();
        Group group = new Group()
            .withID(modifiedGroup.getID()).withName("edited_name").withHeader("edited_header").withFooter("edited_footer");
    app.groupMethods().modify(group);
    Set<Group> after = app.groupMethods().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedGroup);
    before.add(group);
    Assert.assertEquals(before, after);
  }
}
