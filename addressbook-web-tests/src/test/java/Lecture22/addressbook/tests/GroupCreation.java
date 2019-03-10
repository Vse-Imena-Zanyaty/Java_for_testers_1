package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Group;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupCreation extends CommonMethods {

  @Test
  public void testGroupCreation() {
    app.goTo().GroupPage();
    List<Group> before = app.groupMethods().list();
//    int before = app.groupMethods().getGroupCount();
    Group group = new Group()
            .withName("name").withHeader("header").withFooter("footer");
    app.groupMethods().create(group, app);
    List<Group> after = app.groupMethods().list();
//    int after = app.groupMethods().getGroupCount();
    Assert.assertEquals(after.size(), before.size() + 1);

    group.withID(after.stream().max(Comparator.comparingInt(Group::getID)).get().getID());
//    group.withID(after.stream().max((o1, o2) -> Integer.compare(o1.getID(),o2.getID())).get().getID());
    before.add(group);
    Comparator<? super Group> byID = Comparator.comparingInt(Group::getID);
    before.sort(byID);
    after.sort(byID);
    Assert.assertEquals(before, after);
  }
}
