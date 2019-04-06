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
    if (app.db().groups().size() ==0) {
      app.groupMethods().create(new Group().withName("testEditGroup"), app);
    } else { app.goTo().GroupPage(); }
  }

  @Test
  public void testEditGroup() {
    Groups before = app.db().groups();
    Group modifiedGroup = before.iterator().next();
    Group group = new Group()
            .withID(modifiedGroup.getID()).withName("edited_name").withHeader("edited_header").withFooter("edited_footer");
    app.groupMethods().modify(group);
    assertThat(app.groupMethods().count(), equalTo(before.size()));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    verifyGroupListInUI(); //-DverifyUI=true
  }
}
