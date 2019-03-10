package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Group;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class GroupCreation extends CommonMethods {

  @Test
  public void testGroupCreation() {
    app.goTo().GroupPage();
    Set<Group> before = app.groupMethods().all();
    Group group = new Group()
            .withName("name").withHeader("header").withFooter("footer");
    app.groupMethods().create(group, app);
    Set<Group> after = app.groupMethods().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    group.withID(after.stream().mapToInt((g) -> g.getID()).max().getAsInt());
    before.add(group);
    Assert.assertEquals(before, after);
  }
}
