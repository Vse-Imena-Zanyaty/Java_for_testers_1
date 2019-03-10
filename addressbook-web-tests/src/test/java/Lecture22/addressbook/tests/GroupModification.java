package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Group;
import Lecture22.addressbook.objects.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModification extends CommonMethods {

  @BeforeMethod
  public void ensurePreconditions() {
    app.groupMethods().groupExists(app);
  }

  @Test
  public void testEditGroup() {
    Groups before = app.groupMethods().all();
    Group modifiedGroup = before.iterator().next();
    Group group = new Group()
            .withID(modifiedGroup.getID()).withName("edited_name").withHeader("edited_header").withFooter("edited_footer");
    app.groupMethods().modify(group);
    assertThat(app.groupMethods().count(), equalTo(before.size()));
    Groups after = app.groupMethods().all();
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }
}
