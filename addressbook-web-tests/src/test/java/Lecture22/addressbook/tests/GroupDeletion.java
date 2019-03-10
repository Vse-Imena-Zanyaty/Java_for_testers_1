package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Group;
import Lecture22.addressbook.objects.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletion extends CommonMethods {

  @BeforeMethod
  public void ensurePreconditions() {
    app.groupMethods().groupExists(app);
  }

  @Test
  public void testGroupDeletion() {
    Groups before = app.groupMethods().all();
    Group deletedGroup = before.iterator().next();
    app.groupMethods().delete(deletedGroup);
    Groups after = app.groupMethods().all();
    assertThat(after.size(), equalTo(before.size() - 1));
    assertThat(after, equalTo(before.without(deletedGroup)));
  }
}
