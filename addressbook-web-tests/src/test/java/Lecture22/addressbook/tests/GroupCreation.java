package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Group;
import Lecture22.addressbook.objects.Groups;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreation extends CommonMethods {

  @Test
  public void testGroupCreation() {
    app.goTo().GroupPage();
    Groups before = app.groupMethods().all();
    Group group = new Group()
            .withName("name").withHeader("header").withFooter("footer");
    app.groupMethods().create(group, app);
    Groups after = app.groupMethods().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before
            .withAdded(group.withID(after.stream().mapToInt((g) -> g.getID()).max().getAsInt()))));
  }
}
