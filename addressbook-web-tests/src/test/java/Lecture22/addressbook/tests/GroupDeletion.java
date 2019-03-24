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
    if (app.db().groups().size() ==0) {
      app.goTo().GroupPage();
      app.groupMethods().create(new Group().withName("name"), app);
    } else { app.goTo().GroupPage(); }
  }

  @Test
  public void testGroupDeletion() {
    Groups before = app.db().groups();
    Group deletedGroup = before.iterator().next();
    app.groupMethods().delete(deletedGroup);
    assertThat(app.groupMethods().count(), equalTo(before.size() - 1));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.without(deletedGroup)));
  }
}
